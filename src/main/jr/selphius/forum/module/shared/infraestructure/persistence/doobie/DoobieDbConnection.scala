package jr.selphius.forum.module.shared.infraestructure.persistence.doobie

import cats.effect.IO
import doobie.Transactor
import doobie.syntax.ConnectionIOOps
import doobie.util.transactor.Transactor.Aux
import jr.selphius.forum.module.shared.infraestructure.config.DbConfig.DbConfig

import scala.concurrent.Future

final class DoobieDbConnection(dbConfig: DbConfig) {
  val transactor: Aux[IO, Unit] = Transactor.fromDriverManager[IO](
    dbConfig.driver,
    dbConfig.url,
    dbConfig.user,
    dbConfig.password
  )

  def read[T](query: ConnectionIOOps[T]): Future[T] = query.transact(transactor).unsafeToFuture()
}
