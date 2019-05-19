package jr.selphius.forum.module.user.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.user.domain.{User, UserRepository}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

import scala.concurrent.Future

final class DoobieMysqlUserRepository(db: DoobieDbConnection) extends UserRepository {

  override def getAll(): Future[Seq[User]] = db.read(sql"SELECT user_id, name FROM users".query[User].to[Seq])

  override def save(user: User): Unit = {}
}
