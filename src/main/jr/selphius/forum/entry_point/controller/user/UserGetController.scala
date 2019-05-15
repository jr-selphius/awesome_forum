package jr.selphius.forum.entry_point.controller.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.user.application.UsersSearcher
import jr.selphius.forum.module.user.infrastructure.marshaller.UserMarshaller._
import spray.json.DefaultJsonProtocol

final class UserGetController(searcher: UsersSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.searchAll())
}
