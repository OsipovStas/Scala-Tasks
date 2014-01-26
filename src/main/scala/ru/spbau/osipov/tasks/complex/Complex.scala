package ru.spbau.osipov.tasks.complex
import scala.language.implicitConversions
/**
 * @author stasstels
 * @since 1/26/14.
 */
case class Complex(re: Double, im: Double) {

  def this(re: Double) = this(re, 0)

  def this(t: (Double, Double)) = this(t._1, t._2)

  def this(repr: String) = this(Complex.parse(repr))


  lazy val conj = Complex(re, -im)
  lazy val abs = math.hypot(re, im)
  lazy val scalar = re * re + im * im
  lazy val phi = math.atan2(im, re)

  def +(that: Complex) = Complex(re + that.re, im + that.im)

  def -(that: Complex) = Complex(re - that.re, im - that.im)

  def *(that: Complex) = Complex(re * that.re - im * that.im, re * that.im + im * that.re)

  def /(that: Complex) = Complex((re * that.re + im * that.im) / scalar, (-re * that.im + im * that.re) / scalar)

  def ^(that: Complex) = {
    val c = that * Complex(math.log(abs), phi)
    Complex(math.exp(c.re) * math.cos(c.im), math.exp(c.re) * math.sin(c.im))
  }

  def sqrt = ^(new Complex(0.5))


}

object Complex {


  private val re =
    """^[-+]?[0-9]+(\.[0-9]+([eE][-+]?[0-9]+)?)?""".r

  private val im =
    """^\s*[-+][0-9]+(\.?[0-9]+([eE][-+]?[0-9]+)?)?[iI]$""".r

  val I = Complex(0.0d, 1.0d)

  object Re {
    def apply(c: Complex) = c.re
  }

  object Im {
    def apply(c: Complex) = c.im
  }

  def parse(repr: String) = re.findFirstIn(repr) match {
    case r => im.findFirstIn(repr.substring(r.getOrElse("").length)) match {
      case Some(i) => (r.getOrElse("0").toDouble, i.dropRight(1).toDouble)
      case _ => throw new NumberFormatException(repr)
    }
  }

  implicit def double2complex(d: Double) = new Complex(d)

}
