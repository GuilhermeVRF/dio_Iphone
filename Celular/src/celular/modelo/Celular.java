/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package celular.modelo;

import celular.interfaces.NavegadorInternet;
import celular.interfaces.Telefone;
import celular.interfaces.TocadorMusica;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author Guilherme
 */
public class Celular implements Telefone, TocadorMusica, NavegadorInternet{
    private int volume;
    
    //Memória RAM do celular
    private int musicaAtual;
    private Stack<String> sitesNavegados;
    
    public Celular(){
        this.volume = 0;
    }
    
    public void aumentarVolume(){
        if(this.volume < 10){
            this.volume++;
        }
    }
    
    public void diminuirVolume(){
        if(this.volume > 0){
            this.volume--;
        }
    }
    
    @Override
    public boolean salvarContato(String numero, String nome){
        return Telefone.agendaContatos.put(numero, nome) != null;
    }
    
    @Override
    public boolean removerContato(String nomeRemovido){
        for(HashMap.Entry<String,String> contato: Telefone.agendaContatos.entrySet()){
            if(contato.getValue().equals(nomeRemovido)){
                Telefone.agendaContatos.remove(contato.getKey());
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public Map<String,String> procurarContato(String nome){
        
        return Telefone.agendaContatos.entrySet()
               .stream().filter(contato -> contato.getValue().startsWith(nome))
               .collect(Collectors.toMap(entry -> entry.getKey(),entry -> entry.getValue()));
    }
    
    @Override
    public void ligar(String numero){
        System.out.println("Ligando: "+ numero);
    }
    
    @Override
    public boolean adicionarMusica(String musica){
        boolean adicionou = TocadorMusica.playList.add(musica);       
        return adicionou;
    }
    
    @Override
    public boolean removerMusica(String musica){
        boolean removeu = TocadorMusica.playList.remove(musica);
        return removeu;
    }
    
    @Override
    public String tocarMusica(){         
        this.musicaAtual = 0;
        
        Optional<String> primeiraMusica = TocadorMusica.playList.stream().findFirst();
        return primeiraMusica.orElse("Sua playList está vazia!");
    }
    
    @Override
    public void tocarProximaMusica(){
        if(this.musicaAtual + 1 < TocadorMusica.playList.size()){
            System.out.println("Tocando: "+ TocadorMusica.playList.get(++this.musicaAtual));
        }else{
            System.out.println("Última música da playlist!");
        }
    }

    @Override
    public void tocarMusicaAnterior() {
        if(this.musicaAtual > 0){
            System.out.println("Tocando: "+ TocadorMusica.playList.get(--this.musicaAtual));
        }else{
            System.out.println("Primeira música da playlist!");
        }
    }
    
    @Override
    public String exibirLista() {
        String listaMusica = "";
        
        for(int posMusica = 0;posMusica < TocadorMusica.playList.size();posMusica++){
            listaMusica += (posMusica + 1)+ " - "+ TocadorMusica.playList.get(posMusica)+ "\n";
        }
        
        return listaMusica;
    }
  
    @Override
    public void entrarSite(String url) {
        if(this.sitesNavegados == null){
            this.sitesNavegados = new Stack<>();
        }
        
        this.sitesNavegados.push(url);
    }

    @Override
    public void sairSiteAtual() {
        if(this.sitesNavegados.size() == 1){
            this.sitesNavegados = null;
        }else{
            this.sitesNavegados.pop();
        }
    }
    
    @Override
    public void exibirHistorico(){
        this.sitesNavegados.stream().forEach(site -> System.out.println(site));
    }
}
