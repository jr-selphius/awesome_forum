package jr.selphius.forum.entry_point.controller.thread

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.thread.application.ThreadUpdater
import jr.selphius.forum.module.thread.domain.{Subject, ThreadId}
import jr.selphius.forum.module.user.domain.UserId

final class ThreadPutController(threadUpdater: ThreadUpdater) {
  def put(threadId: String, subject: String, userId: String, communityId: String): StandardRoute = {
    threadUpdater.update(ThreadId(threadId), Subject(subject), UserId(userId), CommunityId(communityId))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
