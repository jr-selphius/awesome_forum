package jr.selphius.forum

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives.{complete, get, path}

object Routes {
  val all : Route =
    get {
      path("forums") {
        complete(HttpEntity(ContentTypes.`application/json`, """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""))
      }
    }
}
