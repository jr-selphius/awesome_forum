package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.community.domain.{Community, CommunityMother}
import jr.selphius.forum.module.community.infrastructure.marshaller.CommunityMarshallerTest
import spray.json._
import doobie.implicits._

final class CommunitySpec extends AcceptanceSpec {

  private def cleanCommunitiesTable() =
    sql"TRUNCATE TABLE communities".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

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

    cleanCommunitiesTable()

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

  "return all the system communities" in {

    cleanCommunitiesTable()

    val communities = CommunityMother.randomSeq

    communities.foreach(communityContainer.repository.save)

    get("/communities") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe CommunityMarshallerTest.marshall(communities)
    }
  }
}
