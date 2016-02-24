name := """template"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

// This library lets us query and manipulate student git repositories.
libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "4.0.1.201506240215-r"

// Need to pull this in for reflective capabilities.
libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)

// This includes the instructor source directory for compilation.
unmanagedSourceDirectories in Compile += baseDirectory.value / "src/instructor/scala"
