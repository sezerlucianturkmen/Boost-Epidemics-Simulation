package com.epidemics.repository.entity;

import java.util.Random;

public class HumanCommon extends HumanBeing {

	EStatus eStatus;
	ETravel eTravel;
	EStatusVaccination eStatusVaccination;

	public HumanCommon(EStatusVaccination eStatusVaccination) {
		super();

		this.eStatusVaccination = eStatusVaccination;
		Random random1 = new Random();
		int status1 = random1.nextInt(2);
		if (status1 == 1)
			eTravel = ETravel.Yes;
		else {
			eTravel = ETravel.No;
		}

	}

	@Override
	public String toString() {
		return "HumanCommon [eStatus=" + eStatus + ", eTravel=" + eTravel + ", eStatusVaccination=" + eStatusVaccination
				+ ", iD=" + iD + "]";
	}

	public EStatus geteStatus() {
		return eStatus;
	}

	public void seteStatus(EStatus eStatus) {
		this.eStatus = eStatus;
	}

	public ETravel geteTravel() {
		return eTravel;
	}

	public void seteTravel(ETravel eTravel) {
		this.eTravel = eTravel;
	}

	public EStatusVaccination geteStatusVaccination() {
		return eStatusVaccination;
	}

	public void seteStatusVaccination(EStatusVaccination eStatusVaccination) {
		this.eStatusVaccination = eStatusVaccination;
	}

}
