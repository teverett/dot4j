package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;
import com.khubla.dot4j.domain.*;

public class StatementListListener extends AbstractListener {
	private final Graph graph;

	public StatementListListener(Graph graph) {
		super();
		this.graph = graph;
	}

	@Override
	public void enterStmt_list(DOTParser.Stmt_listContext ctx) {
		if (null != ctx.stmt()) {
			for (StmtContext stmtContext : ctx.stmt()) {
				StatementListener statementListener = new StatementListener(graph);
				statementListener.enterStmt(stmtContext);
			}
		}
	}
}
