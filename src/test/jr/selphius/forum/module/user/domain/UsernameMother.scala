package jr.selphius.forum.module.user.domain

import jr.selphius.forum.module.shared.{IntMother, StringMother}

object UsernameMother {
  private val minChars = 1
  private val maxChars = 10

  def apply(value: String): Username = Username(value)

  def random(): Username = Username(StringMother.random(numChars = IntMother.randomBetween(minChars, maxChars)))
}
