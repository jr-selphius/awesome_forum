package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.CommunityUnitTestCase
import jr.selphius.forum.module.community.domain.CommunityMother
import org.scalatest.concurrent.ScalaFutures._

final class CommunitySearcherTest extends CommunityUnitTestCase {
  private val communitySearcher = new CommunitiesSearcher(repository)

  "Community Searcher" should {
    "search all existing communities" in {
      val existingCommunities = Seq(CommunityMother.random, CommunityMother.random)

      repositoryShouldSearchAllCommunities(existingCommunities)

      whenReady(communitySearcher.searchAll()) {
        _ shouldBe existingCommunities
      }
    }
  }
}
