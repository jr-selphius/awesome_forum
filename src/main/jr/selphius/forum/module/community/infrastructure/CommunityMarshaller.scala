package jr.selphius.forum.module.community.infrastructure

import java.util.UUID

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import jr.selphius.forum.module.community.domain.{Community, CommunityId, CommunityName}
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}

object CommunityMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object CommunityNameMarshaller extends JsonFormat[CommunityName] {
    override def write(value: CommunityName): JsValue = JsString(value.value)

    override def read(value: JsValue): CommunityName = value match {
      case JsString(name) => CommunityName(name)
      case _              => throw DeserializationException("Expected 1 string for Username")
    }
  }

  implicit object UuidMarshaller extends JsonFormat[UUID] {
    override def write(value: UUID): JsValue = JsString(value.toString)

    override def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected 1 hexadecimal for UUID")
    }
  }

  implicit object CommunityIdMarshaller extends JsonFormat[CommunityId] {
    override def write(value: CommunityId): JsValue = JsString(value.toString)

    override def read(value: JsValue): CommunityId = value match {
      case JsString(id) => CommunityId(id)
      case _            => throw DeserializationException("Expected 1 string for UserId")
    }
  }

  implicit val communityFormat: RootJsonFormat[Community] = jsonFormat2(
    Community.apply(_: CommunityId, _: CommunityName))

}
