import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.ctws",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "JW BLOCKCHAIN",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.google.guava" % "guava" % "27.0.1-jre"
  )
