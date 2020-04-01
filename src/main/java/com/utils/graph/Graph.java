package com.utils.graph;

import com.utils.graph.edge.Edge;
import com.utils.graph.vertex.Vertex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Graph {
    private List<Edge> edges;
    private Map<Vertex, List<Edge>> incidentEdges;

    public Graph(List<Edge> edges, Map<Vertex, List<Edge>> vertexes) {
        this.edges = edges == null ? new ArrayList<>() : edges;
        this.incidentEdges = vertexes == null ? new HashMap<>() : vertexes;
    }

    public int getVertexesCount() {
        return incidentEdges.size();
    }

    public int getEdgesCount() {
        return edges.size();
    }

    public boolean isVertexInGraph(Vertex v) {
        return incidentEdges.containsKey(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(edges, graph.edges) &&
                Objects.equals(incidentEdges, graph.incidentEdges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edges, incidentEdges);
    }
}
