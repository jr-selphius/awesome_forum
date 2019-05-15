package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.CommunityUnitTestCase
import jr.selphius.forum.module.community.domain.CommunityStub

final class CommunityCreatorTest extends CommunityUnitTestCase {
  private val communityCreator = new CommunityCreator(repository)

  "Community Creator" should {
    "save a community" in {
      val community = CommunityStub.random

      repositoryShouldSaveVideo(community)

      communityCreator.create(community.id, community.title) should be
    }
  }
}