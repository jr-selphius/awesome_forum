package jr.selphius.forum.module.user.infrastructure.marshaller

import java.util.UUID

import jr.selphius.forum.module.user.domain.{Email, User, UserId, Username}
import spray.json.DefaultJsonProtocol.jsonFormat3
import spray.json.{DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}

object UserMarshaller {

  implicit object UserEmailMarshaller extends JsonFormat[Email] {
    def write(value: Email): JsValue = JsString(value.value)

    def read(value: JsValue): Email = value match {
      case JsString(email) => Email(email)
      case _              => throw DeserializationException("Expected 1 string for Email")
    }
  }

  implicit object UserNameMarshaller extends JsonFormat[Username] {
    def write(value: Username): JsValue = JsString(value.value)

    def read(value: JsValue): Username = value match {
      case JsString(name) => Username(name)
      case _              => throw DeserializationException("Expected 1 string for UserName")
    }
  }

  implicit object UuidMarshaller extends JsonFormat[UUID] {
    def write(value: UUID): JsValue = JsString(value.toString)

    def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected hexadecimal UUID string")
    }
  }

  implicit object UserIdMarshaller extends JsonFormat[UserId] {
    def write(value: UserId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): UserId = value match {
      case JsString(id) => UserId(id)
      case _            => throw DeserializationException("Expected 1 string for UserId")
    }
  }

  implicit val userFormat: RootJsonFormat[User] = jsonFormat3(User.apply(_: UserId, _: Username, _: Email))
}
