package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import jr.selphius.forum.module.user.domain.UserMother
import jr.selphius.forum.module.user.infrastructure.marshaller.UserMarshallerTest
import spray.json._
import doobie.implicits._
import org.scalatest.BeforeAndAfterEach

final class UserSpec extends AcceptanceSpec with BeforeAndAfterEach {

  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanUsersTable()
  }

  "save a user" in post(
    "/users",
    """
      |{
      |  "id": "a11098af-d352-4cce-8372-2b48b97e7042",
      |  "username": "The new user",
      |  "email": "email@example.com"
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "update an user" in {

    val user = UserMother.random

    userDependencies.repository.save(user)

    put(
      "/users",
      s"""
        |{
        |  "id": "${user.id.value.toString}",
        |  "username": "The name updated",
        |  "email": "anotheremail@example2.com"
        |}
      """.stripMargin
    ) {
      status shouldBe StatusCodes.NoContent
    }
  }

  "delete an user" in {

    val user = UserMother.random

    userDependencies.repository.save(user)

    delete(s"/users/${user.id.value}") {
      status shouldBe StatusCodes.NoContent
    }
  }

  "return all the system users" in {

    val users = UserMother.randomSeq

    users.foreach(user => userDependencies.repository.save(user))

    get("/users") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserMarshallerTest.marshall(users)
    }
  }
}
