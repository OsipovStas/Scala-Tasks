package ru.spbau.osipov.tasks

import org.specs2.mutable.Specification
import ru.spbau.osipov.tasks.conversion.TransiteConversion._
import scala.language.implicitConversions
/**
 * @author stasstels
 * @since 1/26/14.
 */
class ConversionSpec extends Specification {
  "It is " should {
    "possible implement 3 conversions with 2 implicits " in {
      val a = new A("It is A")
      val b = new B("It is B")
      val c = new C("It is C")

      foo1(b) mustEqual "It is B"
      foo1(a) mustEqual "It is A"

      foo2(c) mustEqual "It is C"
      foo2(b) mustEqual "It is B"
      foo2(a) mustEqual "It is A"
    }
  }
}
