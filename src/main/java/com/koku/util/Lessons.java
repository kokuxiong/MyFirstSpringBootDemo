package com.koku.util;

import java.util.LinkedHashMap;
import java.util.Map;


public class Lessons {
	private static Map<Integer,String> lessons = new LinkedHashMap<>();
	
	static {
		lessons.put(10, "Math");
		lessons.put(11, "Yuwen");
		lessons.put(12, "English");
		lessons.put(13, "Wuli");
		lessons.put(14, "Huaxue");
		lessons.put(15, "ShengWu");
		lessons.put(16, "Dili");
	}
	
	public static Map<Integer,String> getLessons() {
		return lessons;
	}
}
