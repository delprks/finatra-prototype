version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

name := "thrift-server"

moduleName := "thrift-server"

javaOptions ++= Seq(
  "-Dlog.service.output=/dev/stderr",
  "-Dlog.access.output=/dev/stderr"
)

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % "18.5.0",
  "com.twitter" %% "finatra-thrift" % "18.5.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
