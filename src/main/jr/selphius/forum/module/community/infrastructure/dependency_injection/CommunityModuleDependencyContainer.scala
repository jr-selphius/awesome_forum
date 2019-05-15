package jr.selphius.forum.module.community.infrastructure.dependency_injection

import jr.selphius.forum.module.community.application.CommunitiesSearcher

final class CommunityModuleDependencyContainer {
  val communitiesSearcher: CommunitiesSearcher = new CommunitiesSearcher
}
