/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2tarefa1_2;

/**
 *
 * @author mateusm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            CalculaSalario.recebeParametros();
            CalculaSalario.relatorio();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

}
