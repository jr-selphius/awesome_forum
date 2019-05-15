package jr.selphius.forum.module.user

import jr.selphius.forum.module.UnitTestCase
import jr.selphius.forum.module.user.domain.{User, UserRepository}

protected[user] trait UserUnitTestCase extends UnitTestCase {
  protected val repository: UserRepository = mock[UserRepository]

  protected def shouldSearchAllUsers(users: Seq[User]): Unit =
    (repository.getAll _)
      .expects()
      .returning(users)
}
