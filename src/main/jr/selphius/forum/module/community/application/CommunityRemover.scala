package jr.selphius.forum.module.community.application

import jr.selphius.forum.module.community.domain.{CommunityId, CommunityRepository}

final class CommunityRemover(communityRepository: CommunityRepository) {
  def remove(id: CommunityId): Unit = {
    communityRepository.remove(id)
  }
}
