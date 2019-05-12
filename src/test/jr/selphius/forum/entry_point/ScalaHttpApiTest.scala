package jr.selphius.forum.entry_point

import akka.http.scaladsl.model._
import spray.json._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import jr.selphius.forum.module.community.infrastructure.marshaller.CommunityMarshaller
import jr.selphius.forum.module.community.infrastructure.stub.CommunityStub
import jr.selphius.forum.module.user.infrastructure.marshaller.UserMarshaller
import jr.selphius.forum.module.user.infrastructure.stub.UserStub
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

final class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  "ScalaHttpApi" should {

    "return all the system communities" in {
      Get("/communities") ~> Routes.all ~> check {
        val expectedCommunities = Seq(
          CommunityStub(id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee", title = "🎥 Scala FTW vol. 1"),
          CommunityStub(id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97", title = "🔝 Interview with Odersky")
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe CommunityMarshaller.marshall(expectedCommunities)
      }
    }

    "return all the system users" in {
      Get("/users") ~> Routes.all ~> check {
        val expectedUsers = Seq(
          UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
          UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
      }
    }
  }
}
