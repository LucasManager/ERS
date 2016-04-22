package com.apl.sha.ers.struts;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;

public class SetCharEncodingFilter implements Filter {

	protected FilterConfig filterConfig;

	protected String encodingName;

	protected boolean enable;

	public SetCharEncodingFilter() {
		this.encodingName = "UTF-8";
		this.enable = false;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		loadConfigParams();
	}

	private void loadConfigParams() {
		// encoding
		String initParam=this.filterConfig.getInitParameter("encoding");
		if(initParam!=null&&!initParam.equalsIgnoreCase("")) {
			this.encodingName = initParam;			
		}
		// filter enable flag...
		String strIgnoreFlag = this.filterConfig.getInitParameter("enable");
		if (strIgnoreFlag.equalsIgnoreCase("true")) {
			this.enable = true;
		} else {
			this.enable = false;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (this.enable) {
			request.setCharacterEncoding(this.encodingName);
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}