package jr.selphius.forum.module.community.domain

import jr.selphius.forum.module.shared.IntMother

object CommunityMother {
  def apply(
      id: String = CommunityIdMother.random.value.toString,
      title: String = CommunityTitleMother.random.value
  ): Community = Community(id, title)

  def random: Community = apply()

  def randomSeq: Seq[Community] = (0 to IntMother.randomBetween(1, 3)).map(_ => random)
}
