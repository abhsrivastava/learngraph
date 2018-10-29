package com.abhi

import org.scalatest._

class TopologicalSortTest extends FunSpec {
    describe("Should be able to perform topological sort on a graph") {
        it("use DFS sort") {
            val g = buildGraph()
            val result = TopologicalSort.topologicalDFSSort(g)
            println(result)
            assert(result.reverse.head == "Game")
        }
    }

    def buildGraph() : Graph[String] = {
        val g = new DirectedGraph[String](Map.empty[String, List[String]])
            g.addEdge("Logging", "Game")
            .addEdge("Logging", "Networking")
            .addEdge("Networking", "Game")
            .addEdge("Commons", "Physics")
            .addEdge("Commons", "Math")
            .addEdge("Math", "Physics")
            .addEdge("Math", "Graphics")
            .addEdge("Math", "AI Engine")
            .addEdge("Physics", "Game")
            .addEdge("Graphics", "Game")
            .addEdge("AI Engine", "Game")
    }
}