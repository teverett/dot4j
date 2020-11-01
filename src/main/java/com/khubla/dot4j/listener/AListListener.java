package com.khubla.dot4j.listener;

import com.khubla.dot.*;

public class AListListener extends AbstractListener {
	@Override
	public void enterA_list(DOTParser.A_listContext ctx) {
		if (null != ctx.id()) {
			throw new RuntimeException("Not Implemented");
		}
	}
}
