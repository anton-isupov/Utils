package com.utils.graph.search;

import com.utils.graph.GraphI;
import com.utils.graph.edge.EdgeI;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.vertex.VertexI;

import java.util.*;

public class GraphSearch {

    public static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> bfs(GraphI<V, E> graph, V s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        graph.unExploreAllVertexes();
        return mainBFS(graph, s);
    }

    public static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> dfs(GraphI<V, E> graph, V s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        graph.unExploreAllVertexes();
        return mainDFS(graph, s);
    }

    public static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> deikstra(GraphI<V, E> graph, V s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        graph.unExploreAllVertexes();
        return mainDeikstra(graph, s);
    }

    private static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> mainDeikstra(GraphI<V, E> graph, V s) {
        graph.setExploredVertex(s, 0);
        graph.getAllVertexes().forEach(vertex -> graph.setExploredVertex(vertex, Integer.MAX_VALUE));

        return graph;
    }

    /*
    * V - class implements VertexI interface.
    * E - class implements EdgeI interface.
    * This algorithm sets each weight of way if vertex is reachable.
    * But this weight not optimal.
    */
    private static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> mainBFS(GraphI<V, E> graph, V s) {
        int len = 0;
        graph.setExploredVertex(s, len);
        Queue<V> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (E edge : graph.getVertexesIncidentEdges().get(v)) {
                V w = edge.adjacentVertex(v);
                if (graph.isExploredVertex(w) == -1) {
                    graph.setExploredVertex(w, graph.getAllExploredVertexes().get(v) + edge.getEdgeWeight());
                    queue.add(w);
                }
            }
        }
        return graph;
    }

    /*
     * V - class implements VertexI interface.
     * E - class implements EdgeI interface.
     * This algorithm check which vertex is reachable.
     * Weight not sets.
     */
    private static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> mainDFS(GraphI<V, E> graph, V s) {
        graph.setExploredVertex(s, 0);
        for (E edge : graph.getVertexesIncidentEdges().get(s)) {
            V v = edge.adjacentVertex(s);
            if (graph.isExploredVertex(v) == -1) mainDFS(graph, v);
        }
        return graph;
    }
}
