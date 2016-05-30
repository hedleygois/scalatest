import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.{BeforeAndAfter, Matchers, WordSpec}
import structure.{Graph, Node}

class ImportanceCalculatorTest extends WordSpec with Matchers with MockitoSugar {

  val calculator = mock[ImportanceCalculator]

  "The importance calculator " should {
    "calculate using sorting algorithm when the graph is bigger than 10000 nodes " in {
      val graph = DataProvider.hugeGraph
      when(calculator.calculate(graph)).thenCallRealMethod()
      when(calculator.sort(graph)).thenReturn(List[Node]())
      calculator.calculate(graph)
      verify(calculator).sort(graph)
    }

    "calculate using bridges when the graph is smaller than 10000 nodes and it has bridges " in {
        val graph = DataProvider.smallGraphWithBridges
        when(calculator.calculate(graph)).thenCallRealMethod()
        when(calculator.bridges(graph)).thenCallRealMethod()
        calculator.calculate(graph)
        verify(calculator).bridges(graph)
    }
    "calculate using page rank when the graph is smaller than 10000 nodes and it has NO bridges" in {
      val graph = DataProvider.smallGraphWithoutBridges
      when(calculator.calculate(graph)).thenCallRealMethod()
      when(calculator.bridges(graph)).thenReturn(Map[Node, List[Node]]())
      when(calculator.simpleRank(graph)).thenReturn(Map[Node, Double]())
      calculator.calculate(graph)
      verify(calculator).simpleRank(graph)
    }
  }

}
