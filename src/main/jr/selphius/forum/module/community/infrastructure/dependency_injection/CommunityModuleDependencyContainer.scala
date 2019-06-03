package jr.selphius.forum.module.community.infrastructure.dependency_injection

import jr.selphius.forum.module.community.application.{
  CommunitiesSearcher,
  CommunityCreator,
  CommunityRemover,
  CommunityUpdater
}
import jr.selphius.forum.module.community.domain.CommunityRepository
import jr.selphius.forum.module.community.infrastructure.repository.DoobieMysqlCommunityRepository
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection

import scala.concurrent.ExecutionContext

final class CommunityModuleDependencyContainer(doobieDbConnection: DoobieDbConnection)(
    implicit executionContext: ExecutionContext) {
  val repository: CommunityRepository          = new DoobieMysqlCommunityRepository(doobieDbConnection)
  val communitiesSearcher: CommunitiesSearcher = new CommunitiesSearcher(repository)
  val communityCreator: CommunityCreator       = new CommunityCreator(repository)
  val communityUpdater: CommunityUpdater       = new CommunityUpdater(repository)
  val communityRemover: CommunityRemover       = new CommunityRemover(repository)
}
