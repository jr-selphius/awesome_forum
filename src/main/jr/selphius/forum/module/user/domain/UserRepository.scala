package jr.selphius.forum.module.user.domain

import scala.concurrent.Future

trait UserRepository {
  def getAll(): Future[Seq[User]]
  def save(user: User): Future[Unit]
  def update(user: User): Future[Unit]
  def remove(id: UserId): Future[Unit]
}
