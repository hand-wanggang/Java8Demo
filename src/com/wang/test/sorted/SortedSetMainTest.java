/**
 * SortedSetMainTest 2017/10/13 16:23
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.sorted;

import com.wang.sorted.SortSetGenerator;

import java.util.SortedSet;

/**
 * @author gang.wang
 * @Title: SortedSetMainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/13 16:23
 */
public class SortedSetMainTest {

	public static void subSet(SortedSet<String> set){
		System.out.println(set);
		System.out.println("左闭右开的操作:");
		System.out.println(set.subSet("apple","goods"));
		System.out.println(set.headSet("goods"));
		System.out.println(set.tailSet("goods"));
		System.out.println("左闭右闭操作:");
		System.out.println(set.subSet("apple","goods\0"));
		System.out.println(set.headSet("goods\0"));
		System.out.println("左开右闭:");
		System.out.println(set.tailSet("goods\0"));
		System.out.println(set.subSet("apple\0","goods\0"));
	}
	public static void main(String[] args){
		subSet(SortSetGenerator.generator());
	}
}
