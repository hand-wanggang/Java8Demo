/**
 * MainStreamForeachOrderTest 2017/10/11 9:58
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.lambda;

import com.wang.base.Persion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author gang.wang
 * @Title: MainStreamForeachOrderTest
 * @Description: (描述此类的功能)
 * @date 2017/10/11 9:58
 */
public class MainStreamForeachOrderTest {

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

	public static void main(String[] agrs){
		init();
		// 1
		System.out.println("========1. 串行顺序遍历");
		persions.stream().map(Persion::getName).forEach(e->System.out.print(" "+e));
		System.out.println();
		// 2
		Comparator<Persion> comparator = Comparator.comparingInt(Persion::getAge);
		Collections.sort(persions,comparator.reversed());
		System.out.println("========2. 串行顺序遍历倒序");
		persions.stream().map(Persion::getName).forEach(e->System.out.print(" "+e));
		System.out.println();
		// 3
		System.out.println("========3. 并行遍历-1");
		persions.parallelStream().map(Persion::getName).forEach(e->System.out.print(" "+e));
		System.out.println();

		// 4
		System.out.println("========4. 并行遍历-2");
		persions.parallelStream().map(Persion::getName).forEach(e->System.out.print(" "+e));
		System.out.println();

		// 5
		System.out.println("========5. 并行有序遍历");
		persions.parallelStream().map(Persion::getName).forEachOrdered(e->System.out.print(" "+e));
	}
}
