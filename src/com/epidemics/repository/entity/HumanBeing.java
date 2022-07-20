package com.epidemics.repository.entity;

public class HumanBeing {

	Long iD;

	public HumanBeing() {
		super();
	}

	public Long getiD() {
		return iD;
	}

	public void setiD(Long iD) {
		this.iD = iD;
	}

	@Override
	public String toString() {
		return "HumanBeing [iD=" + iD + "]";
	}

}
