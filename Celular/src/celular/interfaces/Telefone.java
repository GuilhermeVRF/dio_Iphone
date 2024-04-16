/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package celular.interfaces;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme
 */
public interface Telefone {
    //Memória secundária
    static final Map<String, String> agendaContatos = new HashMap<>();
    
    public void ligar(String numero);
    public boolean salvarContato(String nome, String numero);
    public boolean removerContato(String nome);
    public Map<String,String> procurarContato(String nome); 
}
