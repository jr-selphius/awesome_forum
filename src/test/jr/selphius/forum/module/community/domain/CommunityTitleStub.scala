package jr.selphius.forum.module.community.domain

import jr.selphius.forum.module.shared.stub.{IntStub, StringStub}

object CommunityTitleStub {
  private val minChars = 1
  private val maxChars = 10

  def apply(value: String): CommunityTitle = CommunityTitle(value)

  def random(): CommunityTitle = CommunityTitle(StringStub.random(numChars = IntStub.randomBetween(minChars, maxChars)))
}
