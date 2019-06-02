package jr.selphius.forum.module.community.domain

import java.util.UUID

import jr.selphius.forum.module.shared.UuidMother

object CommunityIdMother {
  def apply(value: String): CommunityId = CommunityIdMother(UuidMother(value))

  def apply(value: UUID): CommunityId = CommunityId(value)

  def random: CommunityId = CommunityId(UuidMother.random)
}
