package jr.selphius.forum.module.thread.infrastructure.dependency_injection

import jr.selphius.forum.module.shared.infraestructure.persistence.doobie.DoobieDbConnection
import jr.selphius.forum.module.thread.application.{ThreadCreator, ThreadRemover, ThreadSearcher, ThreadUpdater}
import jr.selphius.forum.module.thread.domain.ThreadRepository
import jr.selphius.forum.module.thread.infrastructure.repository.DoobieMysqlThreadRepository

import scala.concurrent.ExecutionContext

final class ThreadModuleDependencyContainer(doobieDbConnection: DoobieDbConnection)(
    implicit executionContext: ExecutionContext) {
  val repository: ThreadRepository   = new DoobieMysqlThreadRepository(doobieDbConnection)
  val threadSearcher: ThreadSearcher = new ThreadSearcher(repository)
  val threadCreator: ThreadCreator   = new ThreadCreator(repository)
  val threadUpdater: ThreadUpdater   = new ThreadUpdater(repository)
  val threadRemover: ThreadRemover   = new ThreadRemover(repository)
}
