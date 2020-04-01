package com.utils.graph.search;

import com.utils.graph.GraphI;
import com.utils.graph.edge.EdgeI;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.vertex.VertexI;

import java.util.*;

public class GraphSearch {

    public static <V extends VertexI, E extends EdgeI<V>> Set<V> bfs(GraphI<V, E> graph, V s) throws VertexNotInGraphException {

        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        Set<V> exploredVertexes = new HashSet<V>() {{ add(s); }};

        Queue<V> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (E edge : graph.getIncidentEdges().get(v)) {
                V w = edge.adjacentVertex(v);
                if (!exploredVertexes.contains(w)) {
                    exploredVertexes.add(w);
                    queue.add(w);
                }
            }
        }

        return exploredVertexes;
    }

}
