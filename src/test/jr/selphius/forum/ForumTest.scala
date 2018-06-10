package jr.selphius.forum

import org.scalatest._
import org.scalatest.Matchers._

final class ForumTest extends WordSpec with GivenWhenThen {
  "Forum" should {
    "greet" in {
      Given("a Forum")

      val forum = new Forum

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting = forum.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
