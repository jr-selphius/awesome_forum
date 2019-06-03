package jr.selphius.forum.entry_point.controller.community

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.community.application.CommunityRemover
import jr.selphius.forum.module.community.domain.CommunityId

final class CommunityDeleteController(communityRemover: CommunityRemover) {
  def delete(communityId: String): StandardRoute = {
    communityRemover.remove(CommunityId(communityId))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
