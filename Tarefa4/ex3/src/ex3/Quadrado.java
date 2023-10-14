package ex3;

public class Quadrado implements Superficie {
  double lado;

  public Quadrado(double pLado) {
    lado = pLado;
  }

  public double area() {
    return lado * lado;
  }
}