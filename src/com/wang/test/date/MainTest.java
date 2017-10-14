/**
 * MainTest 2017/10/11 16:41
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.test.date;


import java.time.*;

/**
 * @author gang.wang
 * @Title: MainTest
 * @Description: (描述此类的功能)
 * @date 2017/10/11 16:41
 */
public class MainTest {

	public static void main(String[] agrs){
		testClock();
		localDateTest();
		localTimeTest();
		durationTest();

		System.out.println(new String("abcdefg").hashCode());
		System.out.println(new String("abcdefg").hashCode());
	}

	public static void testClock(){
		Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));
		System.out.println("systemDefaultZone:"+clock.instant());

		Clock utcClock = Clock.system(ZoneId.of("Asia/Kolkata"));
		System.out.println("systemUTC:"+clock.instant());
	}

	public static void localDateTest(){
		Clock clock = Clock.systemDefaultZone();
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now(clock);
		System.out.println("date is :"+date1);
		System.out.println("date is :"+date2);
	}

	public static void localTimeTest(){
		Clock clock = Clock.systemDefaultZone();
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.now(clock);
		System.out.println("time is :"+time1);
		System.out.println("time is :"+time2);
	}

	public static void durationTest(){
		LocalDateTime time1 = LocalDateTime.of(2015,Month.APRIL,20,23,45,26);
		LocalDateTime time2 = LocalDateTime.of(2017,Month.DECEMBER,21,3,5,7);
		Duration duration = Duration.between(time1,time2);
		System.out.println(time1+"和"+time2+"相差"+duration.toDays()+"天");
		System.out.println(time1+"和"+time2+"相差"+duration.toHours()+"时");
		System.out.println(time1+"和"+time2+"相差"+duration.toMinutes()+"分");
	}
}
