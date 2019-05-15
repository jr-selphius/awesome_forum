package jr.selphius.forum.module.community

import jr.selphius.forum.module.IntegrationTestCase
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.community.infrastructure.repository.InMemoryCommunityRepository

protected[community] trait CommunityIntegrationTestCase extends IntegrationTestCase {
  private val container                                 = new CommunityModuleDependencyContainer
  protected val repository: InMemoryCommunityRepository = container.repository
}
