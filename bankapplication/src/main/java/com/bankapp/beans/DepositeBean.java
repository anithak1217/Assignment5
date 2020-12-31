package com.bankapp.beans;

public class DepositeBean {
	private int depositId;
	private double amount;
	public DepositeBean() {
	}
	public DepositeBean(int depositId, double amount) {
		this.depositId = depositId;
		this.amount = amount;
	}
	public int getDepositId() {
		return depositId;
	}
	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
