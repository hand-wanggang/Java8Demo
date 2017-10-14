/**
 * ProcessPersonsImpl 2017/10/10 13:37
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.lambda.impl;

import com.wang.base.Persion;
import com.wang.lambda.CheckPerson;
import com.wang.lambda.ProcessPersons;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author gang.wang
 * @Title: ProcessPersonsImpl
 * @Description: (描述此类的功能)
 * @date 2017/10/10 13:37
 */
public class ProcessPersonsImpl implements ProcessPersons {
	@Override
	public void processPersons(List<Persion> stores, CheckPerson checkPerson, Consumer<Persion> block) {
		stores.forEach(item->{
			if(checkPerson.test(item)){
				block.accept(item);
			}
		});
	}
}
