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
		// ��ȡһ��SESSION���ж�SESSIon���Ƿ���userSession
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Contans.USER_SESSION);
		// ���û��SESSION ��ת����ʾ��Ϣҳ����ʾ���ܷǷ���¼����Ҫ������½���ܷ���
		if (null == user) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return false;
		}
		return true;

	}

}
