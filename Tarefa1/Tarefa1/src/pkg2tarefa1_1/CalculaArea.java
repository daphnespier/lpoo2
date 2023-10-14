/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2tarefa1_1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author mateusm
 */
public class CalculaArea {

      public static double formataDouble(double a) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        char decimalSeparator = symbols.getDecimalSeparator();
        DecimalFormat formato = new DecimalFormat("0.000", symbols);
        String string = formato.format(a);
        String[] part = string.split("[" + decimalSeparator + "]");
        String string2 = part[0] + "." + part[1];
        double resultado = Double.parseDouble(string2);
        return resultado;
    }

    public static double calculaAreaRetangulo(double lado1, double lado2) {
        double resultado = 0;
        if (lado1 < 0 || lado2 < 0) {
            throw new RuntimeException("O lado não pode ser negativo");
        } else {
            resultado = lado1 * lado2;
            resultado = CalculaArea.formataDouble(resultado);
        }
        return resultado;
    }

    public static double calculaAreaCircunferencia(double raio) {
        double resultado = 0;
        if (raio < 0) {
            throw new RuntimeException("O raio não pode ser negativo");
        } else {
            resultado = Math.PI * Math.pow(raio, 2);
            resultado = CalculaArea.formataDouble(resultado);
        }
        return resultado;
    }

    public static double calculaAreaTriangulo(double base, double altura) {
        double resultado = 0;
        if (base < 0 || altura < 0) {
            throw new RuntimeException("Valor negativo não permitido");
        } else {
            resultado = (base * altura) / 2;
            resultado = CalculaArea.formataDouble(resultado);
        }
        return resultado;
    }
}
