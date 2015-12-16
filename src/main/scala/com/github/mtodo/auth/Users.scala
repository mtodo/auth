package com.github.mtodo.auth

import concurrent.ExecutionContext.Implicits.global

import slick.driver.H2Driver.api._

case class User(id: Option[Int], email: String, encPassword: String)

class Users(tag: Tag) extends Table[User](tag, "USERS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def email = column[String]("EMAIL")
  def encPassword = column[String]("ENC_PASSWORD")

  def * = (id.?, email, encPassword).shaped <> ({
    t: (Option[Int], String, String) => User.tupled(t)
  }, {
    u: User => User.unapply(u)
  })
}
