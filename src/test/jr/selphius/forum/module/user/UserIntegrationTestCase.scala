package jr.selphius.forum.module.user

import jr.selphius.forum.module.IntegrationTestCase
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.repository.InMemoryUserRepository

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container                            = new UserModuleDependencyContainer
  protected val repository: InMemoryUserRepository = container.repository
}
