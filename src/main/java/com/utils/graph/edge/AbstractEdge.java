package com.utils.graph.edge;

import com.utils.graph.vertex.VertexI;

public abstract class AbstractEdge<V extends VertexI> implements EdgeI<V> {

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
