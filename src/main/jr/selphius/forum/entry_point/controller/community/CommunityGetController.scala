package jr.selphius.forum.entry_point.controller.community

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import jr.selphius.forum.module.community.domain.Community
import jr.selphius.forum.module.community.infrastructure.CommunityMarshaller._
import spray.json.DefaultJsonProtocol

object CommunityGetController extends SprayJsonSupport with DefaultJsonProtocol {

  private val communities = Seq(
    Community(
      id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee",
      title = "🎥 Scala FTW vol. 1"
    ),
    Community(
      id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97",
      title = "🔝 Interview with Odersky"
    )
  )

  def apply(): StandardRoute = complete(communities)

}
