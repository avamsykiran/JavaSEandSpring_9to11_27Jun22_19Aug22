package com.cts.spring.boot.rest.api.demo.service;

import java.util.List;

import com.cts.spring.boot.rest.api.demo.entity.Txn;

public interface TxnService {

	Txn getById(Long id);
	List<Txn> getAll();
	Txn save(Txn txn);
	void remove(Long txnId);
}
