package com.utils.graph;


import com.utils.graph.edge.EdgeI;
import com.utils.graph.vertex.VertexI;

import java.util.Map;
import java.util.Set;

public interface GraphI<V extends VertexI, E extends EdgeI<V>> {

    boolean isVertexInGraph(V v);

    Map<V, Set<E>> getVertexesIncidentEdges();

    Set<E> getEdges();

    void setExploredVertex(V v);

    void setUnExploredVertex(V v);

    boolean isExploredVertex(V v);

    void unExploreAllVertexes();

    Set<V> getAllExploredVertexes();
}
