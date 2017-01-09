lazy val root = project.in(file("."))
  .settings(tutSettings)

tutSourceDirectory := sourceDirectory.value / "pages"

tutTargetDirectory := target.value / "pages"

scalaVersion := "2.11.8"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-Ywarn-dead-code",
  "-Xlint",
  "-Xfatal-warnings"
)

