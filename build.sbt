name := "YTApi"

version := "0.1"

scalaVersion := "2.13.1"

mainClass := Some("org.ua.ilm.Main.Main")

libraryDependencies += "com.google.apis" % "google-api-services-youtube" % "v3-rev221-1.25.0"
libraryDependencies += "com.typesafe" % "config" % "1.4.0"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.1"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.10.1"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.10.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test