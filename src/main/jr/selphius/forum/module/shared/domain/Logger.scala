package jr.selphius.forum.module.shared.domain

trait Logger {
  def debug(message: String)
  def info(message: String)
  def warn(message: String)
  def error(message: String)
}
