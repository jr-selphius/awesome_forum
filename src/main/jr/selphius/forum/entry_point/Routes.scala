package jr.selphius.forum.entry_point

import akka.http.scaladsl.server.Directives.{get, path, _}
import akka.http.scaladsl.server.Route
import jr.selphius.forum.entry_point.controller.community.CommunityGetController
import jr.selphius.forum.entry_point.controller.user.UserGetController

object Routes {

  val all: Route = get {
    path("communities")(CommunityGetController()) ~
      path("users")(UserGetController())
  }
}
