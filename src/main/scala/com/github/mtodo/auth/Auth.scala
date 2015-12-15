package com.github.mtodo.auth

import util.Properties
import util.Try

import com.typesafe.scalalogging.LazyLogging

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.webapp.WebAppContext

import org.scalatra.servlet.ScalatraListener

object Auth extends App with LazyLogging {
  val port = Properties
    .envOrNone("PORT")
    .flatMap(s => Try(s.toInt).toOption)
    .getOrElse(7834)

  val server = new Server(port)
  val context = new WebAppContext

  context.setContextPath("/")
  context.setResourceBase("src/main/com/github/mtodo/auth")
  context.addEventListener(new ScalatraListener)
  context.addServlet(classOf[DefaultServlet], "/")

  server.setHandler(context)

  server.start
  logger.info(s"Listening on port :$port..")
  server.join
}
