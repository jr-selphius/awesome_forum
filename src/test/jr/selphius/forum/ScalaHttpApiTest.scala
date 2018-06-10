package jr.selphius.forum

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.server.Directives._

final class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  private val routesWithDefinedResponses =
    get {
      path("forums") {
        complete(HttpEntity(ContentTypes.`application/json`, """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""))
      }
    }

  "ScalaHttpApi" should {

    "respond successfully while requesting a forum" in {
      Get("/forums") ~> routesWithDefinedResponses ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""
      }
    }
  }
}
