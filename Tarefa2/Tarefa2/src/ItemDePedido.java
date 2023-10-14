/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
public class ItemDePedido {

    private String nome;
    private double preco;
    private int quantidade;

    public ItemDePedido(String nome, double preco, int quantidade) {
        if (preco <= 0 || quantidade <= 0 || nome == " " || nome == null) {
            throw new RuntimeException("Dados inválidos");
        } else {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
