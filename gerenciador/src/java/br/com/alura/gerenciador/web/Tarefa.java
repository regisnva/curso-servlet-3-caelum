/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author regis
 */
public interface Tarefa {
    
    public String executa(ServletRequest request, ServletResponse res);
    
}
