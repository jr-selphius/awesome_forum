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
        jsonBody { body =>
          container.communityPostController.post(
            body("id").convertTo[String],
            body("name").convertTo[String]
          )
        }
      } ~
        path("users") {
          jsonBody { body =>
            container.userPostController.post(
              body("id").convertTo[String],
              body("name").convertTo[String]
            )
          }
        }
    }

  private def jsonBody[T](handler: Map[String, JsValue] => Route): Route =
    entity(as[JsValue])(json => handler(json.asJsObject.fields))
}
