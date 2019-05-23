package jr.selphius.forum.module.user

import jr.selphius.forum.module.UnitTestCase
import jr.selphius.forum.module.user.domain.{User, UserRepository}

import scala.concurrent.Future

protected[user] trait UserUnitTestCase extends UnitTestCase {
  protected val repository: UserRepository = mock[UserRepository]

  protected def repositoryShouldSearchAllUsers(users: Seq[User]): Unit =
    (repository.getAll _)
      .expects()
      .returning(Future.successful(users))

  protected def repositoryShouldUserVideo(user: User): Unit =
    (repository.save _)
      .expects(user)
      .returning(Future.unit)
}
