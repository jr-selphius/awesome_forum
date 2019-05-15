package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.user.infrastructure.marshaller.UserMarshallerTest
import jr.selphius.forum.module.user.infrastructure.stub.UserStub
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
        UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
        UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserMarshallerTest.marshall(expectedUsers)
    }
  }
}
