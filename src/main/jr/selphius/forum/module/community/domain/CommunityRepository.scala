package jr.selphius.forum.module.community.domain

import scala.concurrent.Future

trait CommunityRepository {
  def getAll(): Future[Seq[Community]]
  def save(community: Community): Future[Unit]
  def update(community: Community): Future[Unit]
}
