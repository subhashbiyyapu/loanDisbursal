package com.cg.loandisbursal.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loandisbursal.dto.LoanRequestDto;
import com.cg.loandisbursal.entity.LoanDisbursalEntity;
import com.cg.loandisbursal.service.LoanDisbursalService;


@RestController
public class LoanDisbursalController {
	
	@Autowired
	LoanDisbursalService service;
	
	 Logger logger = LoggerFactory.getLogger(LoanDisbursalController.class);
	
	@PostMapping(value="/loan") 
	public @ResponseBody Boolean  addApprovedLoan(@RequestBody LoanRequestDto dto)
	{
		logger.info("In controller adding approved loan request in to loan disbursal database  ");
		return service.addApprovedLoanRequest(dto);
	}
	
	@PutMapping(value="/updatebalance") 
	public @ResponseBody Boolean  updateBalance(@RequestBody LoanDisbursalEntity entity)
	{
		logger.info("In controller updating accounts balance ");
		return service.updateAcccountBalance(entity);
	}

}
