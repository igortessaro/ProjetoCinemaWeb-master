package Filter;

import Controllers.LoginController;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroLogado", urlPatterns = {"/faces/login.xhtml"})
public class FiltroLogado extends BaseFilter {
    
    public FiltroLogado() {
    }      

    @Override
    public void validateRules(ServletRequest request, ServletResponse response,
            FilterChain chain, HttpSession sessao, 
            HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{        
        LoginController bean = (LoginController) sessao.getAttribute("loginController");
        
        if(bean != null && bean.estaLogado()){ 
            resp.sendRedirect(req.getContextPath() + bean.getUrl());
        }else{
            chain.doFilter(request, response);              
        }    
    }
}
