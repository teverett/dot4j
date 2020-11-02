package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test6 {
	@Test
	public void testRead() {
		try {
			final InputStream inputStream = Test6.class.getResourceAsStream("/example6.txt");
			assertNotNull(inputStream);
			final Graph graph = DOTMarshaller.importGraph(inputStream);
			/*
			 * graph
			 */
			assertNotNull(graph);
			assertTrue(graph.getId().compareTo("G") == 0);
			/*
			 * graph attribs
			 */
			assertTrue(graph.getGraphAttributes().getAttributes().size() == 3);
			assertTrue(graph.getNodeAttributes().getAttributes().size() == 3);
			/*
			 * edges
			 */
			assertTrue(graph.getEdges().size() == 4);
			/*
			 * nodes
			 */
			assertTrue(graph.getNodes().size() == 0);
			/*
			 * subgraphs
			 */
			assertTrue(graph.getSubGraphs().size() == 3);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWrite() {
		try {
			final InputStream inputStream = Test1.class.getResourceAsStream("/example6.txt");
			assertNotNull(inputStream);
			final Graph graph = DOTMarshaller.importGraph(inputStream);
			/*
			 * write
			 */
			final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			DOTMarshaller.exportGraph(graph, byteArrayOutputStream);
			System.out.println(byteArrayOutputStream.toString());
			/*
			 * reparse
			 */
			final Graph graph2 = DOTMarshaller.importGraph(new ByteArrayInputStream(byteArrayOutputStream.toString().getBytes()));
			assertNotNull(graph2);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
