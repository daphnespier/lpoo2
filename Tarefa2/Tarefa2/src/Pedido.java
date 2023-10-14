
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mateusm
 */
public class Pedido {

    private String cliente;
    ArrayList<ItemDePedido> listapedido;

    public Pedido(String cliente, ArrayList<ItemDePedido> listapedido) {
        this.cliente = cliente;
        this.listapedido = listapedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemDePedido> getItens() {
        return listapedido;
    }

    public void setListapedido(ArrayList<ItemDePedido> listapedido) {
        this.listapedido = listapedido;
    }

    public void retiraItem(String nome) {
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < this.listapedido.size(); i++) {
            total += this.listapedido.get(i).getPreco();
        }
        return total;
    }

    @Override
    public String toString() {

        String relatorio = "-------------------" + "\n"
                + "Nome do Cliente: " + this.getCliente() + "\n"
                + "Total do Pedido: " + this.getTotal() + "\n"
                + "\n"
                + "Item        |Preço " + "\n";

        for (int i = 0; i < this.listapedido.size(); i++) {
            relatorio += this.listapedido.get(i).getNome() + "         |  "
                    + this.listapedido.get(i).getPreco() + "\n";
        }

        return relatorio;
    }
}
