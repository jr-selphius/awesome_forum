package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.domain.{Community, CommunityId, CommunityName, CommunityRepository}

final class CommunityCreator(communityRepository: CommunityRepository) {
  def create(communityId: CommunityId, communityName: CommunityName): Unit = {
    val community = Community(communityId, communityName)
    communityRepository.save(community)
  }
}
