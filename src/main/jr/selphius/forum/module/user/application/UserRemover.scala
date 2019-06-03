package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{UserId, UserRepository}

final class UserRemover(userRepository: UserRepository) {
  def remove(id: UserId): Unit = {
    userRepository.remove(id)
  }
}
