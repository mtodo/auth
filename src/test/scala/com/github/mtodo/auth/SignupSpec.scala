import org.scalatra.test.scalatest._
import org.scalatest._

import slick.driver.H2Driver.api._
import akka.actor.ActorSystem

import com.github.mtodo.auth.{Signup, Users}

class SignupSpec extends ScalatraFlatSpec {
  val system = ActorSystem("Auth")
  val db = Database.forConfig("h2mem1")
  addServlet(new Signup(db, system), "/*")

  val users = TableQuery[Users]
  db.run(users.schema.create)

  "Signup page" should "render a signup form" in {
    get("/") {
      status should equal (200)
      body should include ("""input type="email" name="email"""")
      body should include ("""input type="password" name="password"""")
      body should include ("""input type="password" name="confirmation"""")
      body should include ("""input type="submit" value="Sign up"""")
    }
  }

  it should "allow to sign up for a new user" in {
    post("/", Map(
      "email" -> "john.smith@example.org",
      "password" -> "welcome",
      "confirmation" -> "welcome"
    )) {
      status should equal (302)
      header("Location") should include ("/done")
    }
  }

  it should "tell user that he or she is successfully registered" in {
    get("/done") {
      status should equal (200)
      body should include ("Successfully registered")
    }
  }
}
