package com.utils.graph.impl;

import com.utils.graph.GraphI;
import com.utils.graph.edge.Edge;
import com.utils.graph.vertex.Vertex;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class Graph implements GraphI {
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> incidentEdges; // vertex -> list of incident edges

    public Graph(Set<Edge> edges, Map<Vertex, Set<Edge>> incidentEdges) {
        this.edges = edges == null ? new HashSet<>() : edges;
        this.incidentEdges = incidentEdges == null ? new HashMap<>() : incidentEdges;
    }

    public Graph(Map<Vertex, Set<Edge>> incidentEdges) {
        this.incidentEdges = incidentEdges;
        this.edges = new HashSet<>();
        this.edges.addAll(incidentEdges.values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toList()));
    }

    public static Graph create(List<Edge> edges) {
        return new Graph(setGraphByEdges(edges));
    }

    public int getVertexesCount() {
        return incidentEdges.size();
    }

    public int getEdgesCount() {
        return edges.size();
    }

    @Override
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

    private static Map<Vertex, Set<Edge>> setGraphByEdges(List<Edge> edges) {
        Map<Vertex, Set<Edge>> res = new HashMap<>();
        for (Edge edge : edges) {
            Set<Edge> incidentEdges = res.get(edge.getLeftVertex()) == null ? new HashSet<>() : res.get(edge.getLeftVertex());
            incidentEdges.add(edge);
            res.put(edge.getLeftVertex(), incidentEdges);
            Set<Edge> incidentEdgesRight = res.get(edge.getRightVertex()) == null ? new HashSet<>() : res.get(edge.getRightVertex());
            incidentEdgesRight.add(edge);
            res.put(edge.getRightVertex(), incidentEdgesRight);
        }

        return res;
    }
}
