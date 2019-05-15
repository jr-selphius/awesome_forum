package jr.selphius.forum.module.community.domain

trait CommunityRepository {
  def getAll(): Seq[Community]
  def save(community: Community): Unit
}
