package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class SubgraphListener extends AbstractListener {
	public Graph graph;

	@Override
	public void enterSubgraph(DOTParser.SubgraphContext ctx) {
		graph = new Graph();
		graph.setGraphType(GraphType.subgraph);
		/*
		 * statement list
		 */
		if (null != ctx.stmt_list()) {
			StatementListListener statementListListener = new StatementListListener(graph);
			statementListListener.enterStmt_list(ctx.stmt_list());
		}
	}
}
