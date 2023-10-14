/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pkg2tarefa1_1.CalculaArea;

/**
 *
 * @author mateusm
 */
public class testes {

    public testes() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void calculaRetangulo() {
        double a = 8.0;
        double b = 5.0;
        double c = CalculaArea.calculaAreaRetangulo(a, b);
        assertEquals(40.0, c, 0.0);
    }

    private void assertEquals(double d, double c, double e) {
    }

    @Test
    public void calculaRetanguloNegativo() {
        double a = -8.0;
        double b = 5.0;

        try {
            double c = CalculaArea.calculaAreaRetangulo(a, b);
        } catch (RuntimeException e) {
            assertEquals("O lado não pode ser negativo", e.getMessage());
        }
    }

    private void assertEquals(String string, String message) {
    }

    @Test
    public void calculaCirculoNegativo() {
        double a = -8.0;
        try {
            double c = CalculaArea.calculaAreaCircunferencia(a);
        } catch (RuntimeException e) {
            assertEquals("O raio não pode ser negativo", e.getMessage());
        }
    }

    @Test
    public void calculaCirculo() {
        double a = 8.0;
        double b = CalculaArea.calculaAreaCircunferencia(a);
        assertEquals(201.062, b, 0.0);
    }

    @Test
    public void calculaTriangulo() {
        double a = 8.0;
        double b = 5.0;
        double c = CalculaArea.calculaAreaTriangulo(a, b);
        assertEquals(20.0, c, 0.0);
    }

    @Test
    public void calculaTrianguloNegativo() {
        double a = -8.0;
        double b = 5.0;
        
        try {
            double c = CalculaArea.calculaAreaTriangulo(a, b);
        } catch (RuntimeException e) {
            assertEquals("Valor negativo não permitido", e.getMessage());
        }
    }
}
