package jr.selphius.forum.entry_point

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, get, path, _}
import akka.http.scaladsl.server.Route
import jr.selphius.forum.module.community.domain.Community
import jr.selphius.forum.module.user.domain.User

object Routes {

  private val systemUsers = Seq(
    User(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
    User(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
  )

  private val systemCommunities = Seq(
    Community(
      id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee",
      title = "🎥 Scala FTW vol. 1"
    ),
    Community(
      id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97",
      title = "🔝 Interview with Odersky"
    )
  )

  val all: Route = get {
    path("communities") {
      complete(
        HttpEntity(ContentTypes.`application/json`,
                   """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""))
    } ~
      path("users") {
        complete(
          HttpEntity(ContentTypes.`application/json`,
                     """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""))
      }
  }
}
