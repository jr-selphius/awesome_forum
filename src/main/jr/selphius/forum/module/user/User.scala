package jr.selphius.forum.module.user

object User {
  def apply(id: String, name: String): User = User(UserId(id), Username(name))
}

case class User(id: UserId, name: Username)
