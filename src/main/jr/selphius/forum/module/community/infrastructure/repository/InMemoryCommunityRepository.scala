package jr.selphius.forum.module.community.infrastructure.repository

import jr.selphius.forum.module.community.domain.{Community, CommunityRepository}

final class InMemoryCommunityRepository extends CommunityRepository {

  private val communities = Seq(
    Community(
      id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee",
      title = "🎥 Scala FTW vol. 1"
    ),
    Community(
      id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97",
      title = "🔝 Interview with Odersky"
    )
  )

  override def getAll(): Seq[Community] = communities

  override def save(community: Community): Unit = community +: communities
}
