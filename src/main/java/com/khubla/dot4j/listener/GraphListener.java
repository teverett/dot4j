package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class GraphListener extends AbstractListener {
	public Graph graph = null;

	@Override
	public void enterGraph(DOTParser.GraphContext ctx) {
		/*
		 * strict
		 */
		boolean strict;
		if (ctx.STRICT() != null) {
			strict = true;
		} else {
			strict = false;
		}
		/*
		 * type
		 */
		GraphType graphType;
		if (ctx.GRAPH() != null) {
			graphType = GraphType.graph;
		} else {
			graphType = GraphType.digraph;
		}
		/*
		 * id
		 */
		String id = null;
		if (null != ctx.id()) {
			final IdListener idListener = new IdListener();
			idListener.enterId(ctx.id());
			id = idListener.id;
		}
		graph = new Graph(strict, graphType, id);
		/*
		 * statement list
		 */
		if (null != ctx.stmt_list()) {
			final StatementListListener statementListListener = new StatementListListener(graph);
			statementListListener.enterStmt_list(ctx.stmt_list());
		}
	}
}
