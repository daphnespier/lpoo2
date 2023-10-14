package ex3;

public class Circunferencia implements Superficie {
  double raio;

  public Circunferencia(double pRaio) {
    raio = pRaio;
  }

  public double area() {
    return Math.PI * Math.pow(raio, 2);
  }
}