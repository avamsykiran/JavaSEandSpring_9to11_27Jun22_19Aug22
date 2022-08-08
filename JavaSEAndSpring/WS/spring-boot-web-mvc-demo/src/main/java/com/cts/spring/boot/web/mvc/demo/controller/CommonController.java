package com.cts.spring.boot.web.mvc.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

	//@RequestMapping(value = {"","/","/home"},method = RequestMethod.GET)
	@GetMapping({"","/","/home"})
	public ModelAndView defaultRequestHandlerAction() {
		return new ModelAndView("home", "welcomeMsg", "Hai All! we welcoem you to utilize our income statement portal");
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("header-segment");
		mv.addObject("webTitle","IncomeStatementPotal");
		mv.addObject("today", LocalDate.now());
		return mv;
	}
	
	@RequestMapping("/footer")
	public String footerAction() {
		return "footer-segment";
	}
}
