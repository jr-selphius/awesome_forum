package jr.selphius.forum.module.user.domain

import java.util.UUID

import jr.selphius.forum.module.shared.UuidMother

object UserIdMother {
  def apply(value: String): UserId = UserIdMother(UuidMother(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidMother.random)
}
