package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test2 {
	@Test
	public void test2() {
		try {
			final InputStream inputStream = Test2.class.getResourceAsStream("/example2.txt");
			assertNotNull(inputStream);
			final Graph graph = DOTMarshaller.importGraph(inputStream);
			/*
			 * graph
			 */
			assertNotNull(graph);
			assertTrue(graph.getId().compareTo("graphname") == 0);
			/*
			 * graph attribs
			 */
			assertTrue(graph.getGraphAttributes().getAttributes().size() == 0);
			/*
			 * edges
			 */
			assertTrue(graph.getEdges().size() == 3);
			/*
			 * nodes
			 */
			assertTrue(graph.getNodes().size() == 0);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
