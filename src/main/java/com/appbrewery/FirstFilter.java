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
public class FirstFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		int userId = Integer.parseInt(req.getParameter("uid"));
		String username = req.getParameter("uname");
		
		if(userId < 1)
			out.print("Invalied Input");
		else
			chain.doFilter(request, response);
		
		//if the userId is less than the 1 it will return "Invalied Input"
		//else the filter will move to next filter to check the inputs are empty or not
			
		//System.out.println("Filter is Calling!");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
