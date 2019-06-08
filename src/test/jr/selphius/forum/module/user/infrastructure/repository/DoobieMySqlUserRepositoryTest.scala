package jr.selphius.forum.module.user.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.user.UserIntegrationTestCase
import jr.selphius.forum.module.user.domain.UserMother
import org.scalatest.BeforeAndAfterEach
import org.scalatest.concurrent.ScalaFutures._

final class DoobieMySqlUserRepositoryTest extends UserIntegrationTestCase with BeforeAndAfterEach {

  private def cleanUsersTable() = {
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue
  }

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanUsersTable()
  }

  "Doobie MySql User Repository" should {
    "return an empty seq if there aren't users" in {
      whenReady(repository.getAll()) {
        _ shouldBe Seq.empty
      }
    }

    "search all users" in {
      val expectedUsers = UserMother.randomSeq

      expectedUsers.foreach(user => repository.save(user))

      whenReady(repository.getAll()) {
        _ shouldBe expectedUsers
      }
    }
  }
}
