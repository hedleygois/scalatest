import algorithm._
import structure.{Node, Graph}

class ImportanceCalculator extends Bridges with PageRank with Sorting  {
  def calculate(graph: Graph): List[Node] = {
    val size = graph.structure.size
    if(size > 10000) {
      return sort(graph)
    } else {
      val bridgesFound = bridges(graph)
      if(!bridgesFound.isEmpty) {
        return bridgesFound.toList.sortBy(_._1.failureRate).map(_._1)
      }
    }
    simpleRank(graph).toList.sortBy(_._2).map(_._1)
  }
}

object ImportanceCalculator {
  def apply() = new ImportanceCalculator()
}
