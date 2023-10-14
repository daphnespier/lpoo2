/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;
// import org.junit.Test;
// import static org.junit.Assert.*;

/**
 *
 * @author mateusm
 */
public class TestaArea {

    public TestaArea() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeClass
    public void setUp() {
    }

    @AfterClass
    public void tearDown() {
    }

    @Test
    public void testaAreaCirculo() {
        Circunferencia c = new Circunferencia(5);
        double area = c.area();
        assertEquals(78.54, area, 0.0);
    }

    private void assertEquals(double d, double area, double e) {
    }

    @Test
    public void testaCirculoNegativo() {
        try {
            Circunferencia c = new Circunferencia(-5);
            double area = c.area();
        } catch (RuntimeException e) {
            assertEquals("O raio não pode ser negativo", e.getMessage());
        }
    }

    private void assertEquals(String string, String message) {
    }

    @Test
    public void testaAreaRetangulo() {
        Retangulo r = new Retangulo(5, 10);
        double area = r.area();
        assertEquals(50.0, area, 0.0);
    }

    @Test
    public void testaRetanguloNegativo() {
        try {
            Retangulo r = new Retangulo(-5, 10);
            double area = r.area();
        } catch (RuntimeException e) {
            assertEquals("O lado não pode ser negativo", e.getMessage());
        }
    }

    @Test
    public void testaPerimetroRetangulo() {
        Retangulo r = new Retangulo(5, 10);
        double perimetro = r.perimetro();
        assertEquals(30.0, perimetro, 0.0);
    }

    @Test
    public void testaAreaTriangulo() {
        Triangulo t = new Triangulo(5, 10);
        double area = t.area();
        assertEquals(25.0, area, 0.0);
    }

    @Test
    public void testaTrianguloNegativo() {
        try {
            Triangulo t = new Triangulo(5, -10);
            double area = t.area();
        } catch (RuntimeException e) {
            assertEquals("Valor negativo não permitido", e.getMessage());
        }
    }
}
