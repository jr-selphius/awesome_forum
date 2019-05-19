package jr.selphius.forum.module.community.infrastructure.repository

import jr.selphius.forum.module.community.CommunityIntegrationTestCase
import jr.selphius.forum.module.community.domain.CommunityStub
import org.scalatest.concurrent.ScalaFutures._

final class InMemoryCommunityRepositoryTest extends CommunityIntegrationTestCase {

  "In memory community repository" should {
    "search all existing communities" in {
      val community        = CommunityStub.random
      val anotherCommunity = CommunityStub.random
      val communities      = Seq(community, anotherCommunity)

      repository.save(community)
      repository.save(anotherCommunity)

      whenReady(repository.getAll()) {
        _ shouldBe communities
      }
    }
  }

}
