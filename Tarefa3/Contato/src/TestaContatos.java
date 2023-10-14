/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TestaContatos {

    private ContatoDAO contatoDAO;

    public TestaContatos() throws Exception {
        contatoDAO = new ContatoDAO();
    }

    public static void main(String[] args) throws Exception {
        TestaContatos main = new TestaContatos();
        String opcao = "";
        while (true) {
            try {
                System.out.println("Escolha uma das opções e tecle <ENTER>: ");
                System.out.println("  1 - Incluir Contato");
                System.out.println("  2 - Remover Contato");
                System.out.println("  3 - Listar Contatos");
                System.out.println("  4 - Alterar Contatos");
                System.out.println("  5 - Sair");
                Scanner sc = new Scanner(System.in, "ISO-8859-1");
                opcao = sc.nextLine();
                switch (opcao) {
                    case "1":
                        main.incluirContato();
                        break;
                    case "2":
                        main.removerContato();
                        break;
                    case "3":
                        main.listarContatos();
                        break;
                    case "4":
                        main.alterarContatos();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                if (opcao.equals("5")) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Falha na operação. Mensagem=" + ex.getMessage());
                //ex.printStackTrace();
            }
        }
    }

    private void incluirContato() {
        System.out.print("Digite o nome do Contato:");
        Scanner sc = new Scanner(System.in, "ISO-8859-1");
        String nome = sc.nextLine();
        System.out.print("Digite o telefone do autor:");
        String telefone = sc.nextLine();
        Contato contato = new Contato(nome, telefone);
        contatoDAO.insereContato(contato);
    }

    private void removerContato() {
        System.out.println("NÃO IMPLEMENTADO");
    }

    private void listarContatos() throws Exception {
        List<Contato> listaContatos = contatoDAO.listarContatos();
        Collections.sort(listaContatos, new Comparator<Contato>() {
            @Override
            public int compare(Contato arg0, Contato arg1) {
                String nomeContato1 = arg0.getNome();
                String nomeContato2 = arg1.getNome();
                int retorno = nomeContato1.compareToIgnoreCase(nomeContato2);
                return retorno;
            }
        });
        System.out.println("ID\tNOME \t TELEFONE");
        for (Contato contato : listaContatos) {
            System.out.println(contato.getId() + " \t" + contato.getNome()+ " \t" + contato.getTelefone());
        }
    }

    private void alterarContatos() {
        System.out.println("NÃO IMPLEMENTADO");
    }
}
