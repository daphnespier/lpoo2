/*
*Construa uma classe com três métodos estáticos:
*a. public static double calculaAreaRetangulo(double lado1, double lado2)
*b. public static double calculaAreaCircunferencia(double raio)
*c. public static double calculaAreaTriangulo(double base, double altura)
*Se qualquer método receber parâmetros negativos, deve-se levantar a exceção 
*RuntimeException.
*Antes da criação da classe, crie uma classe de teste unitário, com pelo 
*menos dois testes para cada método. 
*No método main dessa classe crie uma estrutura para obter os parâmetro do 
*teclado (com opção para o usuário escolher qual área quer calcular).
 */
package pkg2tarefa1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mateusm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Escolha a figura geométrica desejada:");
        System.out.println("1 - RETÂNGULO");
        System.out.println("2 - CIRCUNFERENCIA");
        System.out.println("3 - TRIÂNGULO");
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o valor do Lado 1:");
                double lado1 = input.nextDouble();
                System.out.println("Digite o valor do Lado 2:");
                double lado2 = input.nextDouble();

                System.out.print("A area do Retângulo é: ");
                System.out.println(CalculaArea.calculaAreaRetangulo(lado1, lado2));
                break;
                
            case 2:
                System.out.println("Digite o valor do Raio:");
                double raio = input.nextDouble();

                System.out.print("A area da Circunferência é: ");
                System.out.println(CalculaArea.calculaAreaCircunferencia(raio));
                break;
              
            case 3:
                System.out.println("Digite o valor da base:");
                double base = input.nextDouble();
                System.out.println("Digite o valor da altura");
                double altura = input.nextDouble();

                System.out.print("A area do Triângulo é: ");
                System.out.println(CalculaArea.calculaAreaTriangulo(base, altura));
                break;
            
            default: System.out.println("Digite uma opção válida");  
            break;
        }

    }

}
