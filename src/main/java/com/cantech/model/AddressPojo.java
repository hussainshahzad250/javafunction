package com.cantech.model;

import lombok.Data;

@Data
public class AddressPojo{
	private String houseNumber;
	private String streetName;
	private String city;
	private String state;
	private String pin;
}