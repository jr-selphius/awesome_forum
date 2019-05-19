package jr.selphius.forum.module.community.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._

import scala.concurrent.Future

final class DoobieMysqlCommunityRepository(db: DoobieDbConnection) extends CommunityRepository {

  override def getAll(): Future[Seq[Community]] = {
    db.read(sql"SELECT community_id, title FROM communities".query[Community].to[Seq])
  }

  override def save(community: Community): Unit = {}
}
