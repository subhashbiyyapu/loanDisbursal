package com.cg.loandisbursal.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loandisbursal.dao.LoanDisbursalDao;
import com.cg.loandisbursal.dto.LoanRequestDto;
@SpringBootTest
class LoanDisbursalServiceImplTest2 {

	
	@Autowired
	LoanDisbursalService service;
	
	@Autowired
	LoanDisbursalDao dao;  
	
	@Test
	void fetchLoans() {
		LoanRequestDto request1=new LoanRequestDto(121L, 5555555555L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
		LoanRequestDto request2=new LoanRequestDto(122L, 5555555556L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
		service.addApprovedLoanRequest(request1);
		service.addApprovedLoanRequest(request1);
		assertEquals(2,service.fetchloans("notdisbursed").size());
		
		
	}
	@Test
	void fetchLoans2() {
		LoanRequestDto request1=new LoanRequestDto(121L, 5555555555L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
		LoanRequestDto request2=new LoanRequestDto(122L, 5555555556L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
		service.addApprovedLoanRequest(request1);
		service.addApprovedLoanRequest(request1);
		assertEquals(0,service.fetchloans("ongoing").size());
		
		
	}

}
