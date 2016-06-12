/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author regis
 */
public class NovaEmpresa implements Tarefa {

    @Override
    public String executa(ServletRequest req, ServletResponse resp) {
        
        Empresa empresa = adicionar(req);
        req.setAttribute("nome", empresa.getNome());
        
        return "/WEB-INF/paginas/novaEmpresa.jsp";
    }
    
    private Empresa adicionar(ServletRequest req){
        Empresa empresa = new Empresa(req.getParameter("nome"));
        new EmpresaDAO().adiciona(empresa);
        return empresa;
    }
}
