package jr.selphius.forum.module.thread

import jr.selphius.forum.module.UnitTestCase
import jr.selphius.forum.module.thread.domain.{Thread, ThreadId, ThreadRepository}

import scala.concurrent.Future

protected[thread] trait ThreadUnitTestCase extends UnitTestCase {
  protected val repository: ThreadRepository = mock[ThreadRepository]

  protected def repositoryShouldSearchAllThreads(threads: Seq[Thread]): Unit =
    (repository.getAll _)
      .expects()
      .returning(Future.successful(threads))

  protected def repositoryShouldSaveThread(thread: Thread): Unit =
    (repository.save _)
      .expects(thread)
      .returning(Future.unit)

  protected def repositoryShouldUpdateThread(thread: Thread): Unit =
    (repository.update _)
      .expects(thread)
      .returning(Future.unit)

  protected def repositoryShouldRemoveThread(id: ThreadId): Unit =
    (repository.remove _)
      .expects(id)
      .returning(Future.unit)
}
