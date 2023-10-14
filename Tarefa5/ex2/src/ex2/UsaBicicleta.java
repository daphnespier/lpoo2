package ex2;

public class UsaBicicleta {
  public static void main(String[] args) {
    Bicicleta bike = new Bicicleta() {
      public void aplicarFreios(int decremento) {
        velocidade = velocidade - 2 * decremento;
      }
    };

    System.out.print("Bike parada: ");
    bike.printStates();

    bike.mudarMarcha(5);
    bike.mudarCadencia(30);
    bike.aumentarVelocidade(15);

    System.out.print("Bike em movimento: ");
    bike.printStates();

    bike.aplicarFreios(5);

    System.out.print("Bike após freiar: ");
    bike.printStates();
  }
}