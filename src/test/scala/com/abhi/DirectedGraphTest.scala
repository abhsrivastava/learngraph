package com.abhi

import org.scalatest._

class DirectedGraphTest extends FunSpec {
    describe("Directed Graph Create") {
        it("should be able to create a directed graph") {
            val d = new DirectedGraph[String](Map.empty[String, List[String]])
            assert(d.verticies == List.empty[String])
            assert(d.edges == List.empty[(String, String)])
        }
        it("should be able to add a node to a directed graph") {
            val d = new DirectedGraph[String](Map.empty[String, List[String]])
            val d1 = d.addEdge("London", "Lisbon")
            assert(d1.verticies == List("London"))
            assert(d1.edges == List(("London", "Lisbon")))
        }
        it("should be able to get the neighbours of a node") {
            val d = new DirectedGraph[String](Map.empty[String, List[String]])
            val d1 = d.addEdge("London", "Lisbon").addEdge("London", "Madrid")
            assert(d1.neighbours("London") == List("Madrid", "Lisbon"))
        }
    }
    describe("Directed Graph Traversal") {
        it("should be able to return all nodes of the graph") {
            val d = new DirectedGraph[String](Map.empty[String, List[String]])
            val d1 = d.addEdge("London", "Lisbon").addEdge("London", "Madrid")
            val nodes = Traversal.traverseDFS("London", d1, (s: String) => println(s))
            assert(nodes.contains("London"))
            assert(nodes.contains("Lisbon"))
            assert(nodes.contains("Madrid"))
            assert(nodes.size == 3)
        }
    }
}