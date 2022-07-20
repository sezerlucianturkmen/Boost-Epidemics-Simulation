package com.epidemics.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class World {

	Scanner scanner = new Scanner(System.in);
	private int numberOfCountries;
	private long population;
	private int rateDoctor;
	private int rateSuper;
	private int rateVaccination;
	private int day;

	private List<Country> countryList;
	private Stack<HumanCommon> people;
	private Stack<HumanDoctor> doctors;
	private Stack<HumanSuper> supers;

	public World(int numberOfCountries, long population, int rateDoctor, int rateSuper, int rateVaccination, int day) {
		super();
		this.numberOfCountries = numberOfCountries;
		this.population = population;
		this.rateDoctor = rateDoctor;
		this.rateSuper = rateSuper;
		this.rateVaccination = rateVaccination;
		this.day = day;
		countryList = makeCountry(numberOfCountries);
		people = makePopulus(population, rateDoctor, rateSuper, rateVaccination);
		doctors = makeDoctor(population, rateDoctor);
		supers = makeSuper(population, rateSuper);

		addRandomPeople(people, numberOfCountries, countryList);
		addRandomDoctor(doctors, numberOfCountries, countryList);
		addRandomSuper(supers, numberOfCountries, countryList);

		infoWorld(countryList);

	}

	public long findVaccinatedPeople(Stack<HumanCommon> people) {
		long quantity = 0;

		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).eStatusVaccination == EStatusVaccination.Vaccinated) {
				quantity++;
			}
		}
		return quantity;
	}

	public void addRandomDoctor(Stack<HumanDoctor> doctors, int numberOfCountries, List<Country> countryList) {

		do {

			Random random = new Random();
			int pick = random.nextInt(numberOfCountries);

			countryList.get(pick).getDoctors().add(doctors.pop());

		} while (!doctors.isEmpty());

	}

	public void addRandomSuper(Stack<HumanSuper> supers, int numberOfCountries, List<Country> countryList) {

		do {

			Random random = new Random();
			int pick = random.nextInt(numberOfCountries);

			countryList.get(pick).getSupers().add(supers.pop());

		} while (!supers.isEmpty());

	}

	public void addRandomPeople(Stack<HumanCommon> people, int numberOfCountries, List<Country> countryList) {

		do {

			Random random = new Random();
			int pick = random.nextInt(numberOfCountries);

			countryList.get(pick).getPeople().add(people.pop());

		} while (!people.isEmpty());

	}

	public List<Country> makeCountry(int numberOfCountries) {

		countryList = new ArrayList<Country>();
		for (int i = 0; i < numberOfCountries; i++) {

			System.out.println("Please type country name...");
			countryList.add(new Country(scanner.nextLine()));

		}
		System.out.println("Great...you have added all require countries successfully.");
		return countryList;
	}

	public Stack<HumanCommon> makePopulus(long population, int rateDoctor, int rateSuper, int rateVaccination) {

		long qDoctor = population * rateDoctor / 100;
		long qSuper = population * rateSuper / 100;
		long qPeople = population - qDoctor - qSuper;

		long qPeopleVaccinated = population * rateVaccination / 100;

		people = new Stack<>();
		for (int i = 0; i < qPeopleVaccinated; i++) {

			people.push(new HumanCommon(EStatusVaccination.Vaccinated));
		}

		for (int j = 0; j < qPeople - qPeopleVaccinated; j++) {

			people.push(new HumanCommon(EStatusVaccination.NonVaccinated));
		}

		return people;
	}

	public Stack<HumanDoctor> makeDoctor(long population, int rateDoctor) {

		long qDoctor = population * rateDoctor / 100;

		doctors = new Stack<>();
		for (int i = 0; i < qDoctor; i++) {
			doctors.push(new HumanDoctor());
		}

		return doctors;
	}

	public Stack<HumanSuper> makeSuper(long population, int rateSuper) {

		long qSuper = population * rateSuper / 100;

		supers = new Stack<>();
		for (int i = 0; i < qSuper; i++) {
			supers.push(new HumanSuper());
		}

		return supers;
	}

	public void infoWorld(List<Country> countryList) {

		System.out.println("---------------------------------------------------");
		System.out.println("Currently " + population + " people live in the World.");
		System.out.println();
		System.out.println("All countries in this World:");
		System.out.println(" ");

		for (int i = 0; i < countryList.size(); i++) {

			System.out.println("---------------------------------------------------");
			System.out.println(countryList.get(i).getName());
			System.out.println("Population: " + (countryList.get(i).getPeople().size()
					+ countryList.get(i).getSupers().size() + countryList.get(i).getDoctors().size()));
			System.out.println("Number of Commons: " + countryList.get(i).getPeople().size());
			System.out.println("Number of Super People: " + countryList.get(i).getSupers().size());
			System.out.println("Number of Doctors: " + countryList.get(i).getDoctors().size());
			System.out.println("Number of Vaccinated People: " + findVaccinatedPeople(countryList.get(i).getPeople()));
			System.out.println("---------------------------------------------------");
		}

	}

	public int getNumberOfCountries() {
		return numberOfCountries;
	}

	public void setNumberOfCountries(int numberOfCountries) {
		this.numberOfCountries = numberOfCountries;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public int getRateDoctor() {
		return rateDoctor;
	}

	public void setRateDoctor(int rateDoctor) {
		this.rateDoctor = rateDoctor;
	}

	public int getRateSuper() {
		return rateSuper;
	}

	public void setRateSuper(int rateSuper) {
		this.rateSuper = rateSuper;
	}

	public int getRateVaccination() {
		return rateVaccination;
	}

	public void setRateVaccination(int rateVaccination) {
		this.rateVaccination = rateVaccination;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
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
		final int maxLen = 10;
		return "World [numberOfCountries=" + numberOfCountries + ", population=" + population + ", rateDoctor="
				+ rateDoctor + ", rateSuper=" + rateSuper + ", rateVaccination=" + rateVaccination + ", day=" + day
				+ ", countryList="
				+ (countryList != null ? countryList.subList(0, Math.min(countryList.size(), maxLen)) : null)
				+ ", people=" + people + ", doctors=" + doctors + ", supers=" + supers + "]";
	}

}
