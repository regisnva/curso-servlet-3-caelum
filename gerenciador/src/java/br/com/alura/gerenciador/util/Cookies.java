/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.util;

import javax.servlet.http.Cookie;

/**
 *
 * @author regis
 */
public class Cookies {
    
    private final Cookie[] cookies;
    private final String IDENTIFICADOR_USUARIO_LOGADO = "usuario.logado";

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }
    
     public String getIdentificacaoUsuarioLogado(){
        String usuario = "<deslogado>";
        Cookie cookie = getUsuarioLogado();
        
        if (cookie != null) {
            usuario = cookie.getValue();
        }
        
        return usuario;
    }
    
    public Cookie getUsuarioLogado(){
        return getCookie(IDENTIFICADOR_USUARIO_LOGADO);
    }
    
    private Cookie getCookie(String identificador){
         Cookie cookie = null;
        
        if(this.cookies == null)
            return cookie;
        
        for (Cookie co : cookies) {
            if(co.getName().equals(identificador)){
                cookie = co;
            }
        }
        
        return cookie;
    }
}
