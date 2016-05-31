import algorithm.Sorting
import org.scalatest.{Matchers, WordSpec}

class SortingTest extends WordSpec with Matchers {

  val abstractAlgorithm = new {} with Sorting {}

  "The sorting algorithm " should {
    "sort by the failure rate " in {
      val graph = DataProvider.connectedSmallGraph
      val keys = graph.structure.keySet.toList
      val sorted = abstractAlgorithm.sort(graph)
      sorted should have size 5
      sorted(0).failureRate should be > sorted(1).failureRate
      sorted(1).failureRate should be > sorted(2).failureRate
      sorted(2).failureRate should be > sorted(3).failureRate
      sorted(3).failureRate should be > sorted(4).failureRate
    }
  }

}
