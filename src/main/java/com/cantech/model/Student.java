/**
 * 
 */
package com.cantech.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shahzad
 *
 */
@Data
@NoArgsConstructor
public class Student {
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;

	public Student(String firstName, String lastName, String email, String mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

}
