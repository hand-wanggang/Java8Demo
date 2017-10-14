/**
 * Persion 2017/10/10 10:35
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.base;

/**
 * @author gang.wang
 * @Title: Persion
 * @Description: (描述此类的功能)
 * @date 2017/10/10 10:35
 */
public class Persion {

	public enum Sex{
		MALE,FEMALE
	}

	private String name;
	private String emailAddress;
	private Integer age;
	private Sex gender;

	public String getName() {
		return name;
	}

	public Persion setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Persion setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Persion setAge(Integer age) {
		this.age = age;
		return this;
	}

	public Sex getGender() {
		return gender;
	}

	public Persion setGender(Sex gender) {
		this.gender = gender;
		return this;
	}

	@Override
	public String toString(){
		return "{name:"+name+", age:"+age+", gender"+getGender()+"}";
	}
}
