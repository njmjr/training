package com.min.training.filter;

import com.min.training.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		HttpSession session = httpServletRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return true;
		} else {
			// PrintWriter printWriter = httpServletResponse.getWriter();
			// printWriter.write("{code:0,message:\"会话已过期，请重新登录!\"}");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/respJson");
			return false;
		}
	}
}
