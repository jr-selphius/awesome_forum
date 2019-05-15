package jr.selphius.forum.module.user.infrastructure.repository

import jr.selphius.forum.module.user.domain.{User, UserRepository}

final class InMemoryUserRepository extends UserRepository {

  private val users = Seq(
    User(
      id = "deacd129-d419-4552-9bfc-0723c3c4f56a",
      name = "Edufasio"
    ),
    User(
      id = "b62f767f-7160-4405-a4af-39ebb3635c17",
      name = "Edonisio"
    )
  )

  override def getAll(): Seq[User] = users

  override def save(user: User): Unit = user +: users
}
