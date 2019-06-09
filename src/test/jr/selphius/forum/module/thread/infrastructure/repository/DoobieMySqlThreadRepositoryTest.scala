package jr.selphius.forum.module.thread.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.thread.ThreadIntegrationTestCase
import jr.selphius.forum.module.thread.domain.ThreadMother
import org.scalatest.BeforeAndAfterEach
import org.scalatest.concurrent.ScalaFutures._

final class DoobieMySqlThreadRepositoryTest extends ThreadIntegrationTestCase with BeforeAndAfterEach {

  private def cleanThreadsTable() = {
    sql"TRUNCATE TABLE threads".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue
  }

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanThreadsTable()
  }

  "Doobie MySql Thread Repository" should {
    "return an empty seq if there aren't threads" in {
      whenReady(repository.getAll()) {
        _ shouldBe Seq.empty
      }
    }

    "search all threads" in {
      val expectedThreads = ThreadMother.randomSeq

      expectedThreads.foreach(thread => repository.save(thread))

      whenReady(repository.getAll()) {
        _ shouldBe expectedThreads
      }
    }
  }
}
