package jr.selphius.forum.module.user.infrastructure.stub

import jr.selphius.forum.module.user.domain.User

object UserStub {
  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UsernameStub.random.value
  ): User = User(id, name)

  def random: User = apply()
}
