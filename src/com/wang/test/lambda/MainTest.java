/**
 * MainTest 2017/10/10 11:21
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.lambda;

import com.wang.base.Persion;
import com.wang.lambda.PrintPersion;
import com.wang.lambda.ProcessPersons;
import com.wang.lambda.ProcessPersonsWithFunction;
import com.wang.lambda.impl.PrintPersionImpl;
import com.wang.lambda.impl.ProcessPersonsImpl;
import com.wang.lambda.impl.ProcessPersonsWithFunctionImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gang.wang
 * @Title: MainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/10 11:21
 */
public class MainTest {

	public static void main(String[] agrs) {
		PrintPersion printPersion = new PrintPersionImpl();
		List<Persion> persions = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Persion persion = new Persion();
			persion.setAge(i * 9 + 1);
			persion.setName("P" + i);
			if (i % 2 == 0)
				persion.setGender(Persion.Sex.MALE);
			else
				persion.setGender(Persion.Sex.FEMALE);
			persions.add(persion);
		}

		// 对条件查找使用lambda完成
		System.out.println("=============start lambda==================");
		printPersion.printPersion(persions, p ->p.getAge() < 50 && p.getGender() == Persion.Sex.FEMALE);

		// 对查找成功后的动作 使用lambda完成
		System.out.println("=============start processPerson==================");
		ProcessPersons processPersons = new ProcessPersonsImpl();
		processPersons.processPersons(persions, p -> p.getGender() == Persion.Sex.FEMALE, p ->
			System.out.println(p.toString()));

		// 使用lambda完成
		System.out.println("=============start processPersonsWithFunction==================");
		ProcessPersonsWithFunction processPersonsWithFunction = new ProcessPersonsWithFunctionImpl();
		processPersonsWithFunction.processPersonsWithFunction(persions, p -> p.getGender() == Persion.Sex.FEMALE,
				p -> p.getName(), name -> System.out.println(name));

		// 使用聚合操作完成上述过程
		System.out.println("=============使用聚合操作==================");
		persions.stream().filter(p -> p.getGender() == Persion.Sex.FEMALE).map(p -> p.getName())
				.forEach(name -> System.out.println(name));
	}
}
