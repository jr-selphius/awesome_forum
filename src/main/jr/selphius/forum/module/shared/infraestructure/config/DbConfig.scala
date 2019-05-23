package jr.selphius.forum.module.shared.infraestructure.config

import com.typesafe.config.Config

object DbConfig {

  def apply(dbConfig: Config): DbConfig = DbConfig(
    driver = dbConfig.getString("driver"),
    url = dbConfig.getString("url"),
    user = dbConfig.getString("user"),
    password = dbConfig.getString("password")
  )

  final case class DbConfig(driver: String, url: String, user: String, password: String)
}
