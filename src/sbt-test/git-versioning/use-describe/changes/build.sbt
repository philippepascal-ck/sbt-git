import com.typesafe.sbt.SbtGit._

versionWithGit

git.baseVersion := "0.1"
git.versionProperty := "DUMMY_BUILD_VERSION"
git.useGitDescribe := true

val checkVersion = taskKey[Unit]("checks the version is the tag versino")
checkVersion := {
  val v = version.value
  assert(v != "1.0.0", s"Version from ThisBuild + git describe not used, found ${v}")
  assert(v startsWith "v1.0.0", s"Version from ThisBuild does not start with tag (git describe), found ${v}")
}