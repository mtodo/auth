package com.github.mtodo.auth

import org.scalatra._

import slick.driver.H2Driver.api._

class Signin(db: Database) extends ScalatraServlet {
  get("/") {
    <h1>Login</h1>
  }
}
