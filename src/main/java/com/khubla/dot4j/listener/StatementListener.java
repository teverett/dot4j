package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class StatementListener extends AbstractListener {
	private final Graph graph;

	public StatementListener(Graph graph) {
		super();
		this.graph = graph;
	}

	@Override
	public void enterStmt(DOTParser.StmtContext ctx) {
		if (null != ctx.node_stmt()) {
			/*
			 * node
			 */
			final NodeStatementListener nodeStatementListener = new NodeStatementListener();
			nodeStatementListener.enterNode_stmt(ctx.node_stmt());
			graph.addNode(nodeStatementListener.node);
		} else if (null != ctx.edge_stmt()) {
			/*
			 * edge
			 */
			final EdgeStatementListener edgeStatementListener = new EdgeStatementListener();
			edgeStatementListener.enterEdge_stmt(ctx.edge_stmt());
			graph.addEdges(edgeStatementListener.edges);
		} else if (null != ctx.attr_stmt()) {
			/*
			 * attribute
			 */
			final AttributeStatementListener attributeStatementListener = new AttributeStatementListener();
			attributeStatementListener.enterAttr_stmt(ctx.attr_stmt());
			graph.addAttributes(attributeStatementListener.attributes);
		} else if (null != ctx.subgraph()) {
			/*
			 * subgraph
			 */
			final SubgraphListener subgraphListener = new SubgraphListener();
			subgraphListener.enterSubgraph(ctx.subgraph());
			graph.addSubgraph(subgraphListener.graph);
		} else if (null != ctx.id()) {
			/*
			 * graph attribute
			 */
			final IdListener idListener1 = new IdListener();
			idListener1.enterId(ctx.id(0));
			final IdListener idListener2 = new IdListener();
			idListener2.enterId(ctx.id(1));
			final Attribute attribute = new Attribute();
			attribute.setLhs(idListener1.id);
			attribute.addRHS(idListener2.id);
			graph.addAttribute(attribute);
		}
	}
}
