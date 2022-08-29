package com.bridgelabz.opencsv.pojo;

import com.opencsv.bean.CsvBindByName;

public class UserModel {

	public UserModel(String name, String email, String phone, String country) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.country = country;
	}

	@CsvBindByName
	private String name;

	@CsvBindByName
	private String email;

	@CsvBindByName
	private String phone;

	@CsvBindByName
	private String country;

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + ", phone="
				+ phone + ", country=" + country + "]";
	}

}