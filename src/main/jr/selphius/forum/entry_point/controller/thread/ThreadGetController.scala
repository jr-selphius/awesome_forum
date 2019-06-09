package jr.selphius.forum.entry_point.controller.thread

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.thread.application.ThreadSearcher
import spray.json.DefaultJsonProtocol

import jr.selphius.forum.module.thread.infrastructure.marshaller.ThreadMarshaller._

final class ThreadGetController(threadSearcher: ThreadSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(threadSearcher.searchAll())
}
