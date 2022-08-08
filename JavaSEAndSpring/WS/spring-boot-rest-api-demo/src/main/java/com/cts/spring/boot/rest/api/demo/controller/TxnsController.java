package com.cts.spring.boot.rest.api.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.spring.boot.rest.api.demo.entity.Txn;
import com.cts.spring.boot.rest.api.demo.exception.InvalidTxnException;
import com.cts.spring.boot.rest.api.demo.service.TxnService;

@RestController
@RequestMapping("/txns")
public class TxnsController {

	enum Operation{
		INSERT,UPDATE;
	}
	
	@Autowired
	private TxnService txnService;
	
	@GetMapping
	public ResponseEntity<List<Txn>> getAllAction(){
		return new ResponseEntity<>(txnService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{txnId}")
	public ResponseEntity<Txn> getTxnAction(@PathVariable("txnId") long txnId){
		Txn t = txnService.getById(txnId);
		return t==null? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<Txn>(t, HttpStatus.OK);
	}
	
	@DeleteMapping("/{txnId}")
	public ResponseEntity<Void> deleteAction(@PathVariable("txnId") long txnId){
		txnService.remove(txnId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	private ResponseEntity<Txn> save(Txn txn,BindingResult results,Operation optr) throws InvalidTxnException{
		if(results.hasErrors()) {
			throw new InvalidTxnException(results.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",(m1,m2) -> m1+","+m2));
		}
		
		txn = txnService.save(txn);
		HttpStatus status = optr==Operation.INSERT?HttpStatus.CREATED:HttpStatus.ACCEPTED;
		return new ResponseEntity<Txn>(txn, status);
	}
	
	@PostMapping
	public ResponseEntity<Txn> insertAction(@RequestBody @Valid Txn txn,BindingResult results) throws InvalidTxnException{
		return save(txn, results, Operation.INSERT);
	}
	
	@PutMapping
	public ResponseEntity<Txn> updateAction(@RequestBody @Valid Txn txn,BindingResult results) throws InvalidTxnException{
		return save(txn, results, Operation.UPDATE);
	}
}
