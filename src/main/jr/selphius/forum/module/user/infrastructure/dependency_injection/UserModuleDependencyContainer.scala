package jr.selphius.forum.module.user.infrastructure.dependency_injection

import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.user.application.{UserCreator, UserUpdater, UsersSearcher}
import jr.selphius.forum.module.user.domain.UserRepository
import jr.selphius.forum.module.user.infrastructure.repository.DoobieMysqlUserRepository

import scala.concurrent.ExecutionContext

final class UserModuleDependencyContainer(doobieDbConnection: DoobieDbConnection)(
    implicit executionContext: ExecutionContext) {
  val repository: UserRepository   = new DoobieMysqlUserRepository(doobieDbConnection)
  val usersSearcher: UsersSearcher = new UsersSearcher(repository)
  val userCreator: UserCreator     = new UserCreator(repository)
  val userUpdater: UserUpdater     = new UserUpdater(repository)
}
