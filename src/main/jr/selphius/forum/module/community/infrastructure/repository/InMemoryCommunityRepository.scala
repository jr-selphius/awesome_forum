package jr.selphius.forum.module.community.infrastructure.repository

import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}

import scala.concurrent.Future

final class InMemoryCommunityRepository extends CommunityRepository {

  private var communities = Seq[Community]()

  override def getAll(): Future[Seq[Community]] = Future.successful(communities)

  override def save(community: Community): Unit = communities = communities :+ community
}
