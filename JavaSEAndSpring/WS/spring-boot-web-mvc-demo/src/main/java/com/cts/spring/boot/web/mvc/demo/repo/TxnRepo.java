package com.cts.spring.boot.web.mvc.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.spring.boot.web.mvc.demo.entity.Txn;
import com.cts.spring.boot.web.mvc.demo.entity.TxnType;

public interface TxnRepo extends JpaRepository<Txn,Long>{
	
	List<Txn> findAllByType(TxnType type);
	
	@Query("SELECT t FROM Txn t WHERE t.txnDate BETWEEN :start AND :end")
	List<Txn> findAllByRangeOfTxnDate(LocalDate start,LocalDate end);
}