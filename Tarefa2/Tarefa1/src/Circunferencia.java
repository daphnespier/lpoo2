
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mateusm
 */


public class Circunferencia {

    private double raio;

    public Circunferencia(double raio) {
        if (raio < 0) {
            throw new RuntimeException("O raio não pode ser negativo");
        } else {
            this.raio = raio;
        }
    }

    public double area() {
        double resultado = Math.PI * Math.pow(raio, 2);
        DecimalFormat formato = new DecimalFormat("0.00");
        String string = formato.format(resultado);
        resultado = Double.parseDouble(string);
        return resultado;
    }

}
