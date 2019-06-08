package jr.selphius.forum.module.user.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.user.domain.{User, UserId, UserRepository}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMysqlUserRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
    extends UserRepository {

  override def getAll(): Future[Seq[User]] = db.read(sql"SELECT user_id, username, email FROM users".query[User].to[Seq])

  override def save(user: User): Future[Unit] = {
    sql"INSERT INTO users(user_id, username, email) VALUES (${user.id}, ${user.username}, ${user.email})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }

  override def update(user: User): Future[Unit] = {
    sql"UPDATE users SET name=${user.username}, email=${user.email} WHERE user_id=${user.id}".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }

  override def remove(id: UserId): Future[Unit] = {
    sql"DELETE FROM users WHERE user_id=$id".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }
}
