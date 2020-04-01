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

    private static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> mainBFS(GraphI<V, E> graph, V s) {
        graph.setExploredVertex(s);
        Queue<V> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (E edge : graph.getVertexesIncidentEdges().get(v)) {
                V w = edge.adjacentVertex(v);
                if (!graph.isExploredVertex(w)) {
                    graph.setExploredVertex(w);
                    queue.add(w);
                }
            }
        }
        return graph;
    }

    private static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> mainDFS(GraphI<V, E> graph, V s) {
        graph.setExploredVertex(s);
        for (E edge : graph.getVertexesIncidentEdges().get(s)) {
            V v = edge.adjacentVertex(s);
            if (!graph.isExploredVertex(v)) mainDFS(graph, v);
        }
        return graph;
    }
}
