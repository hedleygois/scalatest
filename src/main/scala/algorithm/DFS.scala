package algorithm

import structure.{Node, Graph}

import scala.annotation.tailrec

trait DFS {

  /**
    *
    * Time complexity O(N)
    *
    */
  def traverse(initial: Node, graph: Graph): List[Node] = {
    def notVisited(initial: Node, visited: List[Node]): List[Node] = {
      graph structure(initial) filter (!visited.contains(_))
    }

    @tailrec
    def loop(initial: Node, stack: List[Node], visited: List[Node]): List[Node] = {
      val children = notVisited(initial, visited)
      val childrenWithTail = (children ++ stack.tail).distinct
      val updatedVisited = stack.head :: visited
      if(childrenWithTail isEmpty) updatedVisited
      else loop(childrenWithTail.head, childrenWithTail, updatedVisited)
    }

    //TODO Reversing is O(n) and appending on the tail of an immutable list is also O(n) try to change the structure
    loop(initial, (initial :: Nil), Nil) reverse
  }


}
