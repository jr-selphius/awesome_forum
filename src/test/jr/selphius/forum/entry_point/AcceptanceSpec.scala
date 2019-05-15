package jr.selphius.forum.entry_point

import akka.http.scaladsl.testkit.ScalatestRouteTest
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.concurrent.ScalaFutures

protected[entry_point] abstract class AcceptanceSpec
    extends WordSpec
    with Matchers
    with ScalaFutures
    with ScalatestRouteTest {

  private val routes = new Routes(
    new EntryPointDependencyContainer(
      new UserModuleDependencyContainer,
      new CommunityModuleDependencyContainer
    )
  )

  def get[T](path: String)(body: ⇒ T): T = Get(path) ~> routes.all ~> check(body)
}
