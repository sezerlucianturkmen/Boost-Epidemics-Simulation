package com.epidemics.repository.entity;

import java.util.Random;

public class HumanDoctor extends HumanBeing {

	ETravel eTravel;

	public HumanDoctor() {
		super();
		this.eTravel = eTravel;

		Random random = new Random();
		int status = random.nextInt(2);

		if (status == 1)
			eTravel = ETravel.Yes;
		else {
			eTravel = ETravel.No;
		}

	}

	@Override
	public String toString() {
		return "HumanDoctor [eTravel=" + eTravel + ", iD=" + iD + "]";
	}

	public ETravel geteTravel() {
		return eTravel;
	}

	public void seteTravel(ETravel eTravel) {
		this.eTravel = eTravel;
	}

}
