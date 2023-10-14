package ex3;

public class Outer {
  private int x = 0;

  public static void main(String[] args) {
    Outer o = new Outer();
    Inner i = o.new Inner();
    o.print();
  }

  public void print() {
    System.out.println("x before: " + x);
    Inner i = new Inner();
    i.print();
  }

  class Inner {
    public void print() {
      x++;
      System.out.println("x after: " + x);
    }
  }
}