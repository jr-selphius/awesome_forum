package jr.selphius.forum.module.thread.domain

import scala.concurrent.Future

trait ThreadRepository {
  def getAll(): Future[Seq[Thread]]
  def save(thread: Thread): Future[Unit]
  def update(thread: Thread): Future[Unit]
  def remove(id: ThreadId): Future[Unit]
}
