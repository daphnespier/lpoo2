/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
public class Contato {
    private String nome;
    private String telefone;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!obj.getClass().equals(this.getClass()) )
            return false;

        Contato objContato = (Contato)obj;

        if(objContato.getId()!=this.getId())
            return false;

        return true;
    }
    
}
