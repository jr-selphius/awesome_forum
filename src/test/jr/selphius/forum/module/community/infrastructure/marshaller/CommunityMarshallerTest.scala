package jr.selphius.forum.module.community.infrastructure.marshaller

import jr.selphius.forum.module.community.domain.Community
import spray.json.{JsArray, JsObject, JsString}

object CommunityMarshallerTest {
  def marshall(communities: Seq[Community]): JsArray = JsArray(
    communities
      .map(
        community =>
          JsObject(
            "id"    -> JsString(community.id.value.toString),
            "title" -> JsString(community.title.value.toString)
        ))
      .toVector
  )
}
