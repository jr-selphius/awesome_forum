package jr.selphius.forum.entry_point.controller.community

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.community.application.CommunitiesSearcher
import jr.selphius.forum.module.community.infrastructure.marshaller.CommunityMarshaller._
import spray.json.DefaultJsonProtocol

final class CommunityGetController(communitiesSearcher: CommunitiesSearcher)
    extends SprayJsonSupport
    with DefaultJsonProtocol {
  def get(): StandardRoute = complete(communitiesSearcher.searchAll())
}
