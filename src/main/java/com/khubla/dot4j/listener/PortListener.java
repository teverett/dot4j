package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class PortListener extends AbstractListener {
	public Port port;

	@Override
	public void enterPort(DOTParser.PortContext ctx) {
		if (null != ctx.id()) {
			String id = null;
			CompassPoint compassPoint = null;
			final IdListener idListener = new IdListener();
			idListener.enterId(ctx.id().get(0));
			id = idListener.id;
			if (ctx.id().size() > 1) {
				final IdListener idListener2 = new IdListener();
				idListener2.enterId(ctx.id().get(1));
				compassPoint = CompassPoint.valueOf(idListener2.id);
			}
			port = new Port(id, compassPoint);
		}
	}
}
