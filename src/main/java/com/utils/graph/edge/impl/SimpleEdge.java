package com.utils.graph.edge.impl;

import com.utils.graph.edge.AbstractEdge;
import com.utils.graph.edge.EdgeI;
import com.utils.graph.vertex.VertexI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SimpleEdge<V extends VertexI> extends AbstractEdge<V> {
    private String name;
    private V leftVertex;
    private V rightVertex;
    private int weight;

    public V adjacentVertex(V v) {
        return v.equals(leftVertex) ? rightVertex : leftVertex;
    }

    @Override
    public int getEdgeWeight() {
        return weight;
    }

    @Override
    public void setEdgeWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleEdge<V> simpleEdge = (SimpleEdge<V>) o;
        return Objects.equals(name, simpleEdge.name) &&
                Objects.equals(leftVertex, simpleEdge.leftVertex) &&
                Objects.equals(rightVertex, simpleEdge.rightVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, leftVertex, rightVertex);
    }
}
