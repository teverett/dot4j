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
			NodeStatementListener nodeStatementListener = new NodeStatementListener();
			nodeStatementListener.enterNode_stmt(ctx.node_stmt());
			graph.addNode(nodeStatementListener.node);
		} else if (null != ctx.edge_stmt()) {
			EdgeStatementListener edgeStatementListener = new EdgeStatementListener();
			edgeStatementListener.enterEdge_stmt(ctx.edge_stmt());
			graph.addEdge(edgeStatementListener.edge);
		} else if (null != ctx.attr_stmt()) {
			AttributeStatementListener attributeStatementListener = new AttributeStatementListener();
			attributeStatementListener.enterAttr_stmt(ctx.attr_stmt());
			if (attributeStatementListener.attributeType == AttributeType.node) {
				graph.addNodeAttributes(attributeStatementListener.attributeList);
			} else if (attributeStatementListener.attributeType == AttributeType.edge) {
				graph.addEdgeAttributes(attributeStatementListener.attributeList);
			} else {
				graph.addGraphAttributes(attributeStatementListener.attributeList);
			}
		} else if (null != ctx.id()) {
			throw new RuntimeException("Not Implemented");
		} else if (null != ctx.subgraph()) {
			SubgraphListener subgraphListener = new SubgraphListener();
			subgraphListener.enterSubgraph(ctx.subgraph());
			graph.addSubgraph(subgraphListener.graph);
		}
	}
}
