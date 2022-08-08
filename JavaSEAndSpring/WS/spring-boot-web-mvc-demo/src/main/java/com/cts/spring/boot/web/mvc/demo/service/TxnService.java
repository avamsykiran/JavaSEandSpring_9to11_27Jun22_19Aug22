package com.cts.spring.boot.web.mvc.demo.service;

import java.util.List;

import com.cts.spring.boot.web.mvc.demo.entity.Txn;

public interface TxnService {

	Txn getById(Long id);
	List<Txn> getAll();
	Txn save(Txn txn);
	void remove(Long txnId);
}
