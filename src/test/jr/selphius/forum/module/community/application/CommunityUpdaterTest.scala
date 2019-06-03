package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.CommunityUnitTestCase
import jr.selphius.forum.module.community.domain.CommunityMother

final class CommunityUpdaterTest extends CommunityUnitTestCase {
  private val communityUpdater = new CommunityUpdater(repository)

  "Community Updater" should {
    "update a community" in {
      val community = CommunityMother.random

      repositoryShouldUpdateCommunity(community)

      communityUpdater.update(community.id, community.title) should be
    }
  }
}
