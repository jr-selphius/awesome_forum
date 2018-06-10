import sbt._

object Dependencies {

  val production = Seq(
    "com.github.nscala-time" %% "nscala-time" % "2.18.0",
    "com.lihaoyi"            %% "pprint"      % "0.5.3"
  )

  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.0.4" % Test,
    "org.scalamock" %% "scalamock" % "4.0.0" % Test
  )

}
