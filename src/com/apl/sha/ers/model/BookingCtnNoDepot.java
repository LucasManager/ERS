package com.apl.sha.ers.model;

import java.io.Serializable;

public class BookingCtnNoDepot extends BookingCtn implements Serializable {

	//此种类型的箱子总数
	private int numbers;
	
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
}
