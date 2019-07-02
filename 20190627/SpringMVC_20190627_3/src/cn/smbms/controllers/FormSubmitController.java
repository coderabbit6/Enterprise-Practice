package cn.smbms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("singleton") // ÿ�������ǵ���ͬһ��POJO����
public class FormSubmitController {

	/* HttpSession sessionֻ�����������û���Ϣʹ�� */
	// method = RequestMethod.POST��VIEW��ͼ�б��е�method�趨һ��
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String doSave(@ModelAttribute User user, HttpSession session) {

		System.out.println(user.getUsername());
		System.out.println(user.getPwd());

		session.setAttribute("user", user);

		return "view";
	}
}
