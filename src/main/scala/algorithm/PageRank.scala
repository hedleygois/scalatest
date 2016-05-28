package algorithm

import structure.{Node, Graph}

trait PageRank {

  /**
    *
    * Time complexity is O(n+m) - n: node and m: edges
    *
    */
  def simpleRank(graph: Graph): Map[Node, Double] = {
    val amortizationFactor = 0.85
    val initialProbability = 1 / graph.structure.keys.size.toDouble
    //TODO Map it directly to a mutable.Map
    val probability = for(key <- graph.structure.keys) yield (key -> initialProbability.toDouble)
    val probabilityMap = collection.mutable.Map() ++ probability.toMap
    //TODO We can stop when converging but this is a simple example
    for(i <- 0 to 5) {
      graph.structure.foreach(value => probabilityMap(value._1) = 1 - amortizationFactor/graph.structure.keys.size.toDouble +
        amortizationFactor *
          outlinkTo(value._1, graph).map(kv => (kv._1,probabilityMap(kv._1))).map(mapped => mapped._2/graph.structure(mapped._1).size.toDouble).sum)
    }
    probabilityMap toMap
  }

  def outlinkTo(node: Node, graph: Graph) = graph.structure.filterKeys(n => graph.structure(n).contains(node))

}

