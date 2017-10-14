/**
 * ProcessPersonsWithFunctionImpl 2017/10/10 13:55
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.lambda.impl;

import com.wang.base.Persion;
import com.wang.lambda.CheckPerson;
import com.wang.lambda.ProcessPersonsWithFunction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author gang.wang
 * @Title: ProcessPersonsWithFunctionImpl
 * @Description: (描述此类的功能)
 * @date 2017/10/10 13:55
 */
public class ProcessPersonsWithFunctionImpl implements ProcessPersonsWithFunction {
	@Override
	public void processPersonsWithFunction(List<Persion> stores, CheckPerson checkPerson,
			Function<Persion, String> function, Consumer<String> block) {
		stores.forEach(item->{
			if(checkPerson.test(item)){
				String data = function.apply(item);
				block.accept(data);
			}
		});
	}
}
