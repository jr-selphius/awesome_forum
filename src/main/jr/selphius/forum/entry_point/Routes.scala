package jr.selphius.forum.entry_point

import akka.http.scaladsl.server.Directives.{get, path, _}
import akka.http.scaladsl.server.Route

final class Routes(container: EntryPointDependencyContainer) {

  val all: Route = get {
    path("communities")(container.communityGetController.get()) ~
      path("users")(container.userGetController.get())
  }
}
