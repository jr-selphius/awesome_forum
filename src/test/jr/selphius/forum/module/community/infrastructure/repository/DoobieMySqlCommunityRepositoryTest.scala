package jr.selphius.forum.module.community.infrastructure.repository

import cats.implicits._
import doobie.implicits._
import doobie.util.update.Update
import org.scalatest.concurrent.ScalaFutures._
import jr.selphius.forum.module.community.CommunityIntegrationTestCase
import jr.selphius.forum.module.community.domain.{Community, CommunityStub}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

final class DoobieMySqlCommunityRepositoryTest extends CommunityIntegrationTestCase {

  def insert(communities: Seq[Community]) = {
    Update[Community]("INSERT INTO communities(community_id, title) VALUES (?, ?)")
      .updateMany(communities.toVector)
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .value
  }

  def cleanCommunitiesTable() = {
    sql"TRUNCATE TABLE communities".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue
  }

  "Doobie MySql Community Repository" should {
    "return an empty seq if there aren't communities" in {
      whenReady(repository.getAll()) {
        _ shouldBe Seq.empty
      }
    }

    "search all communities" in {
      val expectedCommunities = CommunityStub.randomSeq

      insert(expectedCommunities)

      whenReady(repository.getAll()) {
        _ shouldBe expectedCommunities
      }

      cleanCommunitiesTable()
    }
  }
}
