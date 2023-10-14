package ex4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalculaVelocidade {
  public static double leEntrada(Scanner input) {
    double saida = 0.0;

    try {
      saida = Double.parseDouble(input.next());
    } catch (Exception e) {
      System.out.println(e.getMessage() + " - Entrada invalida.");
      System.exit(0);
    }
    return saida;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Lendo as entradas e convertendo-as para double
    System.out.println("Digite a distância percorrida (em Km):");
    double dist = leEntrada(input);
    System.out.println("Digite o tempo de viagem (em horas):");
    double tempo = leEntrada(input);

    // Convertendo as entradas de double para BigDecimal, arredondando com 3 casas
    // decimais e Rouding mode HALF UP (0.5 -> 1)
    BigDecimal distBigDecimal = new BigDecimal(dist).setScale(3, RoundingMode.HALF_UP);
    BigDecimal tempoBigDecimal = new BigDecimal(tempo).setScale(3, RoundingMode.HALF_UP);

    // Calculando a velocidade média
    BigDecimal velocidade = distBigDecimal.divide(tempoBigDecimal, 3, RoundingMode.HALF_UP);

    // Imprimindo a saida com 2 casas
    System.out.printf("Velocidade média: %.2f Km/h.", velocidade.doubleValue());

  }
}