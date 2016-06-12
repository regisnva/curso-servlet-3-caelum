/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import java.util.Collection;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author regis
 */
public class BuscaEmpresa implements Tarefa {
    
    public BuscaEmpresa() {
        System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
    }

    @Override
    public String executa(ServletRequest req, ServletResponse resp) {
        String filtro = req.getParameter("filtro");
        
        req.setAttribute("empresas", busca(filtro));
        
        return "/WEB-INF/paginas/buscaEmpresa.jsp";
    }

    private Collection<Empresa> busca(String filtro) {
        return new EmpresaDAO().buscaPorSimilaridade(filtro);
    }
}
