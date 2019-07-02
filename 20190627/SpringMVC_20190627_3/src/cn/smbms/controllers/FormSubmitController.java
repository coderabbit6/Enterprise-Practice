package cn.smbms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("singleton") // 每次请求都是调用同一个POJO对象
public class FormSubmitController {

	/* HttpSession session只是用来保存用户信息使用 */
	// method = RequestMethod.POST与VIEW视图中表单中的method设定一致
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String doSave(@ModelAttribute User user, HttpSession session) {

		System.out.println(user.getUsername());
		System.out.println(user.getPwd());

		session.setAttribute("user", user);

		return "view";
	}
}
