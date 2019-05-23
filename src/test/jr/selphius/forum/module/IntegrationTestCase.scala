package jr.selphius.forum.module

import com.typesafe.config.ConfigFactory
import jr.selphius.forum.module.shared.infraestructure.config.DbConfig
import jr.selphius.forum.module.shared.infraestructure.dependency_injection.SharedModuleDependencyContainer
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection

protected[forum] class IntegrationTestCase extends UnitTestCase {

  private val appConfig            = ConfigFactory.load("application")
  private val dbConfig             = DbConfig(appConfig.getConfig("database"))
  private val actorSystemName      = "awesome-forum-integration-test"
  protected val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig)

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
}
