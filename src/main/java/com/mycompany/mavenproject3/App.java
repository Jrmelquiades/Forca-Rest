
package com.mycompany.mavenproject3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("app")
public class App {
    
    static Jogo jogo = new Jogo();
    
    @GET
    @Path("option1")
    public String retornarPrimeiraOpcaoDeJogo(@QueryParam("palavra") String palavra){
        jogo = new Jogo();
        jogo.setPalavra(palavra);
        String sequencia = jogo.tudoAsterisco();
        return sequencia+"<br>Digite uma letra.";
    }
    
    @GET
    @Path("option2")
    public String retornarSegundaOpcaoDeJogo(){
        jogo = new Jogo();
        jogo.gerarPalavra();
        String sequencia = jogo.tudoAsterisco();
        return sequencia+"<br>Digite uma letra.";
    }
    
    @GET
    @Path("jogar")
    public String jogar(@QueryParam("letra") String letra){
        String sequencia = jogo.tentarLetra(letra);
        jogo.salvarLetra(letra);
        return sequencia;
    }
    
    @GET
    @Path("apresentarStatus")
    public String apresentarStatus(){
        String status = jogo.getTentString()+"<br>";
        status += jogo.verificarVitoria()+"<br>";
        status += jogo.listarLetras();
        return status;
    }
    
}
//http://localhost:8084/mavenproject3/rest/app/apresentarStatus             -> Mostra o status do jogo
//http://localhost:8084/mavenproject3/rest/app/jogar?letra=a                -> Joga a letra desejada ex: a
//http://localhost:8084/mavenproject3/rest/app/option1?palavra=qualquer     -> Inicia o jogo com a palavra passada pelas url
//http://localhost:8084/mavenproject3/rest/app/option2                      -> Inicia o jogo com uma palavra do banco