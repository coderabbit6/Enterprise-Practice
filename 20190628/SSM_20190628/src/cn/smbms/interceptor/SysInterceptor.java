package cn.smbms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.smbms.pojo.User;
import cn.smbms.tools.Contans;

public class SysInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// 获取一下SESSION，判断SESSIon中是否有userSession
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Contans.USER_SESSION);
		// 如果没有SESSION 跳转到提示信息页。提示不能非法登录。需要正常登陆才能访问
		if (null == user) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return false;
		}
		return true;

	}

}
