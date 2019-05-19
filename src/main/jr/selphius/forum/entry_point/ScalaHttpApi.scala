package jr.selphius.forum.entry_point

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.shared.infraestructure.config
import jr.selphius.forum.module.shared.infraestructure.dependency_injection.SharedModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object ScalaHttpApi {

  def main(args: Array[String]): Unit = {
    println("Started!")

    val appConfig    = ConfigFactory.load("application")
    val serverConfig = ConfigFactory.load("http-server")

    val actorSystemName = appConfig.getString("main-actor-system.name")
    val host            = serverConfig.getString("http-server.host")
    val port            = serverConfig.getInt("http-server.port")

    implicit val system: ActorSystem                        = ActorSystem(actorSystemName)
    implicit val materializer: ActorMaterializer            = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val dbConfig = config.DbConfig(appConfig.getConfig("database"))

    val sharedDependencies = new SharedModuleDependencyContainer(dbConfig)

    val container = new EntryPointDependencyContainer(
      new UserModuleDependencyContainer(sharedDependencies.doobieDbConnection),
      new CommunityModuleDependencyContainer(sharedDependencies.doobieDbConnection))

    val routes = new Routes(container)

    val bindingFuture = Http().bindAndHandle(routes.all, host, port)

    bindingFuture.failed.foreach { t =>
      println(s"Failed to bind to http://$host:$port/:")
      pprint.log(t)
    }

    // let it run until user presses return
    println(s"Server online at http://$host:$port/\nPress RETURN to stop...")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
