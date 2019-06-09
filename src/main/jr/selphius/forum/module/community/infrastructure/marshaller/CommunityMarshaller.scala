package jr.selphius.forum.module.community.infrastructure.marshaller

import java.util.UUID

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import jr.selphius.forum.module.community.domain.{Community, CommunityId, CommunityTitle}
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}

object CommunityMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object CommunityTitleMarshaller extends JsonFormat[CommunityTitle] {
    override def write(value: CommunityTitle): JsValue = JsString(value.value)

    override def read(value: JsValue): CommunityTitle = value match {
      case JsString(title) => CommunityTitle(title)
      case _               => throw DeserializationException("Expected 1 string for Community title")
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
    override def write(value: CommunityId): JsValue = JsString(value.value.toString)

    override def read(value: JsValue): CommunityId = value match {
      case JsString(id) => CommunityId(id)
      case _            => throw DeserializationException("Expected 1 string for CommunityId")
    }
  }

  implicit val communityFormat: RootJsonFormat[Community] = jsonFormat2(
    Community.apply(_: CommunityId, _: CommunityTitle))

}
