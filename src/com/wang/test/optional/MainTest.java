/**
 * MainTest 2017/10/11 16:18
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.optional;

import com.wang.base.Persion;

import java.util.Optional;
import java.util.Random;

/**
 * @author gang.wang
 * @Title: MainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/11 16:18
 */
public class MainTest {

	public static void main(String[] agrs) throws Exception {
		Random random = new Random();
		Optional<Persion> persion;
		// 1、生成一个Optional实例,不明确其是否为空
		if (random.nextInt() % 2 == 0) {
			persion = Optional.of(new Persion().setGender(Persion.Sex.FEMALE).setAge(20).setName("Test")
					.setEmailAddress("work@163.com"));

		} else {
			persion = Optional.ofNullable(null);
		}

		// 2、对Optional实例进行一些操作
		persion.ifPresent(p -> System.out.println(p.getName()));

		// 3
		persion.orElse(new Persion());
		persion.orElseGet(Persion::new);
		persion.orElseThrow(() -> new Exception(""));
	}
}
