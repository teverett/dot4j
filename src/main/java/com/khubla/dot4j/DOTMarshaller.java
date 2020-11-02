package com.khubla.dot4j;

import java.io.*;

import org.antlr.v4.runtime.*;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;
import com.khubla.dot4j.listener.*;

public class DOTMarshaller {
	public static void exportGraph(Graph graph, OutputStream outputStream) throws IOException {
		if ((null != graph) && (null != outputStream)) {
			final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
			final RenderContext renderContext = new RenderContext();
			graph.render(outputStreamWriter, renderContext);
			outputStreamWriter.flush();
		}
	}

	public static Graph importGraph(InputStream inputStream) throws IOException {
		if (null != inputStream) {
			/*
			 * make Lexer
			 */
			final Lexer lexer = new DOTLexer(CharStreams.fromStream(inputStream));
			/*
			 * get a TokenStream on the Lexer
			 */
			final TokenStream tokenStream = new CommonTokenStream(lexer);
			/*
			 * make a Parser on the token stream
			 */
			final DOTParser dotParser = new DOTParser(tokenStream);
			/*
			 * listener
			 */
			final GraphListener graphListener = new GraphListener();
			/*
			 * parse
			 */
			graphListener.enterGraph(dotParser.graph());
			/*
			 * done
			 */
			return graphListener.graph;
		} else {
			return null;
		}
	}
}
