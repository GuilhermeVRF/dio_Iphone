/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package celular.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public interface TocadorMusica {
    //Memória secundária
    static final List<String> playList = new ArrayList<>();
    
    
    public String exibirLista();
    public boolean adicionarMusica(String musica);
    public boolean removerMusica(String musica);
    public String tocarMusica();
    public void tocarProximaMusica();
    public void tocarMusicaAnterior();
    
}
