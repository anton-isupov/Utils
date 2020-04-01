package com.utils.graph;

import com.utils.graph.edge.Edge;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.impl.Graph;
import com.utils.graph.search.GraphSearch;
import com.utils.graph.vertex.Vertex;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {


    @Test
    public void testBFS () throws VertexNotInGraphException {
        List<Vertex> vertexes = Arrays.asList(
                new Vertex("1"), new Vertex("2"),
                new Vertex("3"), new Vertex("4"),
                new Vertex("5"), new Vertex("6"));

        List<Edge> edges = Arrays.asList(
                new Edge("1-2", vertexes.get(0), vertexes.get(1)),
                new Edge("2-3", vertexes.get(1), vertexes.get(2)),
                new Edge("2-4", vertexes.get(1), vertexes.get(3)),
                new Edge("5-6", vertexes.get(4), vertexes.get(5)));

        Graph testGraph = Graph.create(edges);
        Set<Vertex> answer = new HashSet<>(Arrays.asList(vertexes.get(0), vertexes.get(1), vertexes.get(2), vertexes.get(3)));
        assertEquals(answer, GraphSearch.bfs(testGraph, vertexes.get(0)));
    }

    @Test
    public void test() {
        System.out.println(2 + 1);
    }

}
