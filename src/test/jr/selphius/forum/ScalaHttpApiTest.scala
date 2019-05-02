package jr.selphius.forum

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import jr.selphius.forum.entry_point.Routes
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

final class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  "ScalaHttpApi" should {

    "respond successfully while requesting communities" in {
      Get("/communities") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""
      }
    }
  }

  "ScalaHttpApi" should {

    "respond successfully while requesting users" in {
      Get("/users") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """[ { "id": 1 , "title": "The powerful" } , { "id" = 2 , "title": "The weakest"} ]"""
      }
    }
  }
}
