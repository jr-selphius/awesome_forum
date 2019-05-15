package jr.selphius.forum.entry_point.controller.community

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.community.application.CommunityCreator
import jr.selphius.forum.module.community.domain.{CommunityId, CommunityTitle}

final class CommunityPostController(communityCreator: CommunityCreator) {
  def post(communityId: String, communityTitle: String): StandardRoute = {
    communityCreator.create(CommunityId(communityId), CommunityTitle(communityTitle))
    complete(HttpResponse(StatusCodes.NoContent))
  }
}
