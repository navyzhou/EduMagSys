package com.yc.edusys.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.edusys.util.SessionAttributeKey;

@WebFilter(filterName="CheckLoginFilter",value="/back/*",initParams=@WebInitParam(name="errorPage",value="login.html"))
public class CheckLoginFilter implements Filter{
	private String path = "index.html";
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		HttpSession session = request.getSession();
		if (session.getAttribute(SessionAttributeKey.CURRENTLOGINUSER) == null) { // 说明用户没有登录
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() +"/";
			out.print("<script>alert('请先登录...');location.href='" + basePath + path + "';</script>");
			out.flush();
			out.close();
		} else { // 如果已经登录，则交给下一个过滤器过滤
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String tmp = arg0.getInitParameter("errorPage");
		if (tmp != null) {
			path = tmp;
		}
	}
}
