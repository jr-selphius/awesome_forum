package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.UserUnitTestCase
import jr.selphius.forum.module.user.domain.UserMother

final class UserRemoverTest extends UserUnitTestCase {
  private val userRemover = new UserRemover(repository)

  "User remover" should {
    "remove an user" in {

      val user = UserMother.random

      repositoryShouldRemoveUser(user.id)

      userRemover.remove(user.id) should be
    }
  }
}
