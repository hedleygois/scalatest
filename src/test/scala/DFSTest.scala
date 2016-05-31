import algorithm.DFS
import org.scalatest.{Matchers, WordSpec}
import structure.{Graph, Node}

class DFSTest extends WordSpec with Matchers {

  val abstractAlgorithm = new {} with DFS {}

  "A DFS " should {
    val first = Node("First", 1.0)
    val second = Node("Second", 2.0)
    val third = Node("Third", 1.0)
    val forth = Node("Forth", 0.5)
    val fifth = Node("Fifth", 0.3)
    val graph = Graph(Map(
      first -> (second :: forth :: Nil),
      second -> (third :: first :: Nil),
      third -> (forth :: fifth :: Nil),
      forth -> (Nil),
      fifth -> (second :: Nil)
    ))

    "traverse a single graph starting by the first elenent " in {
      val traversed = abstractAlgorithm traverse (first, graph)
      traversed should have size 5
      traversed should equal (first :: second :: third :: forth :: fifth :: Nil)
    }
    "traverse a graph starting on any element " in {
      val traversed = abstractAlgorithm traverse (third, graph)
      traversed should have size 5
      traversed should equal (third :: forth :: fifth :: second :: first :: Nil)
    }
  }

}
