package com.cg.loandisbursal.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.cg.loandisbursal.dao.LoanDisbursalDao;
import com.cg.loandisbursal.dto.LoanRequestDto;
import com.cg.loandisbursal.entity.LoanDisbursalEntity;

@Service
public class LoanDisbursalServiceImpl implements LoanDisbursalService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	LoanDisbursalDao  loanDisbursalDao;
	
	 Logger logger = LoggerFactory.getLogger(LoanDisbursalServiceImpl.class);
	@Override
	@Transactional
	public Boolean addApprovedLoanRequest(LoanRequestDto dto) {
		LoanDisbursalEntity entity =new LoanDisbursalEntity(null, dto.getAccountNo(), dto.getAmount(), dto.getLoanType(), dto.getRateOfInterest(), dto.getTenure(),0.0, "notdisbursed", null, dto.getEmployeeId());
		Double principal=dto.getAmount();
		Double roi=dto.getRateOfInterest()/(12*100);
		Integer months=dto.getTenure();
		Double emi=principal*roi*Math.pow((1+roi), months)/(Math.pow((1+roi), months)-1);
        
        BigDecimal bd = new BigDecimal(emi.toString()).setScale(2, RoundingMode.HALF_UP);
        double editedEMI = bd.doubleValue();
        
		entity.setEMI( editedEMI);
		loanDisbursalDao.save(entity);
		
		logger.info("In service adding approved loan request in to loan disbursal database  ");
		return true;
		
	}

	@Override
	@Transactional
	public Boolean updateAcccountBalance(LoanDisbursalEntity loanDisbursalEntity) {
		 Map<String, String> params = new HashMap<>();
		    params.put("loanId",loanDisbursalEntity.getLoanId().toString());
		    params.put("amount",loanDisbursalEntity.getAmount().toString());
		   //URL has to be written 
		    restTemplate.put ( " ", null, params );
		    loanDisbursalEntity.setApprovedDate(LocalDate.now());
		    loanDisbursalEntity.setLoanStatus("ongoing");
		    loanDisbursalDao.save(loanDisbursalEntity);
		    logger.info("In service updating accounts balance ");
		    return true;
		
	}

}
