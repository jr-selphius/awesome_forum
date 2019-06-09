package jr.selphius.forum.entry_point.controller.thread

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.thread.application.ThreadCreator
import jr.selphius.forum.module.thread.domain.{Subject, ThreadId}
import jr.selphius.forum.module.user.domain.UserId

final class ThreadPostController(threadCreator: ThreadCreator) {
  def post(subject: String, userId: String, communityId: String): StandardRoute = {
    threadCreator.create(ThreadId(), Subject(subject), UserId(userId), CommunityId(communityId))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
