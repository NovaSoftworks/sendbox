ThisBuild / scalaVersion  := "2.12.12"
ThisBuild / organization  := "com.novasoftworks.sendbox"
ThisBuild / versionScheme := Some("semver-spec")

lazy val root = (project in file(".")).settings(
  name                       := "sendbox-core",
  version                    := "1.0.0",
  coverageEnabled            := true,
  coverageFailOnMinimum      := true,
  coverageMinimumStmtTotal   := 70,
  coverageMinimumBranchTotal := 90,
  libraryDependencies ++= Seq(
    "com.sun.mail"   % "jakarta.mail"     % "2.0.1",
    "jakarta.mail"   % "jakarta.mail-api" % "2.1.2",
    "org.scalatest" %% "scalatest"        % "3.2.16" % Test,
    "org.scalamock" %% "scalamock"        % "5.2.0"  % Test
  ),

  // Publishing settings
  publishTo := Some("GitHub Packages" at "https://maven.pkg.github.com/NovaSoftworks/sendbox"),
  credentials += Credentials(
    "GitHub Package Registry",
    "maven.pkg.github.com",
    "",
    sys.env.getOrElse("GITHUB_TOKEN", "")
  ),
  publishMavenStyle      := true,
  Test / publishArtifact := false,
  pomIncludeRepository   := { _ => true },

  // Artifact metadata
  pomExtra :=
    <description>A simple and intuitive Scala library for seamless email sending. </description>
    <url>https://github.com/NovaSoftworks/sendbox</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://github.com/NovaSoftworks/sendbox/blob/main/LICENSE</url>
      </license>
    </licenses>
)
