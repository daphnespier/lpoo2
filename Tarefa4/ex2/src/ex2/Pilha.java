package ex2;

public class Pilha<T> {
  int topo;
  static int tamMax = 1024;
  T[] arrayPilha;

  @SuppressWarnings("unchecked")
  public Pilha() {
    topo = 0;
    arrayPilha = (T[]) new Object[tamMax];
  }

  public void empilha(T elemento) {
    arrayPilha[topo++] = elemento;
  }

  public void desempilha() {
    if (topo <= 0) {
      throw new RuntimeException("Pilha vazia, nao é possível desempilhar.");
    }
    topo--;
  }

  @Override
  public String toString() {
    if (topo <= 0) {
      throw new RuntimeException("Pilha vazia.");
    }

    String retorno = "";
    for (int i = topo - 1; i >= 0; i--) {
      retorno += (retorno.isEmpty() ? "" : ", ") + arrayPilha[i];
    }
    return retorno.isEmpty() ? "" : ("[ " + retorno + " ]");

  }
}