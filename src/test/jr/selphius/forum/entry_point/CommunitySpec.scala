package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import doobie.implicits._
import jr.selphius.forum.module.community.domain.CommunityMother
import jr.selphius.forum.module.community.infrastructure.marshaller.CommunityMarshallerTest
import org.scalatest.BeforeAndAfterEach
import spray.json._

final class CommunitySpec extends AcceptanceSpec with BeforeAndAfterEach {

  private def cleanCommunitiesTable() =
    sql"TRUNCATE TABLE communities".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanCommunitiesTable()
  }

  "save a community" in post(
    "/communities",
    """
      |{
      |  "id": "a11098af-d352-4cce-8372-2b48b97e6942",
      |  "title": "The new community"
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "update a community" in {

    val community = CommunityMother.random

    communityContainer.repository.save(community)

    put(
      "/communities",
      s"""
        |{
        |  "id": "${community.id.value.toString}",
        |  "title": "The new community"
        |}
      """.stripMargin
    ) {
      status shouldBe StatusCodes.NoContent
    }
  }

  "delete a community" in {

    val community = CommunityMother.random

    communityContainer.repository.save(community)

    delete(s"/communities/${community.id.value}") {
      status shouldBe StatusCodes.NoContent
    }
  }

  "return all the system communities" in {

    val communities = CommunityMother.randomSeq

    communities.foreach(communityContainer.repository.save)

    get("/communities") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe CommunityMarshallerTest.marshall(communities)
    }
  }
}
