package com.vaccination.Entity;

import java.util.List;

import com.vaccination.model.Vaccination;


public class RequiredResponse {
	private Vaccination Center;
	private List<Citizen> citizens;
	public RequiredResponse() {
		super();
	}
	@Override
	public String toString() {
		return "RequiredResponse [Center=" + Center + ", citizens=" + citizens + "]";
	}
	public Vaccination getCenter() {
		return Center;
	}
	public void setCenter(Vaccination center) {
		Center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	

}
