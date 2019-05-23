package jr.selphius.forum.module.shared.infraestructure.dependency_injection

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import jr.selphius.forum.module.shared.infraestructure.config.DbConfig.DbConfig
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection

import scala.concurrent.ExecutionContextExecutor

final class SharedModuleDependencyContainer(actorSystemName: String, dbConfig: DbConfig) {
  val doobieDbConnection                                  = new DoobieDbConnection(dbConfig)
  implicit val actorSystem: ActorSystem                   = ActorSystem(actorSystemName)
  implicit val materializer: ActorMaterializer            = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher
}
