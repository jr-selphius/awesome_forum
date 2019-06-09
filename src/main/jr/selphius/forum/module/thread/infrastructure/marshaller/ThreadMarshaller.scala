package jr.selphius.forum.module.thread.infrastructure.marshaller

import java.util.UUID

import jr.selphius.forum.module.community.domain.CommunityId
import jr.selphius.forum.module.thread.domain.{Subject, Thread, ThreadId}
import jr.selphius.forum.module.user.domain.UserId
import spray.json.DefaultJsonProtocol.jsonFormat4
import spray.json.{DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}

object ThreadMarshaller {

  implicit object SubjectMarshaller extends JsonFormat[Subject] {
    def write(value: Subject): JsValue = JsString(value.value)

    def read(value: JsValue): Subject = value match {
      case JsString(subject) => Subject(subject)
      case _                 => throw DeserializationException("Expected 1 string for Subject")
    }
  }

  implicit object UuidMarshaller extends JsonFormat[UUID] {
    def write(value: UUID): JsValue = JsString(value.toString)

    def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected hexadecimal UUID string")
    }
  }

  implicit object ThreadIdMarshaller extends JsonFormat[ThreadId] {
    def write(value: ThreadId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): ThreadId = value match {
      case JsString(id) => ThreadId(id)
      case _            => throw DeserializationException("Expected 1 string for ThreadId")
    }
  }

  implicit object UserIdMarshaller extends JsonFormat[UserId] {
    def write(value: UserId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): UserId = value match {
      case JsString(id) => UserId(id)
      case _            => throw DeserializationException("Expected 1 string for UserId")
    }
  }

  implicit object CommunityIdMarshaller extends JsonFormat[CommunityId] {
    def write(value: CommunityId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): CommunityId = value match {
      case JsString(id) => CommunityId(id)
      case _            => throw DeserializationException("Expected 1 string for CommunityId")
    }
  }

  implicit val threadFormat: RootJsonFormat[Thread] = jsonFormat4(
    Thread.apply(_: ThreadId, _: Subject, _: UserId, _: CommunityId))
}
