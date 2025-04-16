package org.techhub;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/")
	public String test() {
		return "master";
	}
	
	@RequestMapping(value = "/addemp")
	public String addNewEmployee() {
		return "addemployee";
	}
}
