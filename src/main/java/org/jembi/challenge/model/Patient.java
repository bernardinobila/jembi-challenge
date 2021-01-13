package org.jembi.challenge.model;

import java.lang.Math;

public class Patient {

	private Long id;

	private String identityNumber;

	private String firstName;

	private String lastName;

	private String phone;

	private String address;

	private String gender;

	private String race;

	public Patient() {
		super();
	}
	
	public Patient(String identityNumber, String firstName,
			String lastName, String phone, String address, String gender,
			String race) {
		super();
		this.id = generateRandomNumber();
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.race = race;
	}

	public Patient(Long id, String identityNumber, String firstName,
			String lastName, String phone, String address, String gender,
			String race) {
		super();
		this.id = id;
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.race = race;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", identityNumber=" + identityNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", address=" + address + ", gender="
				+ gender + ", race=" + race + "]";
	}
	
	private Long generateRandomNumber() {
		double rNumber = Math.random();
		return (long) rNumber;
	}

}
