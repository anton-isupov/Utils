package com.utils.graph;

import com.utils.graph.edge.impl.SimpleEdge;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.impl.SimpleGraph;
import com.utils.graph.search.GraphSearch;
import com.utils.graph.vertex.impl.SimpleVertex;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleGraphTest {


    @Test
    public void testBFS () throws VertexNotInGraphException {
        List<SimpleVertex> simpleVertices = Arrays.asList(
                new SimpleVertex("1"), new SimpleVertex("2"),
                new SimpleVertex("3"), new SimpleVertex("4"),
                new SimpleVertex("5"), new SimpleVertex("6"));

        List<SimpleEdge<SimpleVertex>> simpleEdges = Arrays.asList(
                new SimpleEdge<>("1-2", simpleVertices.get(0), simpleVertices.get(1)),
                new SimpleEdge<>("2-3", simpleVertices.get(1), simpleVertices.get(2)),
                new SimpleEdge<>("2-4", simpleVertices.get(1), simpleVertices.get(3)),
                new SimpleEdge<>("5-6", simpleVertices.get(4), simpleVertices.get(5)));

        GraphI<SimpleVertex, SimpleEdge<SimpleVertex>> testGraph = SimpleGraph.create(simpleEdges);

        Set<SimpleVertex> answer = new HashSet<>(Arrays.asList(simpleVertices.get(0), simpleVertices.get(1), simpleVertices.get(2), simpleVertices.get(3)));
        assertEquals(answer, GraphSearch.bfs(testGraph, simpleVertices.get(0)));
    }

    @Test
    public void test() {
        System.out.println(2 + 1);
    }

}
