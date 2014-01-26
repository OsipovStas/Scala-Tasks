package ru.spbau.osipov.tasks.conversion
import scala.language.implicitConversions

/**
 * @author stasstels
 * @since 1/26/14.
 */
object TransiteConversion {

  class A(val name: String)

  class B(val name: String)

  class C(val name: String)

  implicit def a2b(that: A) = new B(that.name)

  implicit def b2c[T <% B](that: T) = new C(that.name)

  def foo1(arg: B) = arg.name

  def foo2(arg: C) = arg.name

}
