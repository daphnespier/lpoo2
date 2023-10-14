/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
public class Menu {

    public static void imprimeMenu() {

        String menu = "--------------------------------------------------" + "\n"
                + "Escolha uma opção ou 'S' para sair" + "\n"
                + "1 - INCLUIR PEDIDO " + "\n"
                + "2 - EXCLUIR PEDIDO POR NOME DO CLIENTE" + "\n"
                + "3 - LISTAR PEDIDOS" + "\n"
                + "S - Sair" + "\n";

            System.out.println(menu);
    }

    public static void imprimeprodutos() {
        String produtos = "--------------------------------------------------" + "\n"
                + "Escolha uma opção ou 'S' para sair" + "\n"
                + "1 - LAVADORALG VC4 (R$4.200) " + "\n"
                + "2 - SMARTPHONE GALAXY S23 (R$6999)" + "\n"
                + "3 - POTES HERMÉTICOS TUPPERWARE (R$400)" + "\n"
                + "S - Sair" + "\n";

        System.out.println(produtos);

    }
}
