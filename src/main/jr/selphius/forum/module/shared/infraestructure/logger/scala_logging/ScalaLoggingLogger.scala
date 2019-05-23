package jr.selphius.forum.module.shared.infraestructure.logger.scala_logging

import jr.selphius.forum.module.shared.domain.{Logger => LoggerContract}

final class ScalaLoggingLogger extends LoggerContract {
  override def debug(message: String): Unit = {}

  override def info(message: String): Unit = {}

  override def warn(message: String): Unit = {}

  override def error(message: String): Unit = {}
}
