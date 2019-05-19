package jr.selphius.forum.module.community.infrastructure.dependency_injection

import jr.selphius.forum.module.community.application.{CommunitiesSearcher, CommunityCreator}
import jr.selphius.forum.module.community.domain.CommunityRepository
import jr.selphius.forum.module.community.infrastructure.repository.DoobieMysqlCommunityRepository
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection

final class CommunityModuleDependencyContainer(doobieDbConnection: DoobieDbConnection) {
  val repository: CommunityRepository          = new DoobieMysqlCommunityRepository(doobieDbConnection)
  val communitiesSearcher: CommunitiesSearcher = new CommunitiesSearcher(repository)
  val communitiesCreator: CommunityCreator     = new CommunityCreator(repository)
}
