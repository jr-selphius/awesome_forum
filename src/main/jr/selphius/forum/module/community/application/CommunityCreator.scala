package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.domain.{Community, CommunityId, CommunityTitle, CommunityRepository}

final class CommunityCreator(communityRepository: CommunityRepository) {
  def create(communityId: CommunityId, communityTitle: CommunityTitle): Unit = {
    val community = Community(communityId, communityTitle)
    communityRepository.save(community)
  }
}
