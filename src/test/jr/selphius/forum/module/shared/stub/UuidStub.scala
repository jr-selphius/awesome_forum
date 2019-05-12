package jr.selphius.forum.module.shared.stub

import java.util.UUID

object UuidStub {
  def apply(value: String): UUID = UUID.fromString(value)

  def random: UUID = UUID.randomUUID()
}
