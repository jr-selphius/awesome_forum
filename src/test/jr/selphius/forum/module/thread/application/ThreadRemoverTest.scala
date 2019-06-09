package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.thread.ThreadUnitTestCase
import jr.selphius.forum.module.thread.domain.ThreadMother

final class ThreadRemoverTest extends ThreadUnitTestCase {
  private val threadRemover = new ThreadRemover(repository)

  "Thread remover" should {
    "remove a thread" in {

      val thread = ThreadMother.random

      repositoryShouldRemoveThread(thread.id)

      threadRemover.remove(thread.id) should be
    }
  }
}
