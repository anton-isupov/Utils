package com.utils.graph;


import com.utils.graph.edge.EdgeI;
import com.utils.graph.vertex.VertexI;

import java.util.Map;
import java.util.Set;

public interface GraphI<V extends VertexI, E extends EdgeI<V>> {

    boolean isVertexInGraph(V v);

    Set<V> getAllVertexes();

    Map<V, Set<E>> getVertexesIncidentEdges();

    Set<E> getEdges();

    void setExploredVertex(V v, int len); // len - length to this vertex

    void setUnExploredVertex(V v);

    int isExploredVertex(V v);

    void unExploreAllVertexes();

    Map<V, Integer> getAllExploredVertexes();

}
