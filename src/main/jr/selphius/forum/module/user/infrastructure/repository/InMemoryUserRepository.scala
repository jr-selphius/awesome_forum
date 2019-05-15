package jr.selphius.forum.module.user.infrastructure.repository

import jr.selphius.forum.module.user.domain.{User, UserRepository}

final class InMemoryUserRepository extends UserRepository {

  private var users: Seq[User] = Seq[User]()

  override def getAll(): Seq[User] = users

  override def save(user: User): Unit = users = users :+ user
}
