package com.utils.graph.search;

import com.utils.graph.GraphI;
import com.utils.graph.edge.EdgeI;
import com.utils.graph.edge.impl.SimpleEdge;
import com.utils.graph.exceptions.VertexNotInGraphException;
import com.utils.graph.impl.SimpleGraph;
import com.utils.graph.search.GraphSearch;
import com.utils.graph.vertex.VertexI;
import com.utils.graph.vertex.impl.CoordinateVertex;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

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

        Map<VertexI, Integer> answer = new HashMap<VertexI, Integer>() {{
            put(vertexList.get(0), 0);
            put(vertexList.get(1), 1);
            put(vertexList.get(2), 3);
            put(vertexList.get(3), 11);
        }};

        GraphSearch<VertexI, EdgeI<VertexI>> graphSearch = new GraphSearch<>();
        Map<VertexI, Integer> bfs = graphSearch.bfs(testGraph, vertexList.get(0));
        System.out.println(bfs);

        assertEquals(answer, bfs);
    }


    @Test
    public void testDFS() throws VertexNotInGraphException {
        GraphI<VertexI, EdgeI<VertexI>> testGraph = SimpleGraph.create(simpleEdges);

        Set<VertexI> answer = new HashSet<VertexI>() {{
            add(vertexList.get(0));
            add(vertexList.get(1));
            add(vertexList.get(2));
            add(vertexList.get(3));
        }};

        GraphSearch<VertexI, EdgeI<VertexI>> graphSearch = new GraphSearch<>();
        Set<VertexI> dfs = graphSearch.dfs(testGraph, vertexList.get(0));
        System.out.println(dfs);

        assertEquals(answer, dfs);
    }

}
