package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.thread.domain.{ThreadId, ThreadRepository}

import scala.concurrent.Future

final class ThreadRemover(threadRepository: ThreadRepository) {
  def remove(id: ThreadId): Future[Unit] = {
    threadRepository.remove(id)
  }
}
