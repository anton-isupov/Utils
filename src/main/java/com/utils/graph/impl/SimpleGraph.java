package com.utils.graph.impl;

import com.utils.graph.GraphI;
import com.utils.graph.edge.EdgeI;
import com.utils.graph.vertex.VertexI;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class SimpleGraph<V extends VertexI, E extends EdgeI<V>> implements GraphI<V, E>{
    private Set<E> edges;
    private Map<V, Set<E>> vertexesIncidentEdges; // vertex -> list of incident edges

    public SimpleGraph(Set<E> edges, Map<V, Set<E>> incidentEdges) {
        this.edges = edges == null ? new HashSet<>() : edges;
        this.vertexesIncidentEdges = incidentEdges == null ? new HashMap<>() : incidentEdges;
    }

    public SimpleGraph(Map<V, Set<E>> vertexesIncidentEdges) {
        this.vertexesIncidentEdges = vertexesIncidentEdges;
        this.edges = new HashSet<>();
        this.edges.addAll(vertexesIncidentEdges.values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toList()));
    }


    public static <V extends VertexI, E extends EdgeI<V>> SimpleGraph<V, E> create(List<E> edges) {
        return new SimpleGraph<V, E>(setGraphByEdges(edges));
    }

    public boolean isVertexInGraph(V v) {
        return vertexesIncidentEdges.containsKey(v);
    }

    public int getVertexesCount() {
        return vertexesIncidentEdges.size();
    }

    public int getEdgesCount() {
        return edges.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleGraph<V, E> simpleGraph = (SimpleGraph<V, E>) o;
        return Objects.equals(edges, simpleGraph.edges) &&
                Objects.equals(vertexesIncidentEdges, simpleGraph.vertexesIncidentEdges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edges, vertexesIncidentEdges);
    }

    private static <V extends VertexI, E extends EdgeI<V>> Map<V, Set<E>> setGraphByEdges(List<E> edges) {
        Map<V, Set<E>> res = new HashMap<>();
        for (E edge : edges) {
            Set<E> incidentEdges = res.get(edge.getLeftVertex()) == null ? new HashSet<>() : res.get(edge.getLeftVertex());
            incidentEdges.add(edge);
            res.put(edge.getLeftVertex(), incidentEdges);
            Set<E> incidentEdgesRight = res.get(edge.getRightVertex()) == null ? new HashSet<>() : res.get(edge.getRightVertex());
            incidentEdgesRight.add(edge);
            res.put(edge.getRightVertex(), incidentEdgesRight);
        }

        return res;
    }
}
