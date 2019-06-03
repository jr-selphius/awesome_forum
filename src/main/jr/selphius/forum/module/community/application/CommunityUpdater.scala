package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.domain.{Community, CommunityId, CommunityRepository, CommunityTitle}

final class CommunityUpdater(communityRepository: CommunityRepository) {
  def update(communityId: CommunityId, communityTitle: CommunityTitle): Unit = {
    val community = Community(communityId, communityTitle)
    communityRepository.update(community)
  }
}
