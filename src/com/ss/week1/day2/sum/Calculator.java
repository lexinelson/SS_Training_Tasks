/**
 * Week1 - Day 2 - Command Line Sum Task
 */
package com.ss.week1.day2.sum;

/**
 * Calculator (sum) from command line arguments
 * @author Lexi Nelson
 *
 */
public class Calculator {

	/**
	 * Main - parses out numbers and finds sum
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator calcSum = new Calculator();
		
		Double total = 0.0;
		Double temp = 0.0;
		
		for (String arg : args) {
			try {
				temp = Double.parseDouble(arg);
			} catch (NumberFormatException e) {
				System.out.print(arg + " is not valid input. ");
				temp = calcSum.readFromString(arg);
				if (temp == 0.0) {
					System.out.println("It will be ignored.");
				} else {
					System.out.println(temp + " will be used from it.");
				}
			}
			finally {
				total += temp;
			}
		}

		System.out.printf("%nThe sum of the arguments is %.3f", total);
	}
	
	/**
	 * Creates a proper double from any numbers in wrong format string
	 * @param string
	 * @return double
	 */
	public Double readFromString(String s) {
		String[] str = s.split("");
		StringBuffer result = new StringBuffer();
		
		for (String chr : str) {
			try {
				result.append(Integer.parseInt(chr));
			} catch (NumberFormatException e) {
				if (".".equals(chr) && !result.toString().contains(".")) {
					if (result.length() == 0) {
						result.append("0");
					} 
					result.append(chr);
				}
				else if ("-".equals(chr) && result.length() == 0) {
					result.append(chr);
				}
			} finally {}
		}
		
		Double r = 0.0;
		if ("-".equals(result) || "0.".equals(result))
			r = 0.0;
		else if (result.length() > 0)
			r = Double.parseDouble(result.toString());
		
		return r;
	}

}
