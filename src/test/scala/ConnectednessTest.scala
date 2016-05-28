import algorithm.Connectedness
import org.scalatest.{Matchers, WordSpec}
import structure.{Graph, Node}

class ConnectednessTest extends WordSpec with Matchers {

  val abstractAlgorithm = new {} with Connectedness {}

  "A Connectedness algorithm " should {
    "check a not connected graph " in {
      val first = Node("First", 1.0)
      val second = Node("Second", 2.0)
      val third = Node("Third", 1.0)
      val forth = Node("Forth", 0.5)
      val fifth = Node("Fifth", 0.3)
      val graph = Graph(Map(
        first -> (second :: Nil),
        second -> (third :: Nil),
        third -> (forth :: fifth :: Nil),
        forth -> (Nil),
        fifth -> (second :: Nil)
      ))
      abstractAlgorithm connected(graph) should be (false)
    }
    "check a connected graph " in {
      val first = Node("First", 1.0)
      val second = Node("Second", 2.0)
      val third = Node("Third", 1.0)
      val forth = Node("Forth", 0.5)
      val fifth = Node("Fifth", 0.3)
      val graph = Graph(Map(
        first -> (second :: Nil),
        second -> (third :: Nil),
        third -> (forth :: fifth :: Nil),
        forth -> (first :: Nil),
        fifth -> (second :: Nil)
      ))
      abstractAlgorithm connected(graph) should be (true)
    }
  }

}
