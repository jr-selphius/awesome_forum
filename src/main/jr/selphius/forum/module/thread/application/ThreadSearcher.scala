package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.thread.domain.{Thread, ThreadRepository}

import scala.concurrent.Future

final class ThreadSearcher(threadRepository: ThreadRepository) {

  def searchAll(): Future[Seq[Thread]] = threadRepository.getAll()
}
