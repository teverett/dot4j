package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;
import com.khubla.dot4j.domain.*;

public class AttributeListListener extends AbstractListener {
	public AttributeList attributeList;

	@Override
	public void enterAttr_list(DOTParser.Attr_listContext ctx) {
		attributeList = new AttributeList();
		/*
		 * list
		 */
		if (null != ctx.a_list()) {
			for (A_listContext a_listContext : ctx.a_list()) {
				AListListener aListListener = new AListListener();
				aListListener.enterA_list(a_listContext);
			}
		}
	}
}
