package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, MediaTypes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import com.typesafe.config.ConfigFactory
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.shared.infraestructure.config.DbConfig
import jr.selphius.forum.module.shared.infraestructure.dependency_injection.SharedModuleDependencyContainer
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.thread.infrastructure.dependency_injection.ThreadModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

protected[entry_point] abstract class AcceptanceSpec
    extends WordSpec
    with Matchers
    with ScalaFutures
    with ScalatestRouteTest {

  private val appConfig       = ConfigFactory.load("application")
  private val dbConfig        = DbConfig(appConfig.getConfig("database"))
  private val actorSystemName = "awesome-forum-integration-test"

  private val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig)

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
  protected val userContainer =
    new UserModuleDependencyContainer(sharedDependencies.doobieDbConnection)(sharedDependencies.executionContext)
  protected val communityContainer =
    new CommunityModuleDependencyContainer(sharedDependencies.doobieDbConnection)(sharedDependencies.executionContext)
  protected val threadContainer =
    new ThreadModuleDependencyContainer(sharedDependencies.doobieDbConnection)(sharedDependencies.executionContext)

  private val routes = new Routes(
    new EntryPointDependencyContainer(
      userContainer,
      communityContainer,
      threadContainer
    )
  )

  def get[T](path: String)(body: ⇒ T): T = Get(path) ~> routes.all ~> check(body)

  def delete[T](path: String)(body: ⇒ T): T = Delete(path) ~> routes.all ~> check(body)

  def post[T](path: String, request: String)(body: ⇒ T): T =
    HttpRequest(
      method = HttpMethods.POST,
      uri = path,
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(request)
      )
    ) ~> routes.all ~> check(
      body
    )

  def put[T](path: String, request: String)(body: ⇒ T): T =
    HttpRequest(
      method = HttpMethods.PUT,
      uri = path,
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(request)
      )
    ) ~> routes.all ~> check(
      body
    )
}
