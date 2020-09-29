package com.cg.loandisbursal.service;

import java.util.List;

import com.cg.loandisbursal.dto.LoanRequestDto;
import com.cg.loandisbursal.entity.LoanDisbursalEntity;

public interface LoanDisbursalService {
	Boolean  addApprovedLoanRequest(LoanRequestDto loanRequestDto);
	Boolean updateAcccountBalance(LoanDisbursalEntity loanDisbursalEntity);
	List<LoanDisbursalEntity> fetchloans(String filter);

}
