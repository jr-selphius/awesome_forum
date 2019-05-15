package jr.selphius.forum.entry_point

import spray.json.DefaultJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import spray.json.JsValue

final class Routes(container: EntryPointDependencyContainer) {

  val all: Route = get {
    path("communities")(container.communityGetController.get()) ~
      path("users")(container.userGetController.get())
  } ~
    post {
      path("communities") {
        entity(as[JsValue]) { json =>
          val bodyParams = json.asJsObject.fields

          container.communityPostController.post(
            bodyParams("id").convertTo[String],
            bodyParams("name").convertTo[String]
          )
        }
      } ~
        path("users") {
          entity(as[JsValue]) { json =>
            val bodyParams = json.asJsObject.fields

            container.userPostController.post(
              bodyParams("id").convertTo[String],
              bodyParams("name").convertTo[String]
            )
          }
        }
    }
}
