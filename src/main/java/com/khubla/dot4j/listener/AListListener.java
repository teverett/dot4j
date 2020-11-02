package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class AListListener extends AbstractListener {
	public Attribute attribute;
	private final AttributeType attributeType;

	public AListListener(AttributeType attributeType) {
		super();
		this.attributeType = attributeType;
	}

	@Override
	public void enterA_list(DOTParser.A_listContext ctx) {
		attribute = new Attribute();
		attribute.setAttributeType(attributeType);
		if (null != ctx.id()) {
			/*
			 * lhs
			 */
			final IdListener idListener = new IdListener();
			idListener.enterId(ctx.id(0));
			attribute.setLhs(idListener.id);
			/*
			 * rhs
			 */
			for (int i = 1; i < (ctx.id().size()); i++) {
				final IdListener idListener2 = new IdListener();
				idListener2.enterId(ctx.id(i));
				attribute.addRHS(idListener2.id);
			}
		}
	}
}
