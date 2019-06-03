package jr.selphius.forum.module.community.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMysqlCommunityRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
    extends CommunityRepository {

  override def getAll(): Future[Seq[Community]] = {
    db.read(sql"SELECT community_id, title FROM communities".query[Community].to[Seq])
  }

  override def save(community: Community): Future[Unit] = {
    sql"INSERT INTO communities(community_id, title) VALUES (${community.id}, ${community.title})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }

  override def update(community: Community): Future[Unit] = {
    sql"UPDATE communities SET title=${community.title} WHERE community_id=${community.id}".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }
}
