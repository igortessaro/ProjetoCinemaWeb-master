package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseFilter implements Filter  {
    public BaseFilter() {
    }      

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        
        HttpSession sessao = req.getSession();
        
        this.validateRules(request, response, chain, sessao, req, resp);
    }
    
    public void validateRules(ServletRequest request, ServletResponse response,
            FilterChain chain, HttpSession sessao, 
            HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{  
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) { 
    }
}
