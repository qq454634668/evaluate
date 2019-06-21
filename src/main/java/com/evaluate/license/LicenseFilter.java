package com.evaluate.license;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet Filter implementation class LicenseFilter
 */
@Slf4j
public class LicenseFilter implements Filter {

	@Autowired
	private LicenseVertify licenseVertify;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		int valid = licenseVertify.vertify();
//
//		if(0==valid){
			chain.doFilter(request, response);
//		}else if(1==valid){//过期
//			request.getRequestDispatcher("overdue.jsp").forward(request,response);
//		}else if(2==valid){
//			throw new ServletException("证书错误");
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
//		boolean init = licenseVertify.setParam();
//		if(init){
//			System.out.println("过滤器初始化成功");
//		}else{
//			throw new ServletException();
//		}

	}

}
