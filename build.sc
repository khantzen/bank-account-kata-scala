import mill._, scalalib._

trait Scalatest extends TestModule {
  override def  ivyDeps =
    Agg(ivy"org.scalatest::scalatest:3.2.0")
  override def testFrameworks = Seq("org.scalatest.tools.Framework")
}

object core extends ScalaModule{
  def scalaVersion = "2.13.2"
  object test extends Tests with Scalatest {}
}

