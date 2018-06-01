/**
 * 
 */
package com.cantech;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shahzad
 *
 */
public class AA {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("null", "dss");
		map.put(null, "sdfsd");
		System.out.println(map.get(null));
	}

}
