/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package celular.main;

import celular.modelo.Celular;

/**
 *
 * @author Guilherme
 */
public class Iphone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Celular iphone = new Celular();
        
        iphone.salvarContato("1", "Guilherme");
        iphone.salvarContato("2", "Guilherme Victor");
        iphone.salvarContato("4", "Gui Gostoso");
        iphone.salvarContato("3", "Rodrigo");
        
        iphone.removerContato("Gui Gostoso");
        
        System.out.println(iphone.procurarContato("Gui"));
        
        iphone.ligar("1");
        
        iphone.adicionarMusica("Primeiros erros");
        iphone.adicionarMusica("Vamos fugir");
        iphone.adicionarMusica("Sutilmente");
        iphone.adicionarMusica("Ainda gosto dela");
        
        System.out.println( iphone.tocarMusica());
        System.out.println(iphone.exibirLista());
        
        iphone.tocarProximaMusica();
        iphone.tocarProximaMusica();
        iphone.tocarProximaMusica();
        iphone.tocarProximaMusica();
        
        iphone.entrarSite("Google.com");
        iphone.entrarSite("Amazon.com");
        iphone.sairSiteAtual();
        
        iphone.exibirHistorico();
    }
    
}
