package jr.selphius.forum.module.community.domain

import jr.selphius.forum.module.shared.{IntMother, StringMother}

object CommunityTitleMother {
  private val minChars = 1
  private val maxChars = 10

  def apply(value: String): CommunityTitle = CommunityTitle(value)

  def random(): CommunityTitle =
    CommunityTitle(StringMother.random(numChars = IntMother.randomBetween(minChars, maxChars)))
}
