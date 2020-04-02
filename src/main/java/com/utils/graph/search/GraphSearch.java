package com.utils.graph.search;

import com.utils.graph.GraphI;
import com.utils.graph.edge.EdgeI;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.vertex.VertexI;

import java.util.*;

public class GraphSearch <V extends VertexI, E extends EdgeI<V>>{

    private  Map<V, Integer> exploredVertexes;

    public GraphSearch() {
        this.exploredVertexes = new HashMap<>();
    }

    /*
     * V - class implements VertexI interface.
     * E - class implements EdgeI interface.
     * This algorithm sets each weight of way if vertex is reachable.
     * But this weight not optimal.
     */
    public Map<V, Integer> bfs(GraphI<V, E> graph, V s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        exploredVertexes.clear();
        return mainBFS(graph, s);
    }

    /*
     * V - class implements VertexI interface.
     * E - class implements EdgeI interface.
     * This algorithm check which vertex is reachable.
     * Weight not sets.
     */
    public Set<V> dfs(GraphI<V, E> graph, V s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        exploredVertexes.clear();
        return mainDFS(graph, s);
    }

    public GraphI<V, E> deikstra(GraphI<V, E> graph, V s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        exploredVertexes.clear();
        return mainDeikstra(graph, s);
    }

    private static <V extends VertexI, E extends EdgeI<V>> GraphI<V, E> mainDeikstra(GraphI<V, E> graph, V s) {
        return graph;
    }

    private Map<V, Integer> mainBFS(GraphI<V, E> graph, V s) {
        int len = 0;
        exploredVertexes.put(s, len);
        Queue<V> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (E edge : graph.getVertexesIncidentEdges().get(v)) {
                V w = edge.adjacentVertex(v);
                if (exploredVertexes.getOrDefault(w, -1) == -1) {
                    exploredVertexes.put(w, exploredVertexes.get(v) + edge.getEdgeWeight());
                    queue.add(w);
                }
            }
        }
        return exploredVertexes;
    }

    private Set<V> mainDFS(GraphI<V, E> graph, V s) {
        exploredVertexes.put(s, 0);
        for (E edge : graph.getVertexesIncidentEdges().get(s)) {
            V v = edge.adjacentVertex(s);
            if (exploredVertexes.getOrDefault(v, -1) == -1) mainDFS(graph, v);
        }
        return exploredVertexes.keySet();
    }

}
