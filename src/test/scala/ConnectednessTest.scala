import algorithm.Connectedness
import org.scalatest.{Matchers, WordSpec}
import structure.{Graph, Node}

class ConnectednessTest extends WordSpec with Matchers {

  val abstractAlgorithm = new {} with Connectedness {}

  "A Connectedness algorithm " should {
    "check a not connected graph " in {
      abstractAlgorithm connected(DataProvider.notConnectedSmallGraph) should be (false)
    }
    "check a connected graph " in {
      abstractAlgorithm connected(DataProvider.connectedSmallGraph) should be (true)
    }
  }

}
