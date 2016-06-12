/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.util.SessionUsuario;
import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;
import br.com.alura.gerenciador.util.Mensagem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author regis
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        Usuario usuario = login(req);
        
        if (usuario == null) {
            saidaUsuarioNaoLogado(resp.getWriter()); 
        } else {
            SessionUsuario.setSession(req, usuario);
            saidaUsuarioLogado(resp.getWriter(), usuario);
        }
    }
    
//    Gerenciamento com Cookie    
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
//            throws ServletException, IOException {
//        
//        Usuario usuario = login(req);
//        
//        if (usuario == null) {
//            saidaUsuarioNaoLogado(resp.getWriter()); 
//        } else {
//            resp.addCookie(cookieUsuarioLogado(usuario));
//            saidaUsuarioLogado(resp.getWriter(), usuario);
//        }
//    }

    private Usuario login(HttpServletRequest req) {
        return new UsuarioDAO().buscaPorEmailESenha(
                req.getParameter("email"),
                req.getParameter("senha"));
    }
    
    private void saidaUsuarioNaoLogado(PrintWriter writer){
        Mensagem.saidaServico(writer, "Usuário ou senha inválida");
    }
    
    private void saidaUsuarioLogado(PrintWriter writer, Usuario usuario){
        Mensagem.saidaServico(writer, "Usuário logado: " + usuario.getEmail());
    }
    
    private Cookie cookieUsuarioLogado(Usuario usuario){
        return new Cookie("usuario.logado", usuario.getEmail());
    }
}
