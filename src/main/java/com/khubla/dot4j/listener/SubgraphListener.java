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
		 * id
		 */
		if (null != ctx.id()) {
			final IdListener idListener = new IdListener();
			idListener.enterId(ctx.id());
			graph.setId(idListener.id);
		}
		/*
		 * statement list
		 */
		if (null != ctx.stmt_list()) {
			final StatementListListener statementListListener = new StatementListListener(graph);
			statementListListener.enterStmt_list(ctx.stmt_list());
		}
	}
}
