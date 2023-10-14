
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mateusm
 */
public class SistemaPedidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList();
        ArrayList<ItemDePedido> itens = new ArrayList();

        while (true) {
            Menu.imprimeMenu();
            String opcao = input.next();
            int figura = 0;

            if (opcao.equalsIgnoreCase("s")) {

                break;

            } else {

                try {
                    figura = Integer.parseInt(opcao);
                    switch (figura) {
                        case 1:
                            while (true) {
                                Menu.imprimeprodutos();
                                String opcaoPedido = input.next();
                                int produto = 0;
                                if (opcaoPedido.equalsIgnoreCase("s")) {
                                    if (itens.isEmpty()) {
                                        break;
                                    } else {
                                        String nome = "";
                                        System.out.println("Digite seu nome: ");
                                        nome = input.next();
                                        Pedido finalizado = new Pedido(nome, itens);
                                        pedidos.add(finalizado);
                                        System.out.println("Pedido incluído com sucesso;");
                                        break;
                                    }
                                }
                                try {
                                    produto = Integer.parseInt(opcaoPedido);
                                    if (produto == 1) {
                                        ItemDePedido tv = new ItemDePedido("LAVADORALG VC4", 590.0, 1);
                                        itens.add(tv);
                                    } else if (produto == 2) {
                                        ItemDePedido celular = new ItemDePedido("SMARTPHONE GALAXY", 210.0, 1);
                                        itens.add(celular);
                                    } else if (produto == 3) {
                                        ItemDePedido airfryer = new ItemDePedido("POTES HERMÉTICOS TUPPERWARE", 400.0, 1);
                                        itens.add(airfryer);
                                    } else {
                                        System.out.println("Opção inválida");
                                        break;
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            break;

                        case 2:
                            System.out.println("Digite o nome do cliente para excluir o pedido");
                            String excluir = input.next();

                            for (Pedido p : pedidos) {
                                if (p.getCliente().equalsIgnoreCase(excluir)) {
                                    pedidos.remove(p);
                                    System.out.println("Pedido Excluído com sucesso!");
                                } else {
                                    System.out.println("Cliente não encontrado!");
                                }
                            }
                            break;

                        case 3:
                            for (Pedido p : pedidos) {
                                System.out.println(p.toString());
                            }
                            break;

                        default:
                            System.out.println("Digite uma opção válida");
                            break;
                    }

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());

                }
            }

        }

    }

}
