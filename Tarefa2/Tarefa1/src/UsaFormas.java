
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mateusm
 */

public class UsaFormas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Circunferencia> circulos = new ArrayList<>();
        ArrayList<Retangulo> retangulos = new ArrayList<>();
        ArrayList<Triangulo> triangulos = new ArrayList<>();

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Escolha uma figura geométrica para calcular ou 'S' para sair");
            System.out.println("");
            System.out.println("Escolha sua opção:");
            System.out.println("1 - RETÂNGULO");
            System.out.println("2 - CIRCUNFERENCIA");
            System.out.println("3 - TRIÂNGULO");
            System.out.println("S - Sair");
            String opcao = input.next();
            int figura = 0;

            if (opcao.equalsIgnoreCase("s")) {
                for (Circunferencia c : circulos) {
                    System.out.println("A área da Circunferência é: " + c.area());
                }
                for (Retangulo r : retangulos) {
                    System.out.println("A área do Retângulo é: " + r.area());
                    System.out.println("O perímetro do Retângulo é: " + r.perimetro());
                }
                for (Triangulo t : triangulos) {
                    System.out.println("A área do Triângulo é: " + t.area());
                }
                break;
            } else {
                try {
                    figura = Integer.parseInt(opcao);
                    switch (figura) {
                        case 1:
                            System.out.println("Digite o valor do Lado 1:");
                            double lado1 = input.nextDouble();
                            System.out.println("Digite o valor do Lado 2:");
                            double lado2 = input.nextDouble();
                            Retangulo r = new Retangulo(lado1, lado2);
                            retangulos.add(r);
                            break;

                        case 2:
                            System.out.println("Digite o valor do Raio:");
                            double raio = input.nextDouble();
                            Circunferencia c = new Circunferencia(raio);
                            circulos.add(c);
                            break;

                        case 3:
                            System.out.println("Digite o valor da base:");
                            double base = input.nextDouble();
                            System.out.println("Digite o valor da altura");
                            double altura = input.nextDouble();
                            Triangulo t = new Triangulo(base, altura);
                            triangulos.add(t);
                            break;

                        default:
                            System.out.println("Digite uma opção válida");
                            break;
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
