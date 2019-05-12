package jr.selphius.forum.module.user.infrastructure.marshaller

import jr.selphius.forum.module.user.domain.User
import spray.json.{JsArray, JsObject, JsString}

object UserMarshaller {
  def marshall(users: Seq[User]): JsArray = JsArray(
    users
      .map(
        user =>
          JsObject(
            "id"   -> JsString(user.id.value.toString),
            "name" -> JsString(user.name.value.toString)
        ))
      .toVector
  )
}
