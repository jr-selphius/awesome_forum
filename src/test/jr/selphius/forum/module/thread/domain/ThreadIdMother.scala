package jr.selphius.forum.module.thread.domain

import java.util.UUID

import jr.selphius.forum.module.shared.UuidMother

object ThreadIdMother {
  def apply(value: String): ThreadId = ThreadIdMother(UuidMother(value))

  def apply(value: UUID): ThreadId = ThreadId(value)

  def random: ThreadId = ThreadId(UuidMother.random)
}
