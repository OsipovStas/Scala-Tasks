package ru.spbau.osipov.tasks

import org.specs2.mutable.Specification
import ru.spbau.osipov.tasks.complex.Complex
import ru.spbau.osipov.tasks.complex.Complex._
import scala.language.implicitConversions
/**
 * @author stasstels
 * @since 1/26/14.
 */
class ComplexSpec extends Specification {

  "Complex number " can {
    "be used with other numeric types" in {
      val z1 = Complex(1, 2)
      val z2 = Complex(3, 4)
      val b: Byte = 3
      z1 + z2 mustEqual Complex(4, 6)
      z2 - 2 mustEqual Complex(1, 4)
      z1 / b mustEqual Complex(0.6,1.2)
      1 * z1 mustEqual z1
      z1 ^ z2 mustNotEqual z1
    }

    "be constructed from string" in {
      new Complex("11.4234 +2.4234e+3i") mustEqual Complex(11.4234,2423.4)
      new Complex("-11 -2i") mustEqual Complex(-11,-2)
      new Complex("1 +2.234I") mustEqual Complex(1.0,2.234)
    }

  }

  "Complex number " should  {

    "have methods abs, sqrt, conj" in {
      val z1 = Complex(1, 2)
      z1.conj mustEqual Complex(1.0,-2.0)
      z1.abs mustEqual 2.23606797749979
      z1.sqrt mustEqual Complex(1.272019649514069,0.7861513777574233)

    }

    "have I, Re, Im accessor" in {
      val z1 = Complex(1, 2)
      Re(I) mustEqual 0.0d
      Im(I) mustEqual 1.0d
      Re(z1) mustEqual 1
    }

  }

}
