package jr.selphius.forum.module.user

import jr.selphius.forum.module.IntegrationTestCase
import jr.selphius.forum.module.user.domain.UserRepository
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container                    = new UserModuleDependencyContainer(doobieDbConnection)
  protected val repository: UserRepository = container.repository
}
