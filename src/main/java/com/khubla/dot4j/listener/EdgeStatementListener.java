package com.khubla.dot4j.listener;

import java.util.*;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class EdgeStatementListener extends AbstractListener {
	public List<Edge> edges = new ArrayList<Edge>();

	@Override
	public void enterEdge_stmt(DOTParser.Edge_stmtContext ctx) {
		EdgeConnectionPoint from = new EdgeConnectionPoint();
		/*
		 * attr
		 */
		Attributes attributes = null;
		if (null != ctx.attr_list()) {
			final AttributeListListener attributeListListener = new AttributeListListener(AttributeType.edge);
			attributeListListener.enterAttr_list(ctx.attr_list());
			attributes = attributeListListener.attributes;
		}
		/*
		 * from node or graph
		 */
		if (null != ctx.node_id()) {
			final NodeIdListener nodeIdListener = new NodeIdListener();
			nodeIdListener.enterNode_id(ctx.node_id());
			from.setNodeId(nodeIdListener.nodeId);
		} else if (null != ctx.subgraph()) {
			final SubgraphListener subgraphListener = new SubgraphListener();
			subgraphListener.enterSubgraph(ctx.subgraph());
			from.setSubGraph(subgraphListener.graph);
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
				final Edge thisEdge = new Edge();
				thisEdge.setFrom(from);
				thisEdge.setTo(cp);
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
