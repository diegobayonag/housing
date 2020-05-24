package com.scotiabank.housing.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		
		return "<h1>Welcome to the housing module.</h1>"
				+"<br><br>In this Module you can:"
				+"<ul><li>Calculate the total montly payment for your mortgage loan.</li></ul>";
		
	}
	
}
