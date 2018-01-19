package com.analysis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/log"
			+ "in", method = RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest request,
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "operatorStation") String operatorStation) {
		
		return new ModelAndView("redirect:main.html");
	}
	
	@RequestMapping("/showjsonload")
	public ModelAndView jsonload(){
			ModelAndView ab = new ModelAndView("redirect:jsloader.html");
			return ab;
	}

	/*
	 * @RequestMapping("/greeting") public String
	 * greeting(@RequestParam(value="name", defaultValue="World") String name) {
	 * return "Greetings"; }
	 */

}
