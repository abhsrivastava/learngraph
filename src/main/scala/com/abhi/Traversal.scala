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
}