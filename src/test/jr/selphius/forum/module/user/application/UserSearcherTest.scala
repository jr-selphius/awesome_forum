package jr.selphius.forum.module.user.application

import jr.selphius.forum.module.user.UserUnitTestCase
import jr.selphius.forum.module.user.domain.UserStub
import org.scalatest.concurrent.ScalaFutures._

final class UserSearcherTest extends UserUnitTestCase {
  private val userSearcher = new UsersSearcher(repository)

  "User searcher" should {
    "search all existing users" in {
      val existingUsers = Seq(UserStub.random, UserStub.random)

      repositoryShouldSearchAllUsers(existingUsers)

      whenReady(userSearcher.searchAll()) {
        _ shouldBe existingUsers
      }
    }
  }
}
