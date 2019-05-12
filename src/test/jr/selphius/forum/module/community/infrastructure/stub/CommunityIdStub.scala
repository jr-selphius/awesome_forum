package jr.selphius.forum.module.community.infrastructure.stub

import java.util.UUID

import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.shared.stub.UuidStub

object CommunityIdStub {
  def apply(value: String): CommunityId = CommunityIdStub(UuidStub(value))

  def apply(value: UUID): CommunityId = CommunityId(value)

  def random: CommunityId = CommunityId(UuidStub.random)
}
