package com.abhi

case class DfsStep[V](visited: Set[V] = Set.empty[V], result: List[V] = List.empty[V])

object TopologicalSort {
    def topologicalDFSSort[V](graph: Graph[V]) : List[V] = {
        def innerTopologicalDFSSort(start: V, dfsStep: DfsStep[V]) : DfsStep[V] = {
            if (dfsStep.visited.contains(start)) {
                dfsStep
            } else {
                val preDfsStep = dfsStep.copy(visited = dfsStep.visited + start)
                val postDfsStep = graph.neighbours(start).foldLeft(preDfsStep){case (accum, node) => 
                    innerTopologicalDFSSort(node, accum)
                }
                postDfsStep.copy(result = start +: postDfsStep.result)
            }
        }
        val resultDfsStep = graph.verticies.foldLeft(DfsStep[V]()){case (accum, node) => innerTopologicalDFSSort(node, accum)}
        resultDfsStep.result
    }
}