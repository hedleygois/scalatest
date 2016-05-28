import algorithm.Bridges
import org.scalatest.{Matchers, WordSpec}
import structure.{Graph, Node}

class BridgesTest extends WordSpec with Matchers {

  val abstractAlgorithm = new {} with Bridges {}

  "A bridges algorithm " should {
    val first = Node("First", 1.0)
    val second = Node("Second", 2.0)
    val third = Node("Third", 1.0)
    val forth = Node("Forth", 0.5)
    val fifth = Node("Fifth", 0.3)
    val graph = Graph(Map(
      first -> (second :: third :: Nil),
      second -> (first :: third :: Nil),
      third -> (first :: second :: forth :: Nil),
      forth -> (third :: fifth :: Nil),
      fifth -> (forth :: Nil)
    ))

    "detect bridges " in {
      val bridges = abstractAlgorithm.find(graph)
      bridges.size should be (3)
      bridges(forth) should be (List(third, fifth))
      bridges(fifth) should be (List(forth))
      bridges(third) should be (List(forth))
    }
  }

}
