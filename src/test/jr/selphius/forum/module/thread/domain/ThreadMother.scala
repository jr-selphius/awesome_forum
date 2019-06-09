package jr.selphius.forum.module.thread.domain

import jr.selphius.forum.module.community.domain.CommunityIdMother
import jr.selphius.forum.module.shared.IntMother
import jr.selphius.forum.module.user.domain.UserIdMother

object ThreadMother {

  def apply(
      id: String = ThreadIdMother.random.value.toString,
      subject: String = SubjectMother.random.value,
      userId: String = UserIdMother.random.value.toString,
      communityId: String = CommunityIdMother.random.value.toString
  ): Thread = Thread(id, subject, userId, communityId)

  def random: Thread = apply()

  def randomSeq: Seq[Thread] = 0 to IntMother.randomBetween(1, 4) map (_ => random)
}
