package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.thread.ThreadUnitTestCase
import jr.selphius.forum.module.thread.domain.ThreadMother

final class ThreadUpdaterTest extends ThreadUnitTestCase {
  private val threadUpdater = new ThreadUpdater(repository)

  "Thread updater" should {
    "update a thread" in {
      val thread = ThreadMother.random

      repositoryShouldUpdateThread(thread)

      threadUpdater.update(thread.id, thread.subject, thread.creatorId, thread.communityId) should be
    }
  }
}
