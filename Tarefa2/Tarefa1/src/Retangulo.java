/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
public class Retangulo {

    private double lado1;
    private double lado2;

    public Retangulo(double lado1, double lado2) {
        if (lado1 < 0 || lado2 < 0) {
            throw new RuntimeException("O lado não pode ser negativo");
        } else {
            this.lado1 = lado1;
            this.lado2 = lado2;
        }
    }

    public double area() {
        double resultado = lado1 * lado2;
        return resultado;
    }

    public double perimetro() {
        double resultado = (lado1 * 2) + (lado2 * 2);
        return resultado;
    }
}
