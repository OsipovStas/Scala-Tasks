package ru.spbau.osipov.tasks

import org.specs2.mutable.Specification
import scala.collection.JavaConverters._
import ru.spbau.osipov.tasks.list.AwesomeList._
import scala.language.implicitConversions
import java.util

/**
 * @author stasstels
 * @since 1/26/14.
 */
class AwesomeListSpec extends Specification {

  "AwesomeList " can {
    "apply map on ArrayList " in {
      val list = new util.ArrayList[Integer](Seq[Integer](1, 2, 3).asJavaCollection)
      val expected = new util.ArrayList[String](Seq[String]("1", "2", "3").asJavaCollection)
      list.map(_.toString) mustEqual expected
    }

    "apply flatMap on ArrayList " in {
      val list = new util.ArrayList[String](Seq("Timbo John", "Alan Smith", "Jersey One").asJavaCollection)
      val expected = new util.ArrayList[String](Seq[String]("Timbo", "John", "Alan", "Smith", "Jersey", "One").asJavaCollection)
      list.flatMap(_.split(" ")) mustEqual expected
    }

    "apply filter on ArrayList " in {
      val list = new util.ArrayList[Integer](Seq[Integer](2, 8, 1).asJavaCollection)
      val expected = new util.ArrayList[Integer](Seq[Integer](2, 1).asJavaCollection)
      list.filter(_ < 5) mustEqual expected
    }

    "apply sorted on ArrayList " in {
      val list = new util.ArrayList[Integer](Seq[Integer](2, 9, 2, -1).asJavaCollection)
      val expected = new util.ArrayList[Integer](Seq[Integer](-1, 2, 2, 9).asJavaCollection)
      list.sorted mustEqual expected
    }
  }

}
