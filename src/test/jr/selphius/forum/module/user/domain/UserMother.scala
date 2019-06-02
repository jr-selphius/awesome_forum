package jr.selphius.forum.module.user.domain

import jr.selphius.forum.module.shared.IntMother

object UserMother {

  def apply(
             id: String = UserIdMother.random.value.toString,
             name: String = UsernameMother.random.value
  ): User = User(id, name)

  def random: User = apply()

  def randomSeq: Seq[User] = 0 to IntMother.randomBetween(1, 10) map (_ => random)
}
