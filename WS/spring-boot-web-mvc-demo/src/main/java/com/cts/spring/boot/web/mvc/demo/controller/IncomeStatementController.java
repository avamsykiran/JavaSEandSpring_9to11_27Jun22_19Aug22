package com.cts.spring.boot.web.mvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
