package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{User, UserId, UserRepository, Username}

final class UserUpdater(userRepository: UserRepository) {
  def update(userId: UserId, username: Username): Unit = {
    val user = User(userId, username)
    userRepository.update(user)
  }
}
