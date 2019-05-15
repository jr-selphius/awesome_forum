package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.UserUnitTestCase
import jr.selphius.forum.module.user.domain.UserStub

final class UserSearcherTest extends UserUnitTestCase {
  private val userSearcher = new UsersSearcher(repository)

  "User searched" should {
    "search all existing users" in {
      val existingUsers = Seq(UserStub.random, UserStub.random)

      shouldSearchAllUsers(existingUsers)

      userSearcher.searchAll() shouldBe existingUsers
    }
  }
}
