package com.appbrewery;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;


@WebFilter("/addData")
public class SecondFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//System.out.println("Filter is Calling Second Filter!");
		
		PrintWriter out = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String username = req.getParameter("uname");
		
		if(username.equals(""))
			out.print("Second Filter | Name can not be null");
		else
			chain.doFilter(request, response);
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
