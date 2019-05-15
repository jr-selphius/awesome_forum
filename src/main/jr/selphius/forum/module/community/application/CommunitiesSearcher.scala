package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}

final class CommunitiesSearcher(communityRepository: CommunityRepository) {

  def searchAll(): Seq[Community] = communityRepository.getAll()
}
