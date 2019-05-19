package jr.selphius.forum.module.shared.infraestructure.dependency_injection

import jr.selphius.forum.module.shared.infraestructure.config.DbConfig.DbConfig
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection

final class SharedModuleDependencyContainer(dbConfig: DbConfig) {
  val doobieDbConnection = new DoobieDbConnection(dbConfig)
}
