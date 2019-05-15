package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.community.domain.CommunityStub
import jr.selphius.forum.module.community.infrastructure.marshaller.CommunityMarshallerTest
import spray.json._

final class CommunitySpec extends AcceptanceSpec {

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

  "return all the system communities" in {
    get("/communities") {
      val expectedCommunities =
        Seq(CommunityStub(id = "a11098af-d352-4cce-8372-2b48b97e6942", title = "The new community"))

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe CommunityMarshallerTest.marshall(expectedCommunities)
    }
  }
}
