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

//@WebFilter(filterName = "FiltroAcesso", urlPatterns = {"/faces/views/*"})
public class FiltroAcesso extends BaseFilter {
    
    public FiltroAcesso() {
    }
    
    @Override
    public void validateRules(ServletRequest request, ServletResponse response,
            FilterChain chain, HttpSession sessao, 
            HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{        
        LoginController bean = (LoginController) sessao.getAttribute("loginController");
        
        if(bean != null && bean.estaLogado()){
            chain.doFilter(request, response);       
        }else{
            resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
        } 
    }
}
