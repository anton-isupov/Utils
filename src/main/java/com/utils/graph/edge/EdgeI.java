package com.utils.graph.edge;

public interface EdgeI<V> {

    V getLeftVertex();

    V getRightVertex();

    V adjacentVertex(V v);

    int getEdgeWeight();
    void setEdgeWeight(int weight);
}
