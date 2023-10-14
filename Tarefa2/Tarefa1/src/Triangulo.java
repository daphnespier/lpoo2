/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
public class Triangulo {

    private double altura;
    private double base;

    public Triangulo(double altura, double base) {
        if (base < 0 || altura < 0) {
            throw new RuntimeException("Valor negativo não permitido");
        } else {
            this.altura = altura;
            this.base = base;
        }
    }
    public double area() {
        double resultado = (base * altura) / 2;
        return resultado;
    }

}
