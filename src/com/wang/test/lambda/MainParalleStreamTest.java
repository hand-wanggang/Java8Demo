/**
 * MainParalleStreamTest 2017/10/11 9:43
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.lambda;

import com.wang.base.Persion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author gang.wang
 * @Title: MainParalleStreamTest
 * @Description: (描述此类的功能)
 * @date 2017/10/11 9:43
 */
public class MainParalleStreamTest {
	static List<Persion> persions = new ArrayList<>();

	public static void init() {
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
	}

	public static void main(String[] agrs) {
		init();
		// 并行计算成员的平均年龄
		System.out.println("==================1. 并行计算成员的平均年龄");
		double avgAge = persions.parallelStream().mapToInt(Persion::getAge).average().getAsDouble();
		System.out.println("result :" + avgAge);

		// 并行分组计算不同性别的成员的平均年龄
		System.out.println("==================2. 并行计算成员的平均年龄");
		ConcurrentMap<Persion.Sex, Double> result = persions.parallelStream()
				.collect(Collectors.groupingByConcurrent(Persion::getGender, Collectors.averagingInt(Persion::getAge)));
		System.out.println("result :" + result);

		// 并行分组不同性别的成员,并提取其姓名信息
		System.out.println("==================3. 并行计算成员的平均年龄");
		ConcurrentMap<Persion.Sex,List<String>> groups = persions.parallelStream().collect(Collectors.groupingByConcurrent(Persion::getGender,
				Collectors.mapping(Persion::getName, Collectors.toList())));
		System.out.println("result :"+groups);
	}
}
