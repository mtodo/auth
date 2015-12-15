name := """auth"""

organization := "com.github.mtodo"

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

// Scala Logging
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

// Scalatra
libraryDependencies ++= Seq(
    "org.scalatra"              %%  "scalatra"                    % "2.4.0.RC3",
    "org.scalatra"              %%  "scalatra-json"               % "2.4.0.RC3",
    "org.scalatra"              %%  "scalatra-scalatest"          % "2.4.0.RC3" % "test"
)

// Jetty
libraryDependencies ++= Seq(
    "org.eclipse.jetty"         %   "jetty-server"                % "9.3.+",
    "org.eclipse.jetty"         %   "jetty-servlet"               % "9.3.+",
    "org.eclipse.jetty"         %   "jetty-webapp"                % "9.3.+"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

