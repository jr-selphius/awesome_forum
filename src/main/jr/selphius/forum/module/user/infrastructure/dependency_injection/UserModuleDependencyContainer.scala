package jr.selphius.forum.module.user.infrastructure.dependency_injection

import jr.selphius.forum.module.user.application.UsersSearcher

final class UserModuleDependencyContainer {
  val usersSearcher: UsersSearcher = new UsersSearcher
}
