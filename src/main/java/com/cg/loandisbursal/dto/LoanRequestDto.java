package com.cg.loandisbursal.dto;



public class LoanRequestDto {
	 
	
		 private Long loanRequestId;
		
		 private Long accountNo;
		
		 private Double amount;
		
		 private String loanType;
		
		 private Double rateOfInterest;
	
		 private Integer tenure;
	
		 private Integer creditScore;
	
		 private String loanStatus;
		
		 private Long employeeId;
		 
		public LoanRequestDto() {
			super();

		}
		
		public LoanRequestDto(Long loanRequestId, Long accountNo, Double amount, String loanType, Double rateOfInterest,
				Integer tenure, Integer creditScore, String loanStatus, Long employeeId) {
			super();
			this.loanRequestId = loanRequestId;
			this.accountNo = accountNo;
			this.amount = amount;
			this.loanType = loanType;
			this.rateOfInterest = rateOfInterest;
			this.tenure = tenure;
			this.creditScore = creditScore;
			this.loanStatus = loanStatus;
			this.employeeId = employeeId;
		}



		public Long getLoanRequestId() {
			return loanRequestId;
		}
		public void setLoanRequestId(Long loanRequestId) {
			this.loanRequestId = loanRequestId;
		}
		public Long getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(Long accountNo) {
			this.accountNo = accountNo;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getLoanType() {
			return loanType;
		}
		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}
		public Double getRateOfInterest() {
			return rateOfInterest;
		}
		public void setRateOfInterest(Double rateOfInterest) {
			this.rateOfInterest = rateOfInterest;
		}
		public Integer getTenure() {
			return tenure;
		}
		public void setTenure(Integer tenure) {
			this.tenure = tenure;
		}
		public Integer getCreditScore() {
			return creditScore;
		}
		public void setCreditScore(Integer creditScore) {
			this.creditScore = creditScore;
		}
		public void setLoanStatus(String loanStatus) {
			this.loanStatus = loanStatus;
		}
		public String getLoanStatus() {
			return loanStatus;
		}
		
		public Long getEmployeeId() {
			return this.employeeId;
		}

		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}
		
		

}
