/**
 * Week 1 - Day 5 - Utils and Lambda Task
 */

package com.ss.firstwk.fri;

import java.util.List;
import java.util.stream.Collectors;

/**
 * MyUtils class (+ other exercises)
 * @author Lexi Nelson
 *
 */
public class MyUtils {

	/**
	 * Comparator - return 0 for equals, + for greater, - for less
	 * based on whether it contains a target value (sorts by asc)
	 * @param s1
	 * @param s2
	 * @param target
	 * @return
	 */
	public static int orderByContents(String s1, String s2, String target) {
		if (s1 == null && s2 == null || target == null && s1 != null && s2 != null) 
			return 0;
		if (s1 == null)
			return (target == null) ? -1 : 1;
		if (s2 == null)
			return (target == null) ? -1 : 1;
		
		int x = s1.contains(target) ? 1 : 2;
		int y = s2.contains(target) ? 1 : 2;
		return x - y;
	}

	/**
	 * Adds prefix for even/odd and joins together with commas
	 * @param input
	 * @return
	 */
	public String concatIntList(List<Integer> input) {
		if (input == null)
			return null;
		return input.stream().filter(x -> x != null)
				.map(x -> x.toString())
				.map(x -> {
					if (Integer.parseInt(x) % 2 == 0) 
						return "e" + x;
					else 
						return "o" + x;})
				.collect(Collectors.joining(","));
	}
	
	/**
	 * Filters out any items not starting with a or having exactly 3 letters
	 * @param input
	 * @return
	 */
	public List<String> filterThreeCountAndA(List<String> input) {
		if (input == null)
			return null;
		return input.stream()
				.filter((x) -> x != null)
				.filter((x) -> x.length() == 3)
				.filter((x) -> x.indexOf("a") == 0)
				.collect(Collectors.toList());
	}
}
