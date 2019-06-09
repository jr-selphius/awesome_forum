package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.thread.ThreadUnitTestCase
import jr.selphius.forum.module.thread.domain.ThreadMother
import org.scalatest.concurrent.ScalaFutures._

final class ThreadSearcherTest extends ThreadUnitTestCase {
  private val threadSearcher = new ThreadSearcher(repository)

  "Thread searcher" should {
    "search all existing threads" in {
      val existingThreads = Seq(ThreadMother.random, ThreadMother.random)

      repositoryShouldSearchAllThreads(existingThreads)

      whenReady(threadSearcher.searchAll()) {
        _ shouldBe existingThreads
      }
    }
  }
}
