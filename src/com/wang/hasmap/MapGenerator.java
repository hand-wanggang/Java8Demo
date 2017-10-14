/**
 * MapGenerator 2017/10/13 9:57
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.hasmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gang.wang
 * @Title: MapGenerator
 * @Description: (描述此类的功能)
 * @date 2017/10/13 9:57
 */
public class MapGenerator {

	public static Map<String, Integer> generator(int cont) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < cont; i++) {
			map.put("element" + i, i);
		}
		return map;
	}
}
