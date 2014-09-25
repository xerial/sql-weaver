name := """sql-weaver"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

val PRESTO_VERSION = "0.75"

val HIVE_VERSION = "0.13.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.facebook.presto" % "presto-cli" % PRESTO_VERSION,
  "com.facebook.presto" % "presto-parser" % PRESTO_VERSION,
  "org.apache.hive" % "hive-exec" % HIVE_VERSION
)
