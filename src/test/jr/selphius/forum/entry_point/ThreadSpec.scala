package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import doobie.implicits._
import jr.selphius.forum.module.community.domain.CommunityMother
import jr.selphius.forum.module.thread.domain.{SubjectMother, Thread, ThreadIdMother, ThreadMother}
import jr.selphius.forum.module.thread.infrastructure.marshaller.ThreadMarshallerTest
import jr.selphius.forum.module.user.domain.UserMother
import org.scalatest.BeforeAndAfterEach
import spray.json._

final class ThreadSpec extends AcceptanceSpec with BeforeAndAfterEach {

  private def cleanThreadsTable() =
    sql"TRUNCATE TABLE threads".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanThreadsTable()
  }

  "save a thread" in {

    val creator   = UserMother.random
    val community = CommunityMother.random

    userContainer.repository.save(creator)
    communityContainer.repository.save(community)

    post(
      "/threads",
      s"""
        |{
        |  "subject": "The subject of the thread",
        |  "creator_id": "${creator.id.value.toString}",
        |  "community_id": "${community.id.value.toString}"
        |}
      """.stripMargin
    ) {
      status shouldBe StatusCodes.NoContent
    }
  }

  "update an thread" in {

    val creator   = UserMother.random
    val community = CommunityMother.random
    val thread    = Thread(ThreadIdMother.random, SubjectMother.random, creator.id, community.id)

    userContainer.repository.save(creator)
    communityContainer.repository.save(community)
    threadContainer.repository.save(thread)

    val newCommunity = CommunityMother.random

    put(
      "/threads",
      s"""
        |{
        | "id": "${thread.id.value.toString}",
        | "subject": "New subject",
        | "creator_id": "${thread.creatorId.value.toString}",
        | "community_id": "${newCommunity.id.value.toString}"
        |}
      """.stripMargin
    ) {
      status shouldBe StatusCodes.NoContent
    }
  }

  "delete a thread" in {

    val thread = ThreadMother.random

    threadContainer.repository.save(thread)

    delete(s"/threads/${thread.id.value}") {
      status shouldBe StatusCodes.NoContent
    }
  }

  "return all the system threads" in {

    val threads = ThreadMother.randomSeq

    threads.foreach(thread => threadContainer.repository.save(thread))

    get("/threads") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe ThreadMarshallerTest.marshall(threads)
    }
  }
}
