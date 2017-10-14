package com.wang.lambda;

import com.wang.base.Persion;

import java.util.List;
import java.util.function.Consumer;

public interface ProcessPersons {
	void processPersons(List<Persion> stores,CheckPerson checkPerson,Consumer<Persion> block);
}
