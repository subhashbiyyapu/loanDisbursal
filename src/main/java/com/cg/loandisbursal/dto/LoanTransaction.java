package com.cg.loandisbursal.dto;

public class LoanTransaction {
	
	private long loanId;
	
	private long accountNo;
	
	private double amount;
	
	public LoanTransaction() {
		super();
	}
	public LoanTransaction(long loanId,long accountNo, double amount) {
		super();
		this.loanId=loanId;
		this.accountNo = accountNo;
		this.amount = amount;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return "LoanTranscationForm [loanId=" + loanId + ", accountNo=" + accountNo + ", amount=" + amount + "]";
	}
	

}
