package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.user.domain.UserStub
import jr.selphius.forum.module.user.infrastructure.marshaller.UserMarshallerTest
import spray.json._
import doobie.implicits._

final class UserSpec extends AcceptanceSpec {

  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

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

    cleanUsersTable()

    val users = UserStub.randomSeq

    users.foreach(user => userDependencies.repository.save(user))

    get("/users") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserMarshallerTest.marshall(users)
    }
  }
}
