package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{Email, User, UserId, UserRepository, Username}

final class UserCreator(userRepository: UserRepository) {
  def create(userId: UserId, username: Username, email: Email): Unit = {
    val user = User(userId, username, email)
    userRepository.save(user)
  }
}
