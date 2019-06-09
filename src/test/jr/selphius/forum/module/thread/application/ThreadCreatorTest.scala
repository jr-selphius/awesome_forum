package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.thread.ThreadUnitTestCase
import jr.selphius.forum.module.thread.domain.ThreadMother

final class ThreadCreatorTest extends ThreadUnitTestCase {
  private val threadCreator = new ThreadCreator(repository)

  "Thread creator" should {
    "save a thread" in {
      val thread = ThreadMother.random

      repositoryShouldSaveThread(thread)

      threadCreator.create(thread.id, thread.subject, thread.creatorId, thread.communityId) should be
    }
  }
}
