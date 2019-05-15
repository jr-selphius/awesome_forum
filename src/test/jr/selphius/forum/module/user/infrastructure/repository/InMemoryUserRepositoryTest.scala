package jr.selphius.forum.module.user.infrastructure.repository

import jr.selphius.forum.module.user.UserIntegrationTestCase
import jr.selphius.forum.module.user.domain.UserStub

final class InMemoryUserRepositoryTest extends UserIntegrationTestCase {

  "In memory user repository" should {
    "search all existing users" in {
      val user          = UserStub.random
      val anotherUser   = UserStub.random
      val existingUsers = Seq(user, anotherUser)

      repository.save(user)
      repository.save(anotherUser)

      repository.getAll() shouldBe existingUsers
    }
  }
}
