/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.util.SessionUsuario;
import br.com.alura.gerenciador.util.Mensagem;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 *
 * @author regis
 */
public class Logout implements Tarefa {
    
    private int COOKIE_EXPIRADO;

    @Override
    public String executa(ServletRequest req, ServletResponse resp){
        SessionUsuario.removeSession(req);
        return "/WEB-INF/paginas/logout.html";
    }

//    Gerenciamento com cookie
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
//            throws ServletException, IOException {
//        
//        Cookies gerenciadorCookies = new Cookies(req.getCookies());
//        Cookie cookie = gerenciadorCookies.getUsuarioLogado();
//        
//        if(cookie != null){
//            cookie.setMaxAge(COOKIE_EXPIRADO);
//            resp.addCookie(cookie);
//        }
//        
//        Mensagem.saidaServico(resp.getWriter(), "Usuário deslogado");
//    }
}
