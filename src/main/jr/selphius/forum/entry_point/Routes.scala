package jr.selphius.forum.entry_point

import spray.json.DefaultJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import spray.json.JsValue

final class Routes(container: EntryPointDependencyContainer) {

  private val community = get {
    path("communities")(container.communityGetController.get())
  } ~
    post {
      path("communities") {
        jsonBody { body =>
          container.communityPostController.post(
            body("id").convertTo[String],
            body("title").convertTo[String]
          )
        }
      }
    } ~
    put {
      path("communities") {
        jsonBody { body =>
          container.communityPutController.put(
            body("id").convertTo[String],
            body("title").convertTo[String]
          )
        }
      }
    }

  private val user = get {
    path("users")(container.userGetController.get())
  } ~
    delete {
      path("users" / Segment) { id: String =>
          container.userDeleteController.delete(id)
      }
    } ~
    post {
      path("users") {
        jsonBody { body =>
          container.userPostController.post(
            body("id").convertTo[String],
            body("name").convertTo[String]
          )
        }
      }
    } ~
    put {
      path("users") {
        jsonBody { body =>
          container.userPutController.put(
            body("id").convertTo[String],
            body("name").convertTo[String]
          )
        }
      }
    }

  val all: Route = user ~ community

  private def jsonBody[T](handler: Map[String, JsValue] => Route): Route =
    entity(as[JsValue])(json => handler(json.asJsObject.fields))
}
