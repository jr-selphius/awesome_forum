package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.thread.domain.{Subject, Thread, ThreadId, ThreadRepository}
import jr.selphius.forum.module.user.domain._

import scala.concurrent.Future

final class ThreadUpdater(threadRepository: ThreadRepository) {
  def update(threadId: ThreadId, subject: Subject, creatorId: UserId, communityId: CommunityId): Future[Unit] = {
    val thread = Thread(threadId, subject, creatorId, communityId)
    threadRepository.update(thread)
  }
}
