package com.ss.firstwk.fri.proj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayFunctions {
	
	public Integer[] rightDigit(Integer[] input) {
		if (input == null)
			return null;
		return Arrays.stream(input).map(x -> {
			try { return x % 10; }
			catch (NullPointerException e) { return null; }
		}).filter(x -> x != null).toArray(Integer[]::new);
	}
	
	public Integer[] doubling(Integer[] input) {
		if (input == null)
			return null;
		return Arrays.stream(input).map(x -> {
			try { return x * 2; }
			catch (NullPointerException e) { return null; }
		}).filter(x -> x != null).toArray(Integer[]::new);
	}
	
	public String[] noX(String[] input) {
		if (input == null)
			return null;
		return Arrays.stream(input).map(x -> {
			try {
				return x.replace("x", "");
			} catch (NullPointerException e) {return null;}
		}).filter(x -> x != null).toArray(String[]::new);
	}
	
	
	

	public Boolean groupSumClump(Integer[] input, Integer target) {
		if (input == null || target == null || (input.length == 0 && target != 0))
			return false;
		ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> singles = new ArrayList<Integer>();
		groups.add(new ArrayList<Integer>());
		
		//MANUALLY ADD FIRST TO AVOID EXCEPTION
		try {
			if (input[0] == input[1])
				groups.get(0).add(input[0]);
			else
				singles.add(input[0]);
		} catch (NullPointerException e) {
			if (input[0] == null) {
				return false;
			}
			else if (input[0] != target)
				return false;
			else
				return true;
		}

		
		//DIVVY BY GROUPS AND SINGLES
		int groupIndex = 0;
		for (int i = 1; i < input.length - 1; i++) {
			if (input[i] == null || input[i] > target) { 
				//just loop past. larger numbers are useless
			}
			else if (input[i] == target) {
				return true;
			}
			else if (input[i].equals(input[i-1]) || input[i].equals(input[i+1])) {
				groups.get(groupIndex).add(input[i]);
				if (i != input.length-1 && input[i] != input[i+1])
					++groupIndex;
			}
			else {
				singles.add(input[i]);
			}
		}
		//MANUALLY ADD LAST TO AVOID EXCEPTION
		if (input[input.length - 1] == input[input.length-2]) {
			groups.get(groupIndex).add(input[input.length-1]);
		} else {
			singles.add(input[input.length-1]);
		}
		
		//CHECK GROUPS
		Integer sum;
		for (ArrayList<Integer> arr : groups) {
			sum = arr.stream().reduce(0, (x, y) -> x + y);
			if (sum.equals(target))
				return true;
		}
		
		singles = singles.stream().filter(x -> x != null).collect(Collectors.toCollection(ArrayList::new));
		
		//SINGLES TOTAL
		sum = singles.stream().reduce(0, (x, y) -> x + y);
		if (sum == target)
			return true;
		if (sum < target)
			return false;

		ArrayList<Integer> sums = new ArrayList<>(singles);
		
		//GATHER ALL OF THE SUMS
		for (int recursion = 1; recursion < singles.size(); recursion++) {
			//Temp array for Holding
			ArrayList<Integer> holder = new ArrayList<Integer>();
			
			//Loop through current sums
			for (int i = 0; i < sums.size(); i++) {
				for (int j = 0; j < singles.size(); j++) {
					if (sums.get(i) == null || i % singles.size() == j)
						holder.add(null); //to guarantee the pattern holds for more recursions
					else
						holder.add(singles.get(j) + sums.get(i));
				}
			}
			sums.addAll(holder);
		}
		return sums.stream().filter(x -> x != null)
				.collect(Collectors.toList())
				.contains(target);
	}
}
