package com.utils.graph;


import com.utils.graph.edge.EdgeI;
import com.utils.graph.vertex.VertexI;

import java.util.Map;
import java.util.Set;

public interface GraphI<V extends VertexI, E extends EdgeI<V>> {

    boolean isVertexInGraph(V v);

    Map<V, Set<E>> getIncidentEdges();

    Set<E> getEdges();
}
