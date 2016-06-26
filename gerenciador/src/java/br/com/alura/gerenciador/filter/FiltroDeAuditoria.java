/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.filter;

import br.com.alura.gerenciador.util.SessionUsuario;
import br.com.alura.gerenciador.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author regis
 */
@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest req =  (HttpServletRequest) request;
        String usuario = "<deslogado>";
        Usuario usuarioLogado = (Usuario)SessionUsuario.getSession(request);
        
        if(usuarioLogado!= null)        {
            usuario = usuarioLogado.getEmail();
        }
        
        System.out.println("Usuário " 
                + usuario
                + " acessando a URI " 
                + req.getRequestURI());
        
        chain.doFilter(request, response);
    }
    
//    Gerenciamento com cookie    
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
//            throws IOException, ServletException {
//        
//        HttpServletRequest req =  (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse)response;
//        Cookies gerenciadorCookies = new Cookies(req.getCookies());
//        Cookie cookie = gerenciadorCookies.getUsuarioLogado();
//        
//        if(cookie != null){
//            cookie.setMaxAge(10*60);
//            resp.addCookie(cookie);
//        }
//        
//        System.out.println("Usuário " 
//                + gerenciadorCookies.getIdentificacaoUsuarioLogado()
//                + " acessando a URI " 
//                + req.getRequestURI());
//        
//        chain.doFilter(request, response);
//    }
    
    @Override
    public void destroy() {
    }
    
    private Cookie getUsuario(HttpServletRequest req){
        Cookie cookie = null;
        
        if(req.getCookies() == null)
            return cookie;
        
        for (Cookie co : req.getCookies()) {
            if(co.getName().equals("usuarioLogado")){
                cookie = co;
            }
        }
        
        return cookie;
    }
    
    private String getIdentificacaoUsuario(HttpServletRequest req){
        String usuario = "<deslogado>";
        Cookie cookie = getUsuario(req);
        
        if (cookie != null) {
            usuario = cookie.getValue();
        }
        
        return usuario;
    }
}
