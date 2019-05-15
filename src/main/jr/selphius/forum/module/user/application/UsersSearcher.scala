package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{User, UserRepository}

final class UsersSearcher(userRepository: UserRepository) {

  def searchAll(): Seq[User] = userRepository.getAll()
}
