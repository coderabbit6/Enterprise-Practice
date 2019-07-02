package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index1")
	public ModelAndView index(String username) {

		// 需求。使用ModelAndView来存储用户信息，并返回逻辑视图
		// 1.创建一个ModelAndView对象
		ModelAndView mView = new ModelAndView();
		// 2。往ModelAndView保存username
		mView.addObject("usernamekey", username);
		// 3.设置逻辑视图名
		mView.setViewName("indexh");
		// 4。将ModelAndView对象返回
		return mView;

	}
}
