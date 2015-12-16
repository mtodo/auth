import org.scalatra.LifeCycle

import javax.servlet.ServletContext

import com.typesafe.scalalogging.LazyLogging

import slick.driver.H2Driver.api._

import akka.actor.ActorSystem

import com.github.mtodo.auth.{Signup, Signin, Users}

class ScalatraBootstrap extends LifeCycle with LazyLogging {
  val users = TableQuery[Users]
  val system = ActorSystem("Auth")

  override def init(context: ServletContext) = {
    val db = Database.forConfig("h2mem1")
    db.run(users.schema.create)

    context mount (new Signup(db, system), "/auth/signup/*")
    context mount (new Signin(db), "/auth/signin/*")
  }
}
