import Dependencies._

ThisBuild / scalaVersion     := "3.7.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "mapreduce",
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.6.1"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
