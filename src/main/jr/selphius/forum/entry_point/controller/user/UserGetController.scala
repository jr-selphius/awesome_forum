package jr.selphius.forum.entry_point.controller.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.user.domain.User
import jr.selphius.forum.module.user.infrastructure.UserMarshaller._
import spray.json.DefaultJsonProtocol

object UserGetController extends SprayJsonSupport with DefaultJsonProtocol {

  private val users = Seq(
    User(
      id = "deacd129-d419-4552-9bfc-0723c3c4f56a",
      name = "Edufasio"
    ),
    User(
      id = "b62f767f-7160-4405-a4af-39ebb3635c17",
      name = "Edonisio"
    )
  )

  def apply(): StandardRoute = complete(users)
}
