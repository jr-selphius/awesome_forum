package jr.selphius.forum.module.community.infrastructure.dependency_injection

import jr.selphius.forum.module.community.application.CommunitiesSearcher
import jr.selphius.forum.module.community.infrastructure.repository.InMemoryCommunityRepository

final class CommunityModuleDependencyContainer {

  val inMemoryCommunityRepository = new InMemoryCommunityRepository

  val communitiesSearcher: CommunitiesSearcher = new CommunitiesSearcher(inMemoryCommunityRepository)
}
