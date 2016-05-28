import algorithm.PageRank
import org.scalatest.{Matchers, WordSpec}
import structure.{Graph, Node}

class PageRankTest extends WordSpec with Matchers {

  val abstractAlgorithm = new {} with PageRank {}

  "The pagerank " should {
    val first = Node("First", 1.0)
    val second = Node("Second", 2.0)
    val third = Node("Third", 1.0)
    val forth = Node("Forth", 0.5)
    val graph = Graph(Map(
      first ->  Nil,
      second -> (first :: third :: Nil),
      third -> (first :: Nil),
      forth -> (first :: second :: third :: Nil)
    ))

    "check how many inlinks a node has " in {
      abstractAlgorithm.outlinkTo(first, graph) should have size 3
    }

    "determine what nodes outlinks to a node " in {
      val outlinks = abstractAlgorithm.outlinkTo(first, graph)
      outlinks.keys should contain (second)
      outlinks.keys should contain (third)
      outlinks.keys should contain (forth)
    }

    "rank a simple graph nodes " in {
      val ranked = abstractAlgorithm.simpleRank(graph)
      ranked.keys should have size 4
      ranked(first) should be > ranked(second)
      ranked(first) should be > ranked(third)
      ranked(first) should be > ranked(forth)
      ranked(third) should be > ranked(second)
      ranked(third) should be > ranked(forth)
      ranked(second) should be > ranked(forth)
    }
  }

}
