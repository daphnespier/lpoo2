/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2tarefa1_2;

import java.util.Scanner;

/**
 *
 * @author mateusm
 */
public class CalculaSalario {

    private static double salario;
    private static int horas;
    private static double inss;

    public static void recebeParametros() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do salário por Hora:");
        CalculaSalario.salario = input.nextDouble();
        System.out.println("Digite o número de horas trabalhadas no mês");
        CalculaSalario.horas = input.nextInt();
        System.out.println("Digite o percentual de desconto do INSS");
        CalculaSalario.inss = input.nextDouble();
        if (salario < 0 || horas < 0 || inss < 0) {
            throw new RuntimeException("Valores não podem ser negativo");
        }
    }

    public static double salarioBruto() {
        double salarioBruto = salario * horas;
        return salarioBruto;

    }

    public static double salarioLiquido() {
        double desconto = CalculaSalario.salarioBruto() * (inss / 100);
        double liquido = CalculaSalario.salarioBruto() - desconto;
        return liquido;

    }

    public static void relatorio() {
        System.out.println("------ EXTRATO DE SALÁRIO -------");
        System.out.println("Valor Hora: R$ " + salario);
        System.out.println("Horas trabalhadas: " + horas + " horas");
        System.out.println("Salario Bruto: R$ " + CalculaSalario.salarioBruto());
        System.out.println("Salario Liquido: R$ " + CalculaSalario.salarioLiquido());
    }

}
