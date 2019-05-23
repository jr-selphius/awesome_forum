package jr.selphius.forum.module.user.domain

import jr.selphius.forum.module.shared.stub.IntStub

object UserStub {

  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UsernameStub.random.value
  ): User = User(id, name)

  def random: User = apply()

  def randomSeq: Seq[User] = 0 to IntStub.randomBetween(1, 10) map (_ => random)
}
