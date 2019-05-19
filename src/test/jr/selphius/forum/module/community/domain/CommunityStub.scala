package jr.selphius.forum.module.community.domain

import jr.selphius.forum.module.shared.stub.IntStub

object CommunityStub {
  def apply(
      id: String = CommunityIdStub.random.value.toString,
      title: String = CommunityTitleStub.random.value
  ): Community = Community(id, title)

  def random: Community = apply()

  def randomSeq: Seq[Community] = (0 to IntStub.randomBetween(0, 10)).map(_ => random)
}
