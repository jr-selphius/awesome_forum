package jr.selphius.forum.module.shared.infraestructure.persistence.doobie

import java.util.UUID

import doobie.util.meta.Meta

object TypesConversions {
  implicit val uuidMeta: Meta[UUID] = Meta[String].xmap(UUID.fromString, _.toString)
}
