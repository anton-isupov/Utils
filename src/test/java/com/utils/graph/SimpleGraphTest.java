package com.utils.graph;

import com.utils.graph.edge.EdgeI;
import com.utils.graph.edge.impl.SimpleEdge;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.impl.SimpleGraph;
import com.utils.graph.search.GraphSearch;
import com.utils.graph.vertex.VertexI;
import com.utils.graph.vertex.impl.CoordinateVertex;
import com.utils.graph.vertex.impl.SimpleVertex;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleGraphTest {

/*
    List<SimpleVertex> simpleVertices = Arrays.asList(
            new SimpleVertex("1"), new SimpleVertex("2"),
            new SimpleVertex("3"), new SimpleVertex("4"),
            new SimpleVertex("5"), new SimpleVertex("6"));
*/

    List<VertexI> vertexList = Arrays.asList(
            new CoordinateVertex(1,0), new CoordinateVertex(2,0),
            new CoordinateVertex(3,0), new CoordinateVertex(4,0),
            new CoordinateVertex(5,0), new CoordinateVertex(6,0)
    );

    List<EdgeI<VertexI>> simpleEdges = Arrays.asList(
            new SimpleEdge<>("1-2", vertexList.get(0), vertexList.get(1), 1),
            new SimpleEdge<>("2-3", vertexList.get(1), vertexList.get(2), 2),
            new SimpleEdge<>("2-4", vertexList.get(1), vertexList.get(3), 10),
            new SimpleEdge<>("5-6", vertexList.get(4), vertexList.get(5), 11));

    @Test
    public void testBFS () throws VertexNotInGraphException {
        GraphI<VertexI, EdgeI<VertexI>> testGraph = SimpleGraph.create(simpleEdges);

        Set<VertexI> answer = new HashSet<>(Arrays.asList(vertexList.get(0), vertexList.get(1), vertexList.get(2), vertexList.get(3)));
        GraphI<VertexI, EdgeI<VertexI>> searchedGraph = GraphSearch.bfs(testGraph, vertexList.get(0));
        System.out.println(searchedGraph.getAllExploredVertexes());

        assertEquals(answer, searchedGraph.getAllExploredVertexes().keySet());
    }


    @Test
    public void testDFS() throws VertexNotInGraphException {
        GraphI<VertexI, EdgeI<VertexI>> testGraph = SimpleGraph.create(simpleEdges);

        Set<VertexI> answer = new HashSet<>(Arrays.asList(vertexList.get(0), vertexList.get(1), vertexList.get(2), vertexList.get(3)));
        assertEquals(answer, GraphSearch.dfs(testGraph, vertexList.get(0)).getAllExploredVertexes());
    }

}
