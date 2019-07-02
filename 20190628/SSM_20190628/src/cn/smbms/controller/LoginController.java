package cn.smbms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Contans;

@Controller
public class LoginController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/login.html")
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request,
			HttpSession session) {
		User user = userService.login(userCode, userPassword);
		if (null != user) {
			session.setAttribute(Contans.USER_SESSION, user);
			return "redirect:/sys/main.html";
		} else {
			request.setAttribute("error", "用户名和密码错误");
			return "login";
		}

	}

	@RequestMapping(value = "/sys/main.html")
	public String main() {
		return "fram";
	}

	// 退出
	@RequestMapping(value = "/logout.html")
	public String logout(HttpSession session) {
		session.removeAttribute(Contans.USER_SESSION);
		return "login";
	}

}
