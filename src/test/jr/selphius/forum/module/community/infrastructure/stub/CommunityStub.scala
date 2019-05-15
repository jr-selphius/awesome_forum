package jr.selphius.forum.module.community.infrastructure.stub

import jr.selphius.forum.module.community.domain.Community

object CommunityStub {
  def apply(
      id: String = CommunityIdStub.random.value.toString,
      name: String = CommunityNameStub.random.value
  ): Community = Community(id, name)

  def random: Community = apply()
}
