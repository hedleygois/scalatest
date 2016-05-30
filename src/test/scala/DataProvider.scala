import structure.{Graph, Node}

object DataProvider {

  def smallGraphWithBridges: Graph = {
    val first = Node("First", 1.0)
    val second = Node("Second", 2.0)
    val third = Node("Third", 1.0)
    val forth = Node("Forth", 0.5)
    val fifth = Node("Fifth", 0.3)
    val graph = Graph(Map(
      first -> (second :: third :: Nil),
      second -> (first :: third :: Nil),
      third -> (first :: second :: forth :: Nil),
      forth -> (third :: fifth :: Nil),
      fifth -> (forth :: Nil)
    ))
    graph
  }

  def hugeGraph: Graph = {
    var map = Map[Node, List[Node]]()
    for(i <- 0 to 50000) {
      map += (Node(i.toString, i) -> List[Node]())
    }
    Graph(map)
  }

  def smallGraphWithoutBridges = {
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
    graph
  }

}
