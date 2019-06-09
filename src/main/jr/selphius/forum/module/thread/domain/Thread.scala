package jr.selphius.forum.module.thread.domain

import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.user.domain.UserId

object Thread {

  def apply(id: String, subject: String, creatorId: String, communityId: String): Thread =
    new Thread(ThreadId(id), Subject(subject), UserId(creatorId), CommunityId(communityId))

  def apply(subject: String, creatorId: String, communityId: String): Thread = {
    new Thread(subject = Subject(subject), creatorId = UserId(creatorId), communityId = CommunityId(communityId))
  }
}

case class Thread(id: ThreadId = ThreadId(), subject: Subject, creatorId: UserId, communityId: CommunityId)
