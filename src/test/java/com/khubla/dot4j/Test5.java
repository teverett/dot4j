package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test5 {
	@Test
	public void testRead() {
		try {
			final InputStream inputStream = Test5.class.getResourceAsStream("/example5.txt");
			assertNotNull(inputStream);
			final Graph graph = DOTMarshaller.importGraph(inputStream);
			/*
			 * graph
			 */
			assertNotNull(graph);
			assertTrue(graph.getId().compareTo("g") == 0);
			/*
			 * graph attribs
			 */
			assertTrue(graph.getGraphAttributes().getAttributes().size() == 0);
			assertTrue(graph.getNodeAttributes().getAttributes().size() == 1);
			/*
			 * edges
			 */
			assertTrue(graph.getEdges().size() == 7);
			/*
			 * nodes
			 */
			assertTrue(graph.getNodes().size() == 0);
			/*
			 * subgraphs
			 */
			assertTrue(graph.getSubGraphs().size() == 2);
			assertTrue(graph.getSubGraphs().get(0).getNodes().size() == 3);
			assertTrue(graph.getSubGraphs().get(0).getAnonymousAttributes().size() == 1);
			// assertNotNull(graph.getSubGraphs().get(0).getAttributes().getAttribute("rank"));
			// assertTrue(graph.getSubGraphs().get(0).getAttributes().getAttribute("rank").getRhs().get(0).compareTo("same")
			// == 0);
			assertTrue(graph.getSubGraphs().get(1).getNodes().size() == 3);
			assertTrue(graph.getSubGraphs().get(1).getAnonymousAttributes().size() == 1);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWrite() {
		try {
			final InputStream inputStream = Test1.class.getResourceAsStream("/example5.txt");
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
