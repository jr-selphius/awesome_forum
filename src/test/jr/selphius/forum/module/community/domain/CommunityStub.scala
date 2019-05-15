package jr.selphius.forum.module.community.domain

object CommunityStub {
  def apply(
      id: String = CommunityIdStub.random.value.toString,
      title: String = CommunityTitleStub.random.value
  ): Community = Community(id, title)

  def random: Community = apply()
}
