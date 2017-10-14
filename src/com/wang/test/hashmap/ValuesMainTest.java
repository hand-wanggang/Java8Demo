/**
 * ValuesMainTest 2017/10/13 9:56
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.hashmap;

import com.wang.hasmap.MapGenerator;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author gang.wang
 * @Title: ValuesMainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/13 9:56
 */
public class ValuesMainTest {

	public static void iterator(Map<String, Integer> map) {
		Collection<Integer> values = map.values();
		System.out.println("遍历:");
		for (Iterator<Integer> it = values.iterator(); it.hasNext();) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void itRemove(Map<String, Integer> map) {
		for (Iterator<Integer> it = map.values().iterator(); it.hasNext();) {
			if (it.next() % 2 == 0) {
				it.remove();
			}
		}
		System.out.println("遍历中删除被2整除的数:");
		System.out.println(map);
	}

	public static void remove(Map<String, Integer> map) {
		map.values().remove(5);
		System.out.println("使用Collection::remove删除value=5:");
		System.out.println(map);
	}

	public static void removeElementOnIteratorProcess(Map<String,Integer> map){
		for (Iterator<Integer> it = map.values().iterator(); it.hasNext();) {
			Integer temp = it.next();
			if (temp % 3 == 0) {
				map.values().remove(temp);
			}
		}
		System.out.println("迭代器运行中，使用Collection::remove元素:");
		System.out.println(map);
	}

	public static void main(String[] agrs){
		iterator(MapGenerator.generator(10));
		itRemove(MapGenerator.generator(10));
		remove(MapGenerator.generator(10));
		// 出错
		removeElementOnIteratorProcess(MapGenerator.generator(10));
	}
}

/**                             结论
 * 1、Map的values是一个由Map的具体实现内部的Values类继承AbstractCollection实现的一个集合实例。
 * 2、当使用迭代器遍历values时，可以使用迭代器的remove方法删除元素（影响底层结构的数据）
 * 3、直接使用values的集合删除方法，可以删除底层结构map中的对应元素
 * 4、在values的遍历过程中如果map的结构发生变化，将抛出ConcurrentModificationException异常(fail-fast机制)
* */

