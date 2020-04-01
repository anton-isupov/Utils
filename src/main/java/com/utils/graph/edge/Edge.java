package com.utils.graph.edge;

import com.utils.graph.vertex.Vertex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Edge {
    private String name;
    private Vertex leftVertex;
    private Vertex rightVertex;

    public Vertex adjacentVertex(Vertex v) {
        return v.equals(leftVertex) ? rightVertex : leftVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(name, edge.name) &&
                Objects.equals(leftVertex, edge.leftVertex) &&
                Objects.equals(rightVertex, edge.rightVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, leftVertex, rightVertex);
    }
}
