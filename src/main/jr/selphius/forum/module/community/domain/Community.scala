package jr.selphius.forum.module.community.domain

object Community {
  def apply(id: String, title: String): Community = Community(CommunityId(id), CommunityName(title))
}

case class Community(id: CommunityId, title: CommunityName)
