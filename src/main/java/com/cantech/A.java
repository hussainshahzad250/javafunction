/**
 * 
 */
package com.cantech;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shahzad
 *
 */
public class A {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
		String result = list.stream().collect(Collectors.joining());
		result = list.stream().map(o->"'"+o+"'").collect(Collectors.joining(","));

		System.out.println(result);
	}

}
