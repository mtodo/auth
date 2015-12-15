package com.github.mtodo.auth

import org.scalatra._

class HelloExample extends ScalatraServlet {
  get("/") {
    <h1>Hello, World!</h1>
  }
}
