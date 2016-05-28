package algorithm

import structure.{Node, Graph}

trait Bridges extends DFS with Connectedness {

  def find(graph: Graph): Map[Node, List[Node]] = {
    val bridges = scala.collection.mutable.Map[Node, List[Node]]()
    graph.structure.keys.foreach(key => {
      graph.structure(key).foreach(child => {
        val mutableGraph = scala.collection.mutable.Map[Node, List[Node]]() ++= graph.structure
        mutableGraph(key) = mutableGraph(key).filter(node => !node.equals(child))
        if(!connected(Graph(mutableGraph.toMap))) {
          if(bridges get (key) isDefined) {
            bridges(key) = bridges(key) :+ child
          }
          else bridges put (key, List(child))
        }
      })
    })
    bridges.toMap
  }

}
