package com.utils.graph;

import com.utils.graph.edge.Edge;
import com.utils.graph.vertex.Vertex;

import java.util.Map;
import java.util.Set;

public interface GraphI {

    boolean isVertexInGraph(Vertex v);

    Map<Vertex, Set<Edge>> getIncidentEdges();

    Set<Edge> getEdges();
}
