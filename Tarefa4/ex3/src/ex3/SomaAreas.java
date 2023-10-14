package ex3;

public class SomaAreas {
    public static <T extends Superficie> double calculaArea(T array[]) {
        double soma = 0.0;
        for (T elemento : array) {
            soma += elemento.area();
        }
        return soma;
    }
}