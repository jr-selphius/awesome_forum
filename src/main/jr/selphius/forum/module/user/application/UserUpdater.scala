package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{Email, User, UserId, UserRepository, Username}

final class UserUpdater(userRepository: UserRepository) {
  def update(userId: UserId, username: Username, email: Email): Unit = {
    val user = User(userId, username, email)
    userRepository.update(user)
  }
}
