package com.cts.spring.boot.web.mvc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.spring.boot.web.mvc.demo.entity.Txn;
import com.cts.spring.boot.web.mvc.demo.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {
	
	@Autowired
	private TxnRepo txnRepo;
	
	@Override
	public Txn getById(Long id) {
		return txnRepo.findById(id).orElse(null);	
	}

	@Override
	public List<Txn> getAll() {
		return txnRepo.findAll();
	}

	@Override
	public Txn save(Txn txn) {
		return txnRepo.save(txn);
	}

	@Override
	public void remove(Long txnId) {
		txnRepo.deleteById(txnId);
	}

}
