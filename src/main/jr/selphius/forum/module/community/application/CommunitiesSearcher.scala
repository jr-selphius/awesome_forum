package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}

import scala.concurrent.Future

final class CommunitiesSearcher(communityRepository: CommunityRepository) {

  def searchAll(): Future[Seq[Community]] = communityRepository.getAll()
}
