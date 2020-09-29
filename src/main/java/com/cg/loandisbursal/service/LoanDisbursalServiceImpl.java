package com.cg.loandisbursal.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.cg.loandisbursal.dao.LoanDisbursalDao;
import com.cg.loandisbursal.dto.LoanRequestDto;
import com.cg.loandisbursal.dto.LoanTransaction;
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
		LoanDisbursalEntity entity =new LoanDisbursalEntity(null, dto.getAccountNo(), dto.getAmount(), dto.getLoanType(), dto.getRateOfInterest(), dto.getTenure(),0.0, "notdisburseds", null, dto.getEmployeeId());
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
		LoanTransaction loanDto=new LoanTransaction(loanDisbursalEntity.getLoanId(),loanDisbursalEntity.getAccountNo(),loanDisbursalEntity.getAmount());

		   //URL has to be written 
		   Boolean status= restTemplate.postForObject("" , loanDto, Boolean.class);
		  if(status)
		  {
		    loanDisbursalEntity.setApprovedDate(LocalDate.now());
		    loanDisbursalEntity.setLoanStatus("ongoing");
		    loanDisbursalDao.save(loanDisbursalEntity);
		    logger.info("In service updating accounts balance ");
		    return true;
		  }
		  else
		  {logger.info("In service updating accounts balance failure ");
			  return false;
		  }
		   
		   
		
	}

	@Override
	public List<LoanDisbursalEntity> fetchloans(String filter) {
		 logger.info("In service fetching loans ");
		 return loanDisbursalDao.findByLoanStatus(filter);
		
	}

}
