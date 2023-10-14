/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2;

/**
 *
 * @author mateusm
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadContador t1 = new ThreadContador(10, "t1");
        ThreadContador t2 = new ThreadContador(20, "t2");

        t1.start();
        t2.start();

    }

}
