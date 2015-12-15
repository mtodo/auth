package com.github.mtodo.auth

import org.scalatra._

class Signin extends ScalatraServlet {
  get("/") {
    <h1>Login</h1>
  }
}
