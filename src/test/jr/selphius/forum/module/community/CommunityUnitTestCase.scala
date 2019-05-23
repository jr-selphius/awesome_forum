package jr.selphius.forum.module.community

import jr.selphius.forum.module.UnitTestCase
import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}

import scala.concurrent.Future

protected[community] trait CommunityUnitTestCase extends UnitTestCase {
  protected val repository: CommunityRepository = mock[CommunityRepository]

  protected def repositoryShouldSearchAllCommunities(communities: Seq[Community]): Unit =
    (repository.getAll _)
      .expects()
      .returning(Future.successful(communities))

  protected def repositoryShouldSaveVideo(community: Community): Unit =
    (repository.save _)
      .expects(community)
      .returning(Future.unit)
}
