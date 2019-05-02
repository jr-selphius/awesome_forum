package jr.selphius.forum.module.community

import java.util.UUID

object CommunityId {
  def apply(value: String): CommunityId = CommunityId(UUID.fromString(value))
}

case class CommunityId(value: UUID)
