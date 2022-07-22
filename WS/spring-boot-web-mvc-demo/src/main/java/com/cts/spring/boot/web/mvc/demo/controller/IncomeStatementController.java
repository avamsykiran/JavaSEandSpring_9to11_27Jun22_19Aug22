package com.cts.spring.boot.web.mvc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.spring.boot.web.mvc.demo.entity.Txn;
import com.cts.spring.boot.web.mvc.demo.service.TxnService;

@Controller
@RequestMapping("/txns")
public class IncomeStatementController {

	@Autowired
	private TxnService txnService;
	
	@GetMapping("/list")
	public ModelAndView incomeSatementAction() {
		return new ModelAndView("txns/list-page", "txns", txnService.getAll());
	}
	
	@GetMapping("/del")
	public String delTxnAction(@RequestParam("txnId") long txnId) {
		txnService.remove(txnId);
		return "redirect:/txns/list";
	}

	@GetMapping("/add")
	public ModelAndView addAction() {
		return new ModelAndView("txns/txn-form-page", "txn", new Txn());
	}
	
	@GetMapping("/edit")
	public ModelAndView editAction(@RequestParam("txnId") long txnId) {
		return new ModelAndView("txns/txn-form-page", "txn", txnService.getById(txnId));
	}
	
	@PostMapping({"/add","/edit"})
	public ModelAndView saveAction(@ModelAttribute("txn") @Valid Txn txn,BindingResult bindingResult) {
		ModelAndView mv = null;
		
		if(bindingResult.hasErrors()) {
			mv = new ModelAndView("txns/txn-form-page", "txn", txn);
		}else {
			txnService.save(txn);
			mv = new ModelAndView("redirect:/txns/list");
		}
		
		return mv;
	}
}
