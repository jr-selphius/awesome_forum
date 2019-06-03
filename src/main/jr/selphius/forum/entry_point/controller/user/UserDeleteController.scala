package jr.selphius.forum.entry_point.controller.user

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.user.application.UserRemover
import jr.selphius.forum.module.user.domain.UserId

final class UserDeleteController(userRemover: UserRemover) {
  def delete(userId: String): StandardRoute = {
    userRemover.remove(UserId(userId))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
