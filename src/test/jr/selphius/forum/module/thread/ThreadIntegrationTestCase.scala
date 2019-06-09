package jr.selphius.forum.module.thread

import jr.selphius.forum.module.IntegrationTestCase
import jr.selphius.forum.module.thread.domain.ThreadRepository
import jr.selphius.forum.module.thread.infrastructure.dependency_injection.ThreadModuleDependencyContainer

protected[thread] trait ThreadIntegrationTestCase extends IntegrationTestCase {
  private val container                      = new ThreadModuleDependencyContainer(doobieDbConnection)(sharedDependencies.executionContext)
  protected val repository: ThreadRepository = container.repository
}
