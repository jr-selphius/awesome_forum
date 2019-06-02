package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.UserUnitTestCase
import jr.selphius.forum.module.user.domain.UserMother

final class UserCreatorTest extends UserUnitTestCase {
  private val userCreator = new UserCreator(repository)

  "User creator" should {
    "save a user" in {
      val user = UserMother.random

      repositoryShouldUserVideo(user)

      userCreator.create(user.id, user.name) should be
    }
  }
}
