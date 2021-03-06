name := BuildConfig.name

organization := BuildConfig.organisation

version := BuildConfig.version

scalaVersion := ScalaConfig.version
scalacOptions ++= ScalaConfig.compilerOptions

resolvers += "vaadin-addons" at "http://maven.vaadin.com/vaadin-addons"

lazy val root = (project in file("."))
  .settings(inThisBuild(Seq(
    libraryDependencies := Dependencies.codeDeps
  )))
  .aggregate(work)

lazy val work = (project in file("work"))
  .enablePlugins(JettyPlugin)
  .settings(
    containerLibs in Jetty := Seq(Dependencies.jettyLib)
  )
