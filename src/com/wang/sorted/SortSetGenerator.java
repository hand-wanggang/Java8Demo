/**
 * SortSetGenerator 2017/10/13 16:15
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.sorted;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author gang.wang
 * @Title: SortSetGenerator
 * @Description: (描述此类的功能)
 * @date 2017/10/13 16:15
 */
public class SortSetGenerator {

	public static SortedSet<String> generator(){

		SortedSet<String> set = new TreeSet<>();
		set.add("door");
		set.add("apple");
		set.add("banana");
		set.add("cat");
		set.add("eat");
		set.add("float");
		set.add("goods");
		set.add("heart");
		return set;
	}


}
