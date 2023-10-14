/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2;

/**
 *
 * @author mateusm
 */
public class ThreadContador extends Thread {

    private int maxValue;

    public ThreadContador(int pMaxValue, String pName) {
        this.maxValue = pMaxValue;
        this.setName(pName);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= this.maxValue; i++) {
                System.out.printf("Thread: %s - Contador: %d%n", Thread.currentThread().getName(), i);
                sleep(1000);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}
