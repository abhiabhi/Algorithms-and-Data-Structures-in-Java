//package com.graph;
//
//public class DijkstraShortestPath {
//
//
//    public static void main(String args[]){
//        Graph<Integer> graph = new Graph<>(false);
//        /*graph.addEdge(0, 1, 4);
//        graph.addEdge(1, 2, 8);
//        graph.addEdge(2, 3, 7);
//        graph.addEdge(3, 4, 9);
//        graph.addEdge(4, 5, 10);
//        graph.addEdge(2, 5, 4);
//        graph.addEdge(1, 7, 11);
//        graph.addEdge(0, 7, 8);
//        graph.addEdge(2, 8, 2);
//        graph.addEdge(3, 5, 14);
//        graph.addEdge(5, 6, 2);
//        graph.addEdge(6, 8, 6);
//        graph.addEdge(6, 7, 1);
//        graph.addEdge(7, 8, 7);*/
//
//        graph.addEdge(1, 2, 5);
//        graph.addEdge(2, 3, 2);
//        graph.addEdge(1, 4, 9);
//        graph.addEdge(1, 5, 3);
//        graph.addEdge(5, 6, 2);
//        graph.addEdge(6, 4, 2);
//        graph.addEdge(3, 4, 3);
//
//        DijkstraShortestPath dsp = new DijkstraShortestPath();
//        Vertex<Integer> sourceVertex = graph.getVertex(1);
//        Map<Vertex<Integer>,Integer> distance = dsp.shortestPath(graph, sourceVertex);
//        System.out.print(distance);
//    }
//}
