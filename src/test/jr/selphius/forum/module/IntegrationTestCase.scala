package jr.selphius.forum.module

import com.typesafe.config.ConfigFactory
import jr.selphius.forum.module.shared.infraestructure.config.DbConfig
import jr.selphius.forum.module.shared.infraestructure.dependency_injection.SharedModuleDependencyContainer
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection

protected[forum] class IntegrationTestCase extends UnitTestCase {

  val appConfig          = ConfigFactory.load("application")
  val dbConfig           = DbConfig(appConfig.getConfig("database"))
  val sharedDependencies = new SharedModuleDependencyContainer(dbConfig)

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
}
