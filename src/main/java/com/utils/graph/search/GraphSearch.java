package com.utils.graph.search;

import com.utils.graph.GraphI;
import com.utils.graph.impl.Graph;
import com.utils.graph.edge.Edge;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.vertex.Vertex;

import java.util.*;

public class GraphSearch {

    public static Set<Vertex> bfs(GraphI graph, Vertex s) throws VertexNotInGraphException {
        if (!graph.isVertexInGraph(s)) throw new VertexNotInGraphException("Vertex " + s + " not in graph " + graph);
        Set<Vertex> exploredVertexes = new HashSet<Vertex>() {{ add(s); }};

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge edge : graph.getIncidentEdges().get(v)) {
                Vertex w = edge.adjacentVertex(v);
                if (!exploredVertexes.contains(w)) {
                    exploredVertexes.add(w);
                    queue.add(w);
                }
            }
        }

        return exploredVertexes;
    }

}
