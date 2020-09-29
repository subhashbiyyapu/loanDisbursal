package com.cg.loandisbursal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loandisbursal.entity.LoanDisbursalEntity;

@Repository
public interface LoanDisbursalDao extends JpaRepository<LoanDisbursalEntity, Long> {
List<LoanDisbursalEntity> findByLoanStatus(String loanStatus);

}
