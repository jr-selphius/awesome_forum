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
    delete {
      path("communities" / Segment) { id: String =>
        container.communityDeleteController.delete(id)
      }
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
            body("username").convertTo[String],
            body("email").convertTo[String],
          )
        }
      }
    } ~
    put {
      path("users") {
        jsonBody { body =>
          container.userPutController.put(
            body("id").convertTo[String],
            body("username").convertTo[String],
            body("email").convertTo[String],
          )
        }
      }
    }

  private val thread = get {
    path("threads")(container.threadGetController.get())
  } ~
    delete {
      path("threads" / Segment) { id: String =>
        container.threadDeleteController.delete(id)
      }
    } ~
    post {
      path("threads") {
        jsonBody { body =>
          container.threadPostController.post(
            body("subject").convertTo[String],
            body("user_id").convertTo[String],
            body("community_id").convertTo[String]
          )
        }
      }
    } ~
    put {
      path("threads") {
        jsonBody { body =>
          container.threadPutController.put(
            body("thread_id").convertTo[String],
            body("subject").convertTo[String],
            body("user_id").convertTo[String],
            body("community_id").convertTo[String]
          )
        }
      }
    }

  val all: Route = user ~ community ~ thread

  private def jsonBody[T](handler: Map[String, JsValue] => Route): Route =
    entity(as[JsValue])(json => handler(json.asJsObject.fields))
}
