
package com.mycompany.mavenproject3;

import java.util.ArrayList;

public class Jogo {
    
    String escolha;
    char[] palavra;
    int vidas = 6;
    char[] tent = new char[100];
    ArrayList letras = new ArrayList();
    
    boolean acabou = false;
    
    String[] listaPalavras
            = {"PETROLEO", "PESTANA", "PESTILENTO", "PETELECO", "REBOQUE", "CADAFALSO",
                "CADEIRA", "COLA", "REBENTO", "DEFUMADO", "DISCURSO", "ELETRODOMESTICO",
                "ELETRONICA", "ENGRENAGEM", "ESFOMEADO", "FERRALHEIRO", "FERROVIA",
                "FERTIL", "FORTALEZA", "FORTIFICANTE", "OFICINA", "ORNAMENTO", "PALAVRA",
                "PREOCUPADO", "RADIOLOGIA", "RADIOGRAFIA", "GRANJA", "GRANULADO", "INDUZIDO",
                "IMBATIVEL", "INDUSTRIA", "INTERNACIONAL", "LABIRINTO", "LOBISOMEM",
                "LOCOMOTIVA", "TESOURA", "MASSAGISTA", "MATADOURO", "MOCHILA", "NOROESTE",
                "NITROGLICERINA", "HELICOPTERO", "CAPITALISMO", "SOFTWARE", "ENGENHARIA",
                "NOROESTE", "AUTENTICO", "LINUX", "PROCESSADOR", "QUARENTENA", "MEDICINA",
                "HOLOCAUSTO", "RADIOGRAFIA", "XAROPE", "ZAROLHO", "ZOOLOGICO", "HEREDITARIO",
                "EXTASE", "EXTRAVIO", "DUODENO", "ECOLOGISTA", "TURISMO", "TRAFICANTE",
                "CONSELHO", "BAIXISTA", "AVESTRUZ", "QUIMICA", "BOTANICA", "RESPECTIVO",
                "SAXOFONE", "TABERNA", "OCULTO", "TRIGONOMETRIA", "ZODIACO", "JUSTAPOSTO",
                "HIDRAULICO", "HEXAGONO", "MINEIRO", "FRENETICO", "EXPLOSIVEL", "EXORCISTA"};

    public String tudoAsterisco() {
        String sequencia = "";
        for (int i = 0; i < palavra.length; i++) {
            tent[i] = '*';
            sequencia += "*";
        }
        return sequencia;
    }

    public char[] gerarPalavra(){
        double numero = Math.random() * 80;
        int valorAleatorio = (int) Math.round(numero);
        String palav = listaPalavras[valorAleatorio].toLowerCase();
        return palavra = palav.toCharArray();
    }

    public String tentarLetra(String letra) {
        
        try{
            int a = palavra.length;
        }catch (Exception e){return "Escolha uma opção de jogo.";}
        
        String tempTent = "";
        String sequencia = "";
        for(int i=0; i<palavra.length; i++){
            tempTent += ""+tent[i];
            if(letra.equals(""+palavra[i]) && vidas != 0){
                tent[i] = letra.toLowerCase().charAt(0);
                sequencia += letra; 
            }else{
                sequencia += ""+tent[i];
            }
        }
        
        if(letras.contains(letra) && vidas>0 && acabou==false){
            return tempTent+"<br> Você já digitou esta letra! Digite outra letra.";
        }
        
        if(tempTent.equals(sequencia) && vidas>0 && acabou==false){
            vidas -= 1;
        }
        
        String state = verificarVitoria();
        if(state.equals("Perdeste :C") || state.equals("Ganhaste :D")){
            return sequencia;
        }
        
        return sequencia+"<br>Digite uma letra. ";
    }

    public String verificarVitoria() {
        boolean acabou = true;
        for(int i=0; i<palavra.length; i++){
            if("*".equals(""+tent[i])){
                acabou = false;
                break;
            }
        }
        if(acabou == false){
            if(vidas == 0){
                this.acabou = acabou;
                return "Perdeste :C";
            }else{
                return "Ainda restam-te "+vidas+" chances.";
            }
        }else{
            this.acabou = acabou;
            return "Ganhaste :D";
        }
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra.toCharArray();
    }
    
    public String listarLetras(){
        String mensagem = "Lestras utilizadas: ";
        for(int i=0; i<letras.size(); i++){
            mensagem += ""+letras.get(i)+" ";
        }
        return mensagem;
    }

    public void salvarLetra(String letra) {
        if(!letras.contains(letra)){
            letras.add(letra);
        }
    }
    
    public String getTentString(){
        String sequencia = "";
        for(int i=0; i<palavra.length; i++){
            sequencia += ""+tent[i];
        }
        return sequencia;
    }
    
}