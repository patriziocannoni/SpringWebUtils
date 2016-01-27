package br.com.cannoni.springwebutils.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Implementação abstrata da interface {@link Filter} para suporte a injeção de dependência com Spring Framework.
 * 
 * @author Patrizio
 * @since 14/02/2014
 */
public abstract class SpringHttpFilter implements Filter {

	/**
	 * {@link ServletContext} exposto para as classes que extendem o {@link SpringHttpFilter}.
	 */
	protected ServletContext servletContext;

	/**
	 * Construtor.
	 */
	public SpringHttpFilter() {
		super();
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		servletContext = fConfig.getServletContext();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletContext);
	}

}
