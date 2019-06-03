package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.UserUnitTestCase
import jr.selphius.forum.module.user.domain.UserMother

final class UserUpdaterTest extends UserUnitTestCase {
  private val userUpdater = new UserUpdater(repository)

  "User updater" should {
    "update a user" in {
      val user = UserMother.random

      repositoryShouldUpdateUser(user)

      userUpdater.update(user.id, user.name) should be
    }
  }
}
