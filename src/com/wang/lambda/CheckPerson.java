package com.wang.lambda;

import com.wang.base.Persion;

@FunctionalInterface
public interface CheckPerson {
	boolean test(Persion persion);
}
