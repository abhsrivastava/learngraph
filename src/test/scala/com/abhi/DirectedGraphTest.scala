package com.abhi

import org.scalatest._

class DirectedGraphTest extends FunSpec {
    describe("Directed Graph Tests") {
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
}