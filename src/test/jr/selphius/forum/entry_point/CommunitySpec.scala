package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.community.infrastructure.marshaller.CommunityMarshallerTest
import jr.selphius.forum.module.community.infrastructure.stub.CommunityStub
import spray.json._

final class CommunitySpec extends AcceptanceSpec {

  "return all the system communities" in {
    get("/communities") {
      val expectedCommunities = Seq(
        CommunityStub(id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee", title = "🎥 Scala FTW vol. 1"),
        CommunityStub(id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97", title = "🔝 Interview with Odersky")
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe CommunityMarshallerTest.marshall(expectedCommunities)
    }
  }
}
