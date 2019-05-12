package jr.selphius.forum.module.community.infrastructure.stub

import jr.selphius.forum.module.community.domain.CommunityName
import jr.selphius.forum.module.shared.stub.{IntStub, StringStub}

object CommunityNameStub {
  private val minChars = 1
  private val maxChars = 10

  def apply(value: String): CommunityName = CommunityName(value)

  def random(): CommunityName = CommunityName(StringStub.random(numChars = IntStub.randomBetween(minChars, maxChars)))
}
