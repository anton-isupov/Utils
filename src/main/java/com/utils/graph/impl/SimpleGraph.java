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
public class SimpleGraph<V extends VertexI, E extends EdgeI<V>> implements GraphI<V, E> {
    private Set<E> edges;
    private Map<V, Set<E>> vertexesIncidentEdges; // vertex -> list of incident edges
    private Map<V, Integer> exploredVertexes; // Integer -> weight to go this vertex when all edges weight is one.

    public SimpleGraph(Set<E> edges, Map<V, Set<E>> incidentEdges) {
        this.exploredVertexes = new HashMap<>();
        this.edges = edges == null ? new HashSet<>() : edges;
        this.vertexesIncidentEdges = incidentEdges == null ? new HashMap<>() : incidentEdges;
    }

    public SimpleGraph(Map<V, Set<E>> vertexesIncidentEdges) {
        this.exploredVertexes = new HashMap<>();
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

    @Override
    public Set<V> getAllVertexes() {
        return vertexesIncidentEdges.keySet();
    }

    @Override
    public void setExploredVertex(V v, int len) {
        exploredVertexes.put(v, len);
    }

    @Override
    public void setUnExploredVertex(V v) {
        exploredVertexes.remove(v);
    }

    @Override
    public int isExploredVertex(V v) {
        return exploredVertexes.getOrDefault(v, -1);
    }

    @Override
    public void unExploreAllVertexes() {
        exploredVertexes.clear();
    }

    @Override
    public Map<V, Integer> getAllExploredVertexes() {
        return exploredVertexes;
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
        SimpleGraph<?, ?> that = (SimpleGraph<?, ?>) o;
        return Objects.equals(edges, that.edges) &&
                Objects.equals(vertexesIncidentEdges, that.vertexesIncidentEdges);
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
