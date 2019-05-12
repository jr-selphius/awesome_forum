package jr.selphius.forum.module.community.infrastructure.stub

import jr.selphius.forum.module.community.domain.Community

object CommunityStub {
  def apply(
      id: String = CommunityIdStub.random.value.toString,
      title: String = CommunityNameStub.random.value
  ): Community = Community(id, title)

  def random: Community = apply()
}
