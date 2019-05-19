package jr.selphius.forum.module.user.infrastructure.repository

import jr.selphius.forum.module.user.domain.{User, UserRepository}

import scala.concurrent.Future

final class InMemoryUserRepository extends UserRepository {

  private var users: Seq[User] = Seq[User]()

  override def getAll(): Future[Seq[User]] = Future.successful(users)

  override def save(user: User): Unit = users = users :+ user
}
