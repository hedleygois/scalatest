package algorithm

import structure.Graph

trait Sorting {
  /**
    * Time Complexity is O(n log(n)) - http://stackoverflow.com/questions/14146990/what-algorithm-is-used-by-the-scala-library-method-vector-sorted
    */
  def sort(graph: Graph) = graph.structure.map(_._1).toList.sortBy(node => node.failureRate)
}
