package com.khubla.dot4j.listener;

import java.util.*;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class EdgeStatementListener extends AbstractListener {
	public List<Edge> edges = new ArrayList<Edge>();

	@Override
	public void enterEdge_stmt(DOTParser.Edge_stmtContext ctx) {
		EdgeConnectionPoint from = null;
		/*
		 * attr
		 */
		final Attributes attributes = new Attributes(AttributeType.anonymous);
		if (null != ctx.attr_list()) {
			final AttributeListListener attributeListListener = new AttributeListListener(attributes);
			attributeListListener.enterAttr_list(ctx.attr_list());
		}
		/*
		 * from node or graph
		 */
		if (null != ctx.node_id()) {
			final NodeIdListener nodeIdListener = new NodeIdListener();
			nodeIdListener.enterNode_id(ctx.node_id());
			from = new EdgeConnectionPoint(nodeIdListener.nodeId);
		} else if (null != ctx.subgraph()) {
			final SubgraphListener subgraphListener = new SubgraphListener();
			subgraphListener.enterSubgraph(ctx.subgraph());
			from = new EdgeConnectionPoint(subgraphListener.graph);
		}
		/*
		 * walk edge RHS
		 */
		if (null != ctx.edgeRHS()) {
			final EdgeRHSListener edgeRHSListener = new EdgeRHSListener();
			edgeRHSListener.enterEdgeRHS(ctx.edgeRHS());
			/*
			 * walk edges, connecting them up
			 */
			for (final EdgeConnectionPoint cp : edgeRHSListener.connectionPoints) {
				final Edge thisEdge = new Edge(from, cp);
				thisEdge.addAttributes(attributes);
				edges.add(thisEdge);
				/*
				 * from is now too
				 */
				from = cp;
			}
		}
	}
}
