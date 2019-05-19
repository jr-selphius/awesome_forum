package jr.selphius.forum.module.community

import jr.selphius.forum.module.IntegrationTestCase
import jr.selphius.forum.module.community.domain.CommunityRepository
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer

protected[community] trait CommunityIntegrationTestCase extends IntegrationTestCase {
  private val container                         = new CommunityModuleDependencyContainer(doobieDbConnection)
  protected val repository: CommunityRepository = container.repository
}
