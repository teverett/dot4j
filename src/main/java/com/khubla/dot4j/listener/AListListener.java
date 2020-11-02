package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class AListListener extends AbstractListener {
	private final Attributes attributes;

	public AListListener(Attributes attributes) {
		super();
		this.attributes = attributes;
	}

	@Override
	public void enterA_list(DOTParser.A_listContext ctx) {
		if (null != ctx.id()) {
			for (int i = 0; i < ctx.id().size(); i = i + 2) {
				/*
				 * lhs
				 */
				final IdListener idListener1 = new IdListener();
				idListener1.enterId(ctx.id(i));
				/*
				 * rhs
				 */
				final IdListener idListener2 = new IdListener();
				idListener2.enterId(ctx.id(i + 1));
				/*
				 * add
				 */
				final Attribute attribute = new Attribute(idListener1.id, idListener2.id);
				attributes.addAttribute(attribute);
			}
		}
	}
}
