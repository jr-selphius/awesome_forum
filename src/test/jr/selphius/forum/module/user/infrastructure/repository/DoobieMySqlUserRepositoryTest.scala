package jr.selphius.forum.module.user.infrastructure.repository

import cats.implicits._
import doobie.implicits._
import org.scalatest.concurrent.ScalaFutures._
import doobie.util.update.Update
import jr.selphius.forum.module.user.UserIntegrationTestCase
import jr.selphius.forum.module.user.domain.{User, UserStub}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

final class DoobieMySqlUserRepositoryTest extends UserIntegrationTestCase {

  def insert(users: Seq[User]) = {
    Update[User]("INSERT INTO users(user_id, name) VALUES (?, ?)")
      .updateMany(users.toVector)
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .value
  }

  def cleanUsersTable() = {
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue
  }

  "Doobie MySql User Repository" should {
    "return an empty seq if there aren't users" in {
      whenReady(repository.getAll()) {
        _ shouldBe Seq.empty
      }
    }

    "search all users" in {
      val expectedUsers = UserStub.randomSeq

      insert(expectedUsers)

      whenReady(repository.getAll()) {
        _ shouldBe expectedUsers
      }

      cleanUsersTable()
    }
  }
}
