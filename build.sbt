import sbt.Keys._

parallelExecution in ThisBuild := false

lazy val versions = new {
  val finatra = "18.5.0"
  val logback = "1.2.3"
}

lazy val baseSettings = Seq(
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.12.4",
  resolvers += Resolver.sonatypeRepo("releases"),
  fork in run := true
)

lazy val root = (project in file("."))
  .settings(
    name := "finatra-thrift-server-example",
    organization := "com.example",
    moduleName := "activator-thrift-seed",
    run := {
      (run in `server` in Compile).evaluated
    }
  )
  .aggregate(server)

lazy val server = (project in file("server"))
  .settings(baseSettings)
  .settings(
    name := "thrift-server",
    moduleName := "thrift-server",
    //    mainClass in (Compile, run) := Some("com.delprks.finatra_server.HelloWorldServer"),
    javaOptions ++= Seq(
      "-Dlog.service.output=/dev/stderr",
      "-Dlog.access.output=/dev/stderr"
    ),
    libraryDependencies ++= Seq(
      //      "com.twitter" %% "finatra-thrift" % versions.finatra,
      //      "com.twitter" %% "finatra-http" % versions.finatra,
      //      "ch.qos.logback" % "logback-classic" % versions.logback,
      //      "com.twitter" %% "finatra-thrift" % versions.finatra % "test",
      //      "com.twitter" %% "inject-app" % versions.finatra % "test",
      //      "com.twitter" %% "inject-core" % versions.finatra % "test",
      //      "com.twitter" %% "inject-modules" % versions.finatra % "test",
      //      "com.twitter" %% "inject-server" % versions.finatra % "test",
      //      "com.twitter" %% "finatra-thrift" % versions.finatra % "test" classifier "tests",
      //      "com.twitter" %% "inject-app" % versions.finatra % "test" classifier "tests",
      //      "com.twitter" %% "inject-core" % versions.finatra % "test" classifier "tests",
      //      "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests",
      //      "com.twitter" %% "inject-server" % versions.finatra % "test" classifier "tests"
      "com.twitter" %% "finatra-http" % "18.5.0",
      "com.twitter" %% "finatra-thrift" % "18.5.0",
      "ch.qos.logback" % "logback-classic" % "1.2.3"
    )
  )
  .dependsOn(idl)

lazy val idl = (project in file("idl"))
  .settings(baseSettings)
  .settings(
    name := "thrift-idl",
    moduleName := "thrift-idl",
    libraryDependencies ++= Seq(
      "org.apache.thrift" % "libthrift" % "0.9.2",
      "com.twitter" %% "finatra-thrift" % versions.finatra exclude("com.twitter", "libthrift")
    )
  )

lazy val client = (project in file("client"))
  .settings(baseSettings)
  .settings(name := "thrift-client")
  .dependsOn(server)
