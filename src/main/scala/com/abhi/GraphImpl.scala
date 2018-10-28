package com.abhi

class DirectedGraph[V](adjList: Map[V, List[V]]) extends Graph[V] {
    override def verticies = adjList.keys.toList
    override def edges = for {
        (node1, list) <- adjList.toList
        node2 <- list
    } yield (node1, node2)
    override def addEdge(a: V, b: V) : DirectedGraph[V] = {
        new DirectedGraph[V](adjList + (a -> (b :: neighbours(a))))
    }
    override def neighbours(a: V) : List[V] = adjList.getOrElse(a, Nil) 
}

class UndirectedGraph[V](adjList: Map[V, List[V]]) extends DirectedGraph[V](adjList) {
    override def addEdge(a: V, b: V) : UndirectedGraph[V] = {
        val aNeighbours = b :: neighbours(a)
        val bNeighbours = a :: neighbours(b)
        new UndirectedGraph[V](adjList + (a -> aNeighbours, b -> bNeighbours))
    }
}

case class WeightedEdge[V](v: V, weight: Int)
class WeightedGraph[V](adjList: Map[V, List[WeightedEdge[V]]]) extends Graph[V] {
    override def verticies = adjList.keys.toList
    override def edges = for {
        (a, b) <- adjList.toList
        c <- b
    } yield (a, c.v)
    def addEdge(a: V, b: WeightedEdge[V]) : WeightedGraph[V] = {
        new WeightedGraph[V](adjList + (a -> (b :: adjList.getOrElse(a, Nil))))
    }
    override def addEdge(a: V, b: V) : WeightedGraph[V] = addEdge(a, new WeightedEdge(b, 0))
    override def neighbours(a: V) : List[V] = {
        adjList.getOrElse(a, Nil).map(_.v)
    }
    def neighboursWithWeights(a: V) : List[(V, Int)] = {
        adjList.getOrElse(a, Nil).map(we => (we.v, we.weight))
    }
}