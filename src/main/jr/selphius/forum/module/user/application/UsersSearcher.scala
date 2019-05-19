package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.domain.{User, UserRepository}

import scala.concurrent.Future

final class UsersSearcher(userRepository: UserRepository) {

  def searchAll(): Future[Seq[User]] = userRepository.getAll()
}
