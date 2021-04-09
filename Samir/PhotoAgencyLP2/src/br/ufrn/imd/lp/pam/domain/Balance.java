package br.ufrn.imd.lp.pam.domain;

public class Balance {

	private double intake;
	private double outFlow;
	private double overBalance;
	private String month;
	private String year;

	public Balance(double intake, double outFlow, String month, String year, Balance lastBalance) {

		this.intake = intake;
		this.outFlow = outFlow;
		this.month = month;
		this.year = year;
		
		if (lastBalance == null) {
			this.overBalance = 0;
		} else {
			this.overBalance = (this.intake - this.outFlow) + lastBalance.getOverBalance();
		}
	}

	public double getIntake() {
		return intake;
	}

	public void setIntake(double intake) {
		this.intake = intake;
	}

	public double getOutFlow() {
		return outFlow;
	}

	public void setOutFlow(double outFlow) {
		this.outFlow = outFlow;
	}

	public double getOverBalance() {
		return overBalance;
	}

	public void setOverBalance(double overBalance) {
		this.overBalance = overBalance;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
