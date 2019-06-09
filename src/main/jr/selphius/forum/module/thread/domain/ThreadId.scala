package jr.selphius.forum.module.thread.domain

import java.util.UUID

object ThreadId {
  def apply(value: String): ThreadId = ThreadId(UUID.fromString(value))
  def apply(): ThreadId              = ThreadId(UUID.randomUUID())
}

case class ThreadId(value: UUID)
