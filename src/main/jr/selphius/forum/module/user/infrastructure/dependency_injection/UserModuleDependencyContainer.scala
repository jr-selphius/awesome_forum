package jr.selphius.forum.module.user.infrastructure.dependency_injection

import jr.selphius.forum.module.user.application.{UserCreator, UsersSearcher}
import jr.selphius.forum.module.user.infrastructure.repository.InMemoryUserRepository

final class UserModuleDependencyContainer {
  val repository                   = new InMemoryUserRepository
  val usersSearcher: UsersSearcher = new UsersSearcher(repository)
  val userCreator: UserCreator     = new UserCreator(repository)
}
