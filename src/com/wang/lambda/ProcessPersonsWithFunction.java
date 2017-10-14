/**
 * processPersonsWithFunction 2017/10/10 13:30
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.lambda;

import com.wang.base.Persion;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author gang.wang
 * @Title: processPersonsWithFunction
 * @Description: (描述此类的功能)
 * @date 2017/10/10 13:30
 */
public interface ProcessPersonsWithFunction {
	void processPersonsWithFunction(List<Persion> stores, CheckPerson checkPerson, Function<Persion, String> function,
			Consumer<String> block);
}
