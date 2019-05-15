package jr.selphius.forum.module.community.infrastructure.dependency_injection

import jr.selphius.forum.module.community.application.{CommunitiesSearcher, CommunityCreator}
import jr.selphius.forum.module.community.infrastructure.repository.InMemoryCommunityRepository

final class CommunityModuleDependencyContainer {

  val repository = new InMemoryCommunityRepository

  val communitiesSearcher: CommunitiesSearcher = new CommunitiesSearcher(repository)

  val communitiesCreator: CommunityCreator = new CommunityCreator(repository)
}
