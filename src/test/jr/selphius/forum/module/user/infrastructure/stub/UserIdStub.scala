package jr.selphius.forum.module.user.infrastructure.stub

import java.util.UUID

import jr.selphius.forum.module.shared.stub.UuidStub
import jr.selphius.forum.module.user.domain.UserId

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
