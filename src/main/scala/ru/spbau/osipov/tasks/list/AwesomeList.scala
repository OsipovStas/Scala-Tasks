package ru.spbau.osipov.tasks.list

import scala.collection.JavaConverters._
import scala.collection.GenTraversableOnce
import java.util

/**
 * @author stasstels
 * @since 1/26/14.
 */
object AwesomeList {


  implicit class AwesomeList[A](val list: java.util.ArrayList[A]) extends AnyVal {

      def map[B](f: (A) => B): java.util.ArrayList[B] = new java.util.ArrayList[B](list.asScala.map(f).asJavaCollection)

      def flatMap[B](f: (A) => GenTraversableOnce[B]): java.util.ArrayList[B] = new java.util.ArrayList[B](list.asScala.flatMap(f).asJavaCollection)

      def filter(p: (A) => Boolean): util.ArrayList[A] = new util.ArrayList[A](list.asScala.filter(p).asJavaCollection)

      def foreach(f: (A) => Unit): Unit = list.asScala.foreach(f)

      def sorted[B >: A](implicit ord: math.Ordering[B]): java.util.ArrayList[B] = new util.ArrayList[B](list.asScala.sorted(ord).asJavaCollection)

  }
}
