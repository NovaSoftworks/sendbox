ThisBuild / scalaVersion := "2.12.12"
ThisBuild / organization := "com.novasoftworks.sendbox"

lazy val root = (project in file(".")).settings(
  name    := "sendbox-core",
  version := "0.1-SNAPSHOT",
  libraryDependencies ++= Seq(
    "com.sun.mail"   % "jakarta.mail"     % "2.0.1",
    "jakarta.mail"   % "jakarta.mail-api" % "2.1.2",
    "org.scalatest" %% "scalatest"        % "3.2.16" % Test,
    "org.scalamock" %% "scalamock"        % "5.2.0"  % Test
  )
)
