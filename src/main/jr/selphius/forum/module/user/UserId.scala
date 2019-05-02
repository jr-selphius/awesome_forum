package jr.selphius.forum.module.user

import java.util.UUID

object UserId {
  def apply(id: String): UserId = UserId(id)
}

case class UserId(id: UUID)
