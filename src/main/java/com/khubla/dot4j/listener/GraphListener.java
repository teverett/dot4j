package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class GraphListener extends AbstractListener {
	public Graph graph = null;

	@Override
	public void enterGraph(DOTParser.GraphContext ctx) {
		graph = new Graph();
		/*
		 * strict
		 */
		if (ctx.STRICT() != null) {
			graph.setStrict(true);
		} else {
			graph.setStrict(false);
		}
		/*
		 * type
		 */
		if (ctx.GRAPH() != null) {
			graph.setGraphType(GraphType.graph);
		} else {
			graph.setGraphType(GraphType.digraph);
		}
		/*
		 * id
		 */
		if (null != ctx.id()) {
			IdListener idListener = new IdListener();
			idListener.enterId(ctx.id());
			graph.setId(idListener.id);
		}
		/*
		 * statement list
		 */
		if (null != ctx.stmt_list()) {
			StatementListListener statementListListener = new StatementListListener(graph);
			statementListListener.enterStmt_list(ctx.stmt_list());
		}
	}
}
