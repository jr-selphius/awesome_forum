package jr.selphius.forum.module.user.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.user.domain.{User, UserRepository}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMysqlUserRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
    extends UserRepository {

  override def getAll(): Future[Seq[User]] = db.read(sql"SELECT user_id, name FROM users".query[User].to[Seq])

  override def save(user: User): Future[Unit] = {
    sql"INSERT INTO users(user_id, name) VALUES (${user.id}, ${user.name})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }

  override def update(user: User): Future[Unit] = {
    sql"UPDATE users SET name=${user.name} WHERE user_id=${user.id}".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }
}
