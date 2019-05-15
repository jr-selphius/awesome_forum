package jr.selphius.forum.module.user.domain

trait UserRepository {
  def getAll(): Seq[User]
  def save(user: User): Unit
}
