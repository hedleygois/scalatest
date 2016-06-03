package algorithm

import structure.Graph

trait Connectedness extends DFS {
  def connected(graph: Graph) = graph.structure.keySet.forall(node => traverse(node, graph).distinct.size == graph.structure.keySet.size)
}
