/**
 * MainStreamTest 2017/10/10 16:28
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.lambda;

import com.wang.base.Persion;
import com.wang.stream.Averager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gang.wang
 * @Title: MainStreamTest
 * @Description: (描述此类的功能)
 * @date 2017/10/10 16:28
 */
public class MainStreamTest {
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

	public static void main(String[] ages) {
		init();
		System.out.println("============start stream sum - 1============ ");
		Integer sumAge = persions.stream().mapToInt(Persion::getAge).sum();
		System.out.println("sum age is :" + sumAge);
		System.out.println("============start stream sum - 2============ ");
		sumAge = persions.stream().map(Persion::getAge).reduce(0, (a, b) -> a + b);
		System.out.println("sum age is :" + sumAge);

		System.out.println("============start stream avg - 1============ ");
		Double avgScore = persions.stream().mapToInt(Persion::getAge).average().getAsDouble();
		System.out.println("avg age is :" + avgScore);

		System.out.println("============start stream avg - 2============ ");
		Averager averager = persions.stream().map(Persion::getAge).collect(Averager::new, Averager::accept,
				Averager::combiner);
		System.out.println("avg age is :" + averager.average());

		System.out.println("============show stream split data============ ");
		List<String> names = persions.stream().filter(p -> p.getGender() == Persion.Sex.FEMALE).map(Persion::getName)
				.collect(Collectors.toList());
		System.out.println("persion name is :" + names);

		System.out.println("============按性别分组  展示各组成员信息 ============== ");
		Map<Persion.Sex, List<Persion>> groups = persions.stream().collect(Collectors.groupingBy(Persion::getGender));
		System.out.println("group persion result:" + groups);

		System.out.println("============按性别分组  列出每组成员名称============== ");
		Map<Persion.Sex, List<String>> groupsNames = persions.stream().collect(
				Collectors.groupingBy(Persion::getGender, Collectors.mapping(Persion::getName, Collectors.toList())));
		System.out.println("group persion result:" + groupsNames);

		System.out.println("============按性别分组  求每组年龄总和 ============== ");
		Map<Persion.Sex, Integer> groupsAgeSum = persions.stream().collect(
				Collectors.groupingBy(Persion::getGender,Collectors.summingInt(Persion::getAge)));
		System.out.println("group persion result:" + groupsAgeSum);

		System.out.println("============按性别分组  求每组年龄平均值 ============== ");
		Map<Persion.Sex, Double> groupsAgeAvg = persions.stream().collect(
				Collectors.groupingBy(Persion::getGender,Collectors.averagingInt(Persion::getAge)));
		System.out.println("group persion result:" + groupsAgeAvg);

	}
}
