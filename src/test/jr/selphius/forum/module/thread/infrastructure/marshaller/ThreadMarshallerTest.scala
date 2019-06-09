package jr.selphius.forum.module.thread.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import jr.selphius.forum.module.thread.domain.Thread

object ThreadMarshallerTest {
  def marshall(threads: Seq[Thread]): JsArray = JsArray(
    threads
      .map(
        thread =>
          JsObject(
            "id"          -> JsString(thread.id.value.toString),
            "subject"     -> JsString(thread.subject.value.toString),
            "creatorId"   -> JsString(thread.creatorId.value.toString),
            "communityId" -> JsString(thread.communityId.value.toString)
        ))
      .toVector
  )
}
