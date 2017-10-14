/**
 * Averager 2017/10/10 18:37
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.stream;

import java.util.function.IntConsumer;

/**
 * @author gang.wang
 * @Title: Averager
 * @Description: (描述此类的功能)
 * @date 2017/10/10 18:37
 */
public class Averager implements IntConsumer {

	private int total = 0;
	private int count = 0;

	@Override
	public void accept(int value) {
		count++;
		total+=value;
	}

	public double average(){
		return count>0?1.0*total/count:0;
	}

	public void combiner(Averager other){
		//total+=other.total;
		//count+=other.count;
	}

	public int getTotal() {
		return total;
	}

	public Averager setTotal(int total) {
		this.total = total;
		return this;
	}

	public int getCount() {
		return count;
	}

	public Averager setCount(int count) {
		this.count = count;
		return this;
	}
}
