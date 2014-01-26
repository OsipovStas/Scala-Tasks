package ru.spbau.osipov.tasks.lock

/**
 * @author stasstels
 * @since 1/26/14.
 */
object LazyLock extends App {

  object A {
    lazy val a = {
      Thread.sleep(3000)
      B.b
    }
    lazy val c = 19990
  }

  object B {
    lazy val b = A.c
  }

  val t1 = new Thread() {
    override def run(): Unit = {
      println("t1 -->" + A.a)
    }
  }

  val t2 = new Thread() {
    override def run(): Unit = {
      println("t2 --> " + B.b)
    }
  }

  t1.start()
  t2.start()
  t1.join()
  t2.join()
  println("No lock!")
}
