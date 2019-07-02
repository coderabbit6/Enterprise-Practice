package cn.smbms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

	@RequestMapping("/main.html")
	public String index() {

		System.out.println("提交的是main.html");
		return "main";

	}

	@RequestMapping("/select.action")
	public ModelAndView select() {
		System.out.println("提交的是select.action");
		return new ModelAndView("select");
	}

}
