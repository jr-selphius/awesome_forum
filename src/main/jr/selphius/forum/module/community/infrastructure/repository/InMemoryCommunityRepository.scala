package jr.selphius.forum.module.community.infrastructure.repository

import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}

final class InMemoryCommunityRepository extends CommunityRepository {

  private var communities = Seq[Community]()

  override def getAll(): Seq[Community] = communities

  override def save(community: Community): Unit = communities = communities :+ community
}
