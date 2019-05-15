package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{User, UserId, UserRepository, Username}

final class UserCreator(userRepository: UserRepository) {
  def create(userId: UserId, username: Username): Unit = {
    val user = User(userId, username)
    userRepository.save(user)
  }
}
