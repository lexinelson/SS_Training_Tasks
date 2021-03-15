package com.ss.firstwk.fri.proj;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;

public class EvaluateNums {

	public static void main(String[] args) {
		EvaluateNums eval = new EvaluateNums();
		eval.evaluate(System.in, System.out);
	}
	
	public void evaluate(InputStream in, OutputStream out) {
		PrintStream outLine = new PrintStream(out);
		Scanner scan = new Scanner(in);
		Consumer<Integer> funct;
		
		int count = 0;
		boolean flag = false;
		do {
			try {
				count = readLine(scan.nextLine())[0];
			} catch (NumberFormatException e) {
				flag = true;
				outLine.println("NO NUMBER WAS ENTERED");
			}
		} while (flag);
		
		Consumer<Integer>[] ops = new Consumer[count];
		Integer[] targets = new Integer[count];
		
		int i = 0, errCount = 0;
		do {
			try {
				Integer[] input = readLine(scan.nextLine());
				switch (input[0]) {
					case 1:
						ops[i] = isOdd(out);
						break;
					case 2:
						ops[i] = isPrime(out);
						break;
					case 3:
						ops[i] = isPalindrome(out);
						break;
				}
				if (ops[i] != null && input.length > 1) {
					targets[i] = input[1];
					++i;
				} else {
					++errCount;
				}
			} catch (NumberFormatException e) {
				++errCount;
			} catch (NullPointerException e) {
				++errCount;
			} catch (NoSuchElementException e) {
				break;
			}
		} while (i < count && errCount < 20);
		
		if (errCount == 20) {
			outLine.println("TOO MANY ATTEMPTS WITH INCORRECT FORMAT");
			System.exit(-1);
		} else {
			i = 0;
			for (Integer tar : targets) {
				Arrays.stream(new Integer[] {tar}).forEach(ops[i++]);
			}
		}
	}
	
	public Integer[] readLine(String str) throws NumberFormatException {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		NumberFormatException exep = null;
		if (str == null) {
			str = " ";
		}
		for (String s : str.split(" ")) {
			try {
				arr.add(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				exep = e;
			}
		}
		if (exep != null && arr.size() == 0) {
			throw exep;
		}
		else if (arr.size() == 0)
			return null;
		return arr.toArray(new Integer[arr.size()]);
	}

	public Consumer<Integer> isOdd(OutputStream out) {
		return (x) -> {
			if (x != null) {
				if (x % 2 == 0)
					new PrintStream(out).println("EVEN");
				else
					new PrintStream(out).println("ODD");
			}
		};
	}
	
	public Consumer<Integer> isPrime(OutputStream out) {
		return (x) -> {
			if (x != null) {
				boolean divisible = false;
				for (int i = 2; i < Math.abs(x); i++) {
					if (x % i == 0) {
						divisible = true;
						break;
					}
				}
				if (divisible)
					new PrintStream(out).println("COMPOSITE");
				else
					new PrintStream(out).println("PRIME");
			}
		};
	}
	
	public Consumer<Integer> isPalindrome(OutputStream out) {
		return (x) -> {
			if (x != null) {
				StringBuilder rev = new StringBuilder(x.toString());
				if (x.toString().equals(rev.reverse().toString()))
					new PrintStream(out).println("PALINDROME");
				else
					new PrintStream(out).println("NOT PALINDROME");
			}
		};
	}
}
