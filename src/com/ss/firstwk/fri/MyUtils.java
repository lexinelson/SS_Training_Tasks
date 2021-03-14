package com.ss.firstwk.fri;

import java.util.List;
import java.util.stream.Collectors;

public class MyUtils {

	public static int orderByContents(String s1, String s2, String target) {
		int x = s1.contains(target) ? 1 : 2;
		int y = s2.contains(target) ? 1 : 2;
		return x - y;
	}

	public String concatIntArray(List<Integer> input) {
		return input.stream().map(x -> x.toString())
				.map(x -> {
					if (Integer.parseInt(x) % 2 == 0) 
						return "e" + x;
					else 
						return "o" + x;})
				.collect(Collectors.joining(","));
	}
	
	public List<String> filterThreeCountAndA(List<String> input) {
		return input.stream()
				.filter((x) -> x.length() == 3)
				.filter((x) -> x.indexOf("a") == 0)
				.collect(Collectors.toList());
	}
}
