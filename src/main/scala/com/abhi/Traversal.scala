package com.abhi

object Traversal {
    def traverseDFS[V](start: V, graph: Graph[V], f: V => Unit, visited: List[V] = List.empty[V]) : List[V] = {
        if (visited.contains(start)) visited
        else {
            f(start)
            graph.neighbours(start).foldLeft(start :: visited){case (accum, n) => 
                traverseDFS(n, graph, f, accum)
            }
        }
    }

    def traverseDFSIterative[V](start: V, graph: Graph[V], f: V => Unit) : Unit = {
        Stream.iterate((List(start), Set[V](start))){ case (stack, visited) => 
            val current = stack.head
            val newStack = graph.neighbours(current).filterNot(visited.contains) ++ stack.tail
            val newVisited = graph.neighbours(current).toSet ++ visited
            (newStack, newVisited)
        }.takeWhile(_._1.nonEmpty).foreach(t => f(t._1.head))
    }
}