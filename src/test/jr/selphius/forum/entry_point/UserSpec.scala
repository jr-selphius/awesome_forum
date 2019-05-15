package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.user.domain.UserStub
import jr.selphius.forum.module.user.infrastructure.marshaller.UserMarshallerTest
import spray.json._

final class UserSpec extends AcceptanceSpec {

  "save a user" in post(
    "/users",
    """
      |{
      |  "id": "a11098af-d352-4cce-8372-2b48b97e7042",
      |  "name": "The new user"
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "return all the system users" in {
    get("/users") {
      val expectedUsers = Seq(
        UserStub(id = "a11098af-d352-4cce-8372-2b48b97e7042", name = "The new user")
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserMarshallerTest.marshall(expectedUsers)
    }
  }
}
