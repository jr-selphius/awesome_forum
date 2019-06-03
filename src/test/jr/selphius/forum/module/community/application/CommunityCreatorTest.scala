package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.CommunityUnitTestCase
import jr.selphius.forum.module.community.domain.CommunityMother

final class CommunityCreatorTest extends CommunityUnitTestCase {
  private val communityCreator = new CommunityCreator(repository)

  "Community Creator" should {
    "save a community" in {
      val community = CommunityMother.random

      repositoryShouldSaveCommunity(community)

      communityCreator.create(community.id, community.title) should be
    }
  }
}
