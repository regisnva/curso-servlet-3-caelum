/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author regis
 */
@WebServlet(name = "TarefaServlet", urlPatterns = {"/tarefa"})
public class Controller extends HttpServlet {
    
    private final String NOME_DA_CLASSE_TAREFA = "br.com.alura.gerenciador.web.%s";
    
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Inicializando a Servlet " + this);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destruindo a Servlet " + this);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        String nomeTarefa = req.getParameter("acao");
        
        if (nomeTarefa == null || nomeTarefa.isEmpty())
            throw new IllegalArgumentException("É necessário informar o argumento 'nome' para a tarefa");
        
        try {
            Class classeDaTarefa = Class.forName(String.format(NOME_DA_CLASSE_TAREFA, nomeTarefa));
            
            Tarefa instanciaTarefa = (Tarefa) classeDaTarefa.newInstance();
            
            RequestDispatcher dispatcher 
                    = req.getRequestDispatcher(instanciaTarefa.executa(req, res));
            
            dispatcher.forward(req, res);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
    }
}
