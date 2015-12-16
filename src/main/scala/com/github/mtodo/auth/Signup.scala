package com.github.mtodo.auth

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global

import org.scalatra._

import slick.driver.H2Driver.api._

import _root_.akka.actor.ActorSystem

class Signup(db: Database, system: ActorSystem) extends ScalatraServlet with FutureSupport {
  val users = TableQuery[Users]

  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/") {
    <body>
      <h1>Sign up</h1>
      <form method="POST">
        <div>
          <label for="email">Email: </label>
          <input type="email" name="email" id="email" />
        </div>

        <div>
          <label for="password">Password: </label>
          <input type="password" name="password" id="password" />
        </div>

        <div>
          <label for="confirmation">Repeat: </label>
          <input type="password" name="confirmation" id="confirmation" />
        </div>

        <input type="submit" value="Sign up" />
      </form>
    </body>
  }

  post("/") {
    val user = User(None, params("email"), params("password"))
    db.run((users returning users.map(_.id)) += user)

    new AsyncResult { val is =
      db.run(users.result)
    }
  }
}
