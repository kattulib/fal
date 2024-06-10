import Dependencies._

ThisBuild / scalaVersion := "3.4.2"
ThisBuild / version := "1.0"
ThisBuild / name := "FAL"
ThisBuild / organization := "com.csgn"
ThisBuild / description := "Functional mAtching Library"
ThisBuild / licenses := List(("Apache 2.0", url("https://opensource.org/license/apache-2-0")))
ThisBuild / testFrameworks += new TestFramework("munit.Framework")

val scala3Version = "3.4.2"

lazy val core = crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Full)
    // Common settings
    .settings(
        libraryDependencies ++= {
            Seq(
                munit.value % Test,
            )
        },
    )
    // JS-specific settings
    .jsSettings(
    )
    // JVM-specific settings
    .jvmSettings(
    )
    // Native-specific settings
    .nativeSettings(
    )

lazy val coreJVM = core.jvm
lazy val coreJS = core.js
lazy val coreNative = core.native

lazy val root = project
    .in(file("."))
    .aggregate(coreJVM, coreJS, coreNative)
