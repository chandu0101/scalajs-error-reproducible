
name := "scalajs-error-reproducible"

version := "1.0"

scalaVersion := "2.11.6"

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)


libraryDependencies += "com.chandu0101.scalajs-react-components" %%% "core" % "0.0.1-SNAPSHOT"

jsDependencies ++=  Seq(
  "org.webjars" % "react" % "0.12.1" / "react-with-addons.js" commonJSName "React")


// creates single js resource file for easy integration in html page
skip in packageJSDependencies := false


// copy  javascript files to js folder,that are generated using fastOptJS/fullOptJS

crossTarget in (Compile, fullOptJS) := file("js")

crossTarget in (Compile, fastOptJS) := file("js")

crossTarget in (Compile, packageJSDependencies) := file("js")

crossTarget in (Compile, packageScalaJSLauncher) := file("js")

artifactPath in (Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
  ((moduleName in fastOptJS).value + "-opt.js"))

scalacOptions += "-feature"

