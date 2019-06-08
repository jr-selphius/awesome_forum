package jr.selphius.forum.entry_point.controller.user

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.user.application.UserUpdater
import jr.selphius.forum.module.user.domain.{Email, UserId, Username}

final class UserPutController(userUpdater: UserUpdater) {
  def put(userId: String, username: String, email: String): StandardRoute = {
    userUpdater.update(UserId(userId), Username(username), Email(email))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
