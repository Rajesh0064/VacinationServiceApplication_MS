package com.vaccination.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vaccination {

	@Id
	private int id;
	private String centerName;
	private String centerAddress;


	//PDC+PSM+PGM+PPM
	public Vaccination() {
		super();
	}
	public Vaccination(int id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

}