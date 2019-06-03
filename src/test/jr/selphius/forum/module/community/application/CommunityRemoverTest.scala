package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.CommunityUnitTestCase
import jr.selphius.forum.module.community.domain.CommunityMother

final class CommunityRemoverTest extends CommunityUnitTestCase {
  private val communityRemover = new CommunityRemover(repository)

  "Community Remover" should {
    "remove a community" in {
      val community = CommunityMother.random

      repositoryShouldRemoveCommunity(community.id)

      communityRemover.remove(community.id) should be
    }
  }
}
