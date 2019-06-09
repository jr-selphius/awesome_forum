package jr.selphius.forum.module.thread.application

import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.thread.domain.{Subject, Thread, ThreadId, ThreadRepository}
import jr.selphius.forum.module.user.domain.UserId

import scala.concurrent.Future

final class ThreadCreator(threadRepository: ThreadRepository) {
  def create(threadId: ThreadId, subject: Subject, creatorId: UserId, communityId: CommunityId): Future[Unit] = {
    val thread = Thread(threadId, subject, creatorId, communityId)
    threadRepository.save(thread)
  }
}
