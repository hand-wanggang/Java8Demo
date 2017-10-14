/**
 * EntrySetMainTest 2017/10/13 9:55
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.hashmap;

import com.wang.hasmap.MapGenerator;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author gang.wang
 * @Title: EntrySetMainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/13 9:55
 */
public class EntrySetMainTest {

	public static void iterator(Map<String, Integer> map) {
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		System.out.println("迭代器遍历:");
		for (Iterator<Map.Entry<String, Integer>> it = entry.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> item = it.next();
			System.out.print("[" + item.getKey() + " -> " + item.getValue() + "] ");
		}
		System.out.println();
	}

	public static void entrySetModifyOnIteratorProcess(Map<String, Integer> map) {
		System.out.println("迭代的过程中修改map的值:");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for (Iterator<Map.Entry<String, Integer>> it = entry.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> item = it.next();
			item.setValue(10000);
		}
		System.out.println(map);
	}

	public static void entrySetItrRemoveOnIteratorProcess(Map<String, Integer> map) {
		System.out.println("迭代的过程中使用迭代器的remove删除元素");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for (Iterator<Map.Entry<String, Integer>> it = entry.iterator(); it.hasNext();) {
			if (it.next().getValue() % 3 == 0)
				it.remove();
		}
		System.out.println(map);
	}

	public static void entrySetRemoveOnIteratorProcess(Map<String, Integer> map) {
		System.out.println("迭代的过程改变map结构:");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for (Iterator<Map.Entry<String, Integer>> it = entry.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> item = it.next();
			if (item.getValue() % 3 == 0)
				map.remove(item.getKey());
		}
		System.out.println(map);
	}

	public static void main(String[] agrs) {
		iterator(MapGenerator.generator(10));
		entrySetModifyOnIteratorProcess(MapGenerator.generator(10));
		entrySetItrRemoveOnIteratorProcess(MapGenerator.generator(10));
		entrySetRemoveOnIteratorProcess(MapGenerator.generator(10));
	}
}

/**
 * 结论 1、当Map使用entrySet的迭代器遍历的过程中，可以使用该迭代器remove方法对Map元素进行删除
 * 2、当Map使用entrySet的迭代器遍历的过程中，可以EntrySet对Map的值进行修改
 * 3、在Map使用entrySet的迭代器进行遍历的过程中，如果有其他方法对Map的结构进行的更改将抛出ConcurrentModificationException异常
 */
