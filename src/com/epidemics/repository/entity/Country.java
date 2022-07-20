package com.epidemics.repository.entity;

import java.util.Stack;

public class Country {

	String name;
	Long population;

	private Stack<HumanCommon> people;
	private Stack<HumanDoctor> doctors;
	private Stack<HumanSuper> supers;

	public Country(String name) {
		super();
		this.name = name;
		people = new Stack<HumanCommon>();
		doctors = new Stack<HumanDoctor>();
		supers = new Stack<HumanSuper>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Stack<HumanCommon> getPeople() {
		return people;
	}

	public void setPeople(Stack<HumanCommon> people) {
		this.people = people;
	}

	public Stack<HumanDoctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Stack<HumanDoctor> doctors) {
		this.doctors = doctors;
	}

	public Stack<HumanSuper> getSupers() {
		return supers;
	}

	public void setSupers(Stack<HumanSuper> supers) {
		this.supers = supers;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + ", people=" + people + ", doctors=" + doctors
				+ ", supers=" + supers + "]";
	}

}
