package com.khubla.dot4j.listener;

import java.util.*;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;
import com.khubla.dot4j.domain.*;

public class EdgeRHSListener extends AbstractListener {
	public List<NodeId> nodeIds = new ArrayList<NodeId>();
	public List<Graph> subGraphs = new ArrayList<Graph>();

	@Override
	public void enterEdgeRHS(DOTParser.EdgeRHSContext ctx) {
		if (null != ctx.node_id()) {
			for (final Node_idContext node_idContext : ctx.node_id()) {
				final NodeIdListener nodeIdListener = new NodeIdListener();
				nodeIdListener.enterNode_id(node_idContext);
				nodeIds.add(nodeIdListener.nodeId);
			}
		} else if (null != ctx.subgraph()) {
			for (final SubgraphContext subgraphContext : ctx.subgraph()) {
				final SubgraphListener subgraphListener = new SubgraphListener();
				subgraphListener.enterSubgraph(subgraphContext);
				subGraphs.add(subgraphListener.graph);
			}
		}
	}
}
