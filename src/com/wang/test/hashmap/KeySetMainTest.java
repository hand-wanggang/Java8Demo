/**
 * KeySetMainTest 2017/10/13 9:55
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.hashmap;

import com.wang.hasmap.MapGenerator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Map;

/**
 * @author gang.wang
 * @Title: KeySetMainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/13 9:55
 */
public class KeySetMainTest {

	// 1、计算keySet方式的迭代时间
	public static void iterator(Map<String, Integer> map) {
		LocalTime start = LocalTime.now();
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			System.out.println(it + "->" + map.get(key));
		}
		LocalTime end = LocalTime.now();
		Duration duration = Duration.between(start, end);
		System.out.println("iterator =" + duration.toMillis() + "ms");
	}

	// 2、迭代过程中的移除操作
	public static void remove(Map<String, Integer> map) {
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			if (map.get(it.next()) % 2 == 0)
				it.remove();
		}
		System.out.println("=========迭代移除后的输出map内容=============");
		System.out.println(map);
	}

	// 3、迭代过程中修改Map
	public static void modify(Map<String, Integer> map) {
		System.out.println("=========修改底层map value内容=============");
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			if (map.get(it.next()) % 2 == 0) {
				map.put(it.next(), -1000);
			}
		}
		System.out.println(map);

		System.out.println("=========修改底层map key内容=============");
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			if (map.get(it.next()) % 7 == 0) {
				map.put("modify", 10000);
			}
		}
		System.out.println(map);
	}

	// 4、删除KeySet内容 会修改底层Map的内容吗？
	public static void modifyKeySet(Map<String,Integer> map){
		System.out.println("修改前:");
		System.out.println(map);
		map.keySet().remove("element1");
		System.out.println("修改后:");
		System.out.println(map);
	}

	public static void main(String[] agrs) {
		// iterator(MapGenerator.generator(10));
		// remove(MapGenerator.generator(10));
		modify(MapGenerator.generator(10));
		modifyKeySet(MapGenerator.generator(10));
	}
}

/**                                                  结论
 * 1、Map在使用keySet的迭代器迭代的过程中可以使用迭代器的remove操作删除元素，此删除操作会传递到底层的map删除对于的key
 * 2、Map在使用keySet进行迭代的过程中可以修改已存在的key的value值，但不能修改key值，否则会抛出ConcurrentModificationException异常
 * 3、当使用Map.keySet时，使用keySet的remove方法删除元素，会对应删除Map对应的Key。
 * 4、1和3底层使用的都是HasMap的removeNode方法，但是迭代器方式考虑了fast-fail机制
 * */