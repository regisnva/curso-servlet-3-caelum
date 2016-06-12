/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author regis
 */
public class SessionUsuario {
    
    private static final String IDENTIFICADOR_USUARIO_LOGADO = "usuarioLogado";

    private SessionUsuario() {
    }
    
    public static void setSession(ServletRequest request, Object object){
        HttpSession session = ((HttpServletRequest)request).getSession();
        session.setAttribute(IDENTIFICADOR_USUARIO_LOGADO, object);
    }
    
    public static Object getSession(ServletRequest request){
        HttpSession session = ((HttpServletRequest)request).getSession();
        return session.getAttribute(IDENTIFICADOR_USUARIO_LOGADO);
    }
    
    public static void removeSession(ServletRequest request){
        HttpSession session = ((HttpServletRequest)request).getSession();
        session.removeAttribute(IDENTIFICADOR_USUARIO_LOGADO);
    }
}
