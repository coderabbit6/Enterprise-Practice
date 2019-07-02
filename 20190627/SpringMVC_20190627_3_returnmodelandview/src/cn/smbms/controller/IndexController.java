package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index1")
	public ModelAndView index(String username) {

		// ����ʹ��ModelAndView���洢�û���Ϣ���������߼���ͼ
		// 1.����һ��ModelAndView����
		ModelAndView mView = new ModelAndView();
		// 2����ModelAndView����username
		mView.addObject("usernamekey", username);
		// 3.�����߼���ͼ��
		mView.setViewName("indexh");
		// 4����ModelAndView���󷵻�
		return mView;

	}
}
