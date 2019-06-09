package jr.selphius.forum.module.thread.infrastructure.repository

import doobie.implicits._
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.TypesConversions._
import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.thread.domain.{Thread, ThreadId, ThreadRepository}

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMysqlThreadRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
    extends ThreadRepository {

  override def getAll(): Future[Seq[Thread]] = {
    db.read(sql"SELECT thread_id, subject, user_id, community_id FROM threads".query[Thread].to[Seq])
  }

  override def save(thread: Thread): Future[Unit] = {
    sql"INSERT INTO threads(thread_id, subject, user_id, community_id) VALUES (${thread.id}, ${thread.subject}, ${thread.creatorId}, ${thread.communityId})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }

  override def update(thread: Thread): Future[Unit] = {
    sql"UPDATE threads SET subject=${thread.subject}, community_id=${thread.communityId}, WHERE thread_id=${thread.id}".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }

  override def remove(id: ThreadId): Future[Unit] = {
    sql"DELETE FROM threads WHERE thread_id=$id".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
  }
}
