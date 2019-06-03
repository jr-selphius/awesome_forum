package jr.selphius.forum.module.user

import jr.selphius.forum.module.UnitTestCase
import jr.selphius.forum.module.user.domain.{User, UserId, UserRepository}

import scala.concurrent.Future

protected[user] trait UserUnitTestCase extends UnitTestCase {
  protected val repository: UserRepository = mock[UserRepository]

  protected def repositoryShouldSearchAllUsers(users: Seq[User]): Unit =
    (repository.getAll _)
      .expects()
      .returning(Future.successful(users))

  protected def repositoryShouldSaveUser(user: User): Unit =
    (repository.save _)
      .expects(user)
      .returning(Future.unit)

  protected def repositoryShouldUpdateUser(user: User): Unit =
    (repository.update _)
      .expects(user)
      .returning(Future.unit)

  protected def repositoryShouldRemoveUser(id: UserId): Unit =
    (repository.remove _)
      .expects(id)
      .returning(Future.unit)
}
