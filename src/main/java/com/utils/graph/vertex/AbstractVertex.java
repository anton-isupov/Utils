package com.utils.graph.vertex;

public abstract class AbstractVertex implements VertexI {


    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
