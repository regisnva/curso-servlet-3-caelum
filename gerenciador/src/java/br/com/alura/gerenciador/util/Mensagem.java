/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.gerenciador.util;

import java.io.PrintWriter;

/**
 *
 * @author regis
 */
public class Mensagem {
    
    private Mensagem(){
    }
    
    public static void saidaServico(PrintWriter writer, String mensagem){
        String padraoSaida = "<html><body>%s</body></html>" ;
        writer.print(String.format(padraoSaida, mensagem));
    }
}
