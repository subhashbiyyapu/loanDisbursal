package com.cg.loandisbursal.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LAONDISBURSAL")
public class LoanDisbursalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_disbursal_generator")
	@SequenceGenerator(name="loan_disbursal_generator", sequenceName = "loandisbursal_seq", allocationSize=1,initialValue=1)
		@Column(name="LOANID")
		 private Long loanId;
		@Column(name="ACCOUNTNO")
		 private Long accountNo;
		@Column(name="AMOUNT")
		 private Double amount;
		@Column(name="LOANTYPE")
		 private String loanType;
		@Column(name="RATEOFINTEREST")
		 private Double rateOfInterest;
		@Column(name="TENURE")
		 private Integer tenure;
		@Column(name="EMI")
		Double emi;
		@Column(name="LOANSTATUS")
		 private String loanStatus;
		@Column(name="APPROVEDDATE")
		LocalDate approvedDate;
		@Column(name="EMPLOYEEID")
		 private Long employeeId;
		
		public LoanDisbursalEntity() {
			super();
			
		}
		public LoanDisbursalEntity(Long loanId, Long accountNo, Double amount, String loanType, Double rateOfInterest,
				Integer tenure, Double emi, String loanStatus, LocalDate approvedDate, Long employeeId) {
			super();
			this.loanId = loanId;
			this.accountNo = accountNo;
			this.amount = amount;
			this.loanType = loanType;
			this.rateOfInterest = rateOfInterest;
			this.tenure = tenure;
			this.emi = emi;
			this.loanStatus = loanStatus;
			this.approvedDate = approvedDate;
			this.employeeId = employeeId;
		}
		public Long getLoanId() {
			return loanId;
		}
		public void setLoanId(Long loanId) {
			this.loanId = loanId;
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
		public Double getEMI() {
			return emi;
		}
		public void setEMI(Double eMI) {
			this.emi = eMI;
		}
		public String getLoanStatus() {
			return loanStatus;
		}
		public void setLoanStatus(String loanStatus) {
			this.loanStatus = loanStatus;
		}
		public LocalDate getApprovedDate() {
			return approvedDate;
		}
		public void setApprovedDate(LocalDate approvedDate) {
			this.approvedDate = approvedDate;
		}
		public Long getEmployeeId() {
			return this.employeeId;
		}
		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}
		 
		

}
