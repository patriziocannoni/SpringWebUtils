package br.com.cannoni.springwebutils.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Extensão do {@link HttpServlet} para suporte a injeção de dependência com Spring Framework.
 * 
 * @author Patrizio
 * @since 23/07/2013
 */
public abstract class SpringHttpServlet extends HttpServlet {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1669631766951452746L;

	/**
	 * Construtor.
	 */
	public SpringHttpServlet() {
		super();
	}

	@Override
	public void init(ServletConfig sConfig) throws ServletException {
		super.init(sConfig);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, sConfig.getServletContext());
	}

}
