package jr.selphius.forum.entry_point.controller.thread

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.thread.application.ThreadRemover
import jr.selphius.forum.module.thread.domain.ThreadId

final class ThreadDeleteController(threadRemover: ThreadRemover) {
  def delete(threadId: String): StandardRoute = {
    threadRemover.remove(ThreadId(threadId))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
