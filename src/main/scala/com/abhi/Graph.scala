package com.abhi

trait Graph[V] {
    def verticies : List[V]
    def edges : List[(V, V)]
    def addEdge(a: V, b: V) : Graph[V]
    def neighbours(v: V) : List[V]
}