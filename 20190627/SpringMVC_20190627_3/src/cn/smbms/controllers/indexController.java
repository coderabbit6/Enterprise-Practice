package cn.smbms.controllers;

/*
 * ������������Ŀ�����
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {

	// @RequestMapping("/welcome")
	// required=true ȡֵ��Χ true,false �Ƿ���裬
	@RequestMapping(value = "/welcome")
	public String welcome(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "age", required = false) Integer age) {
		// �����ݿ⼰����ҵ��ı�д

		System.out.println("welcome:  " + username);
		System.out.println("welcome:  " + age);
		return "welcome";
	}
}
