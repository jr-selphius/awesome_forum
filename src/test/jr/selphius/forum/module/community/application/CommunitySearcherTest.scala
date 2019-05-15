package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.CommunityUnitTestCase
import jr.selphius.forum.module.community.domain.CommunityStub

final class CommunitySearcherTest extends CommunityUnitTestCase {
  private val communitySearcher = new CommunitiesSearcher(repository)

  "Community Searcher" should {
    "search all existing communities" in {
      val existingCommunities = Seq(CommunityStub.random, CommunityStub.random)

      repositoryShouldSearchAllCommunities(existingCommunities)

      communitySearcher.searchAll() shouldBe existingCommunities
    }
  }
}