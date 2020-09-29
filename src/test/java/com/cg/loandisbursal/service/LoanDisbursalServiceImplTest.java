package com.cg.loandisbursal.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loandisbursal.dao.LoanDisbursalDao;
import com.cg.loandisbursal.dto.LoanRequestDto;
import com.cg.loandisbursal.entity.LoanDisbursalEntity;
@SpringBootTest
class LoanDisbursalServiceImplTest {

	@Autowired
	LoanDisbursalService service;
	
	@Autowired
	LoanDisbursalDao dao;
	
	
	@Test
	void addApprovedLoanRequest()
	{
LoanRequestDto dto=new LoanRequestDto();
dto.setRateOfInterest(12.5);
dto.setAmount((double)20000);
dto.setTenure(12);
service.addApprovedLoanRequest(dto);
LoanDisbursalEntity entity=   dao.findById((long)1).get();
assertEquals("notdisbursed", entity.getLoanStatus());


	}


}
