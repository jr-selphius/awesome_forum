package jr.selphius.forum.module.user.domain

import jr.selphius.forum.module.shared.stub.{IntStub, StringStub}

object UsernameStub {
  private val minChars = 1
  private val maxChars = 10

  def apply(value: String): Username = Username(value)

  def random(): Username = Username(StringStub.random(numChars = IntStub.randomBetween(minChars, maxChars)))
}
