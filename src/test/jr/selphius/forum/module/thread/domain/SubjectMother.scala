package jr.selphius.forum.module.thread.domain

import jr.selphius.forum.module.shared.{IntMother, StringMother}

object SubjectMother {
  private val minChars = 1
  private val maxChars = 30

  def apply(value: String): Subject = Subject(value)

  def random(): Subject = Subject(StringMother.random(numChars = IntMother.randomBetween(minChars, maxChars)))
}
