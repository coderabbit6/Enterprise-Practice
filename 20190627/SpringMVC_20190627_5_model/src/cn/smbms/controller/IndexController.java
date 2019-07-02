package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index1")
	public String index(String username, Model model) {

		model.addAttribute("username", username);
		// 无KEY存储。
		model.addAttribute(username);

		User u = new User();
		u.setUsername("中软国际");
		model.addAttribute(u);
		model.addAttribute("currentUser", u);

		return "indexh";

	}
}
