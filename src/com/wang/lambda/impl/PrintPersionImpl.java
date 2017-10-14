/**
 * PrintPersionImpl 2017/10/10 11:16
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.lambda.impl;

import com.wang.base.Persion;
import com.wang.lambda.CheckPerson;
import com.wang.lambda.PrintPersion;

import java.util.List;

/**
 * @author gang.wang
 * @Title: PrintPersionImpl
 * @Description: (描述此类的功能)
 * @date 2017/10/10 11:16
 */
public class PrintPersionImpl implements PrintPersion {
	@Override
	public void printPersion(List<Persion> stores, CheckPerson checkPerson) {
		stores.forEach(store->{
			if(checkPerson.test(store)){
				System.out.println(store.toString());
			}
		});
	}
}
