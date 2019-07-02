package cn.smbms.controllers;

/*
 * 处理超链接请求的控制器
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {

	// @RequestMapping("/welcome")
	// required=true 取值范围 true,false 是否必需，
	@RequestMapping(value = "/welcome")
	public String welcome(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "age", required = false) Integer age) {
		// 对数据库及其他业务的编写

		System.out.println("welcome:  " + username);
		System.out.println("welcome:  " + age);
		return "welcome";
	}
}
