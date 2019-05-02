package jr.selphius.forum.module.community

object Community {
  def apply(id: String, title: String): Community = Community(CommunityId(id), CommunityTitle(title))
}

case class Community(id: CommunityId, title: CommunityTitle)
