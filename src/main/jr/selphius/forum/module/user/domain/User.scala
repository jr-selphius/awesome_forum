package jr.selphius.forum.module.user.domain

object User {
  def apply(id: String, username: String, email: String): User = User(UserId(id), Username(username), Email(email))
}

case class User(id: UserId, username: Username, email: Email)
