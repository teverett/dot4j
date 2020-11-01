package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test1 {
	@Test
	public void test11() {
		try {
			InputStream inputStream = Test1.class.getResourceAsStream("/example1.txt");
			assertNotNull(inputStream);
			Graph graph = DOTMarshaller.importGraph(inputStream);
			assertNotNull(graph);
			assertTrue(graph.getId().compareTo("graphname") == 0);
			assertTrue(graph.getEdges().size() == 2);
			Edge edge0 = graph.getEdges().get(0);
			assertTrue(edge0.getRhsGraphs().size() == 0);
			assertTrue(edge0.getRhsNodeIds().size() == 2);
			Edge edge1 = graph.getEdges().get(1);
			assertTrue(edge1.getRhsGraphs().size() == 0);
			assertTrue(edge1.getRhsNodeIds().size() == 1);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
