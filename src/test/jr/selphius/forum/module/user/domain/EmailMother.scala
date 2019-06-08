package jr.selphius.forum.module.user.domain

import jr.selphius.forum.module.shared.{IntMother, StringMother}

object EmailMother {
  private val minChars = 1
  private val maxChars = 10

  def apply(value: String): Email = Email(value)

  def random(): Email = Email(StringMother.random(numChars = IntMother.randomBetween(minChars, maxChars)))
}
