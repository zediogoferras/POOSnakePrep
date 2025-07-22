import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloSimplesTest {
    @Test
    public void testConstructor0(){
        Ponto pA0 = new Ponto(1,1);
        Ponto pA2 = new Ponto(3,3);
        RetanguloSimples A = new RetanguloSimples(pA0, pA2);
        assertEquals(pA0.x(), A.bottomLeft().x());
        assertEquals(pA0.y(), A.bottomLeft().y());
        assertEquals(pA2.x(), A.topRight().x());
        assertEquals(pA2.y(), A.topRight().y());
    }

    @Test
    public void testIntersects(){
        Ponto pA0 = new Ponto(1,1);
        Ponto pA1 = new Ponto(3,3);
        RetanguloSimples A1 = new RetanguloSimples(pA0, pA1);
        RetanguloSimples A2 = new RetanguloSimples(pA0, pA1);
        assertTrue(A1.intersects(A2));
        Ponto pB0 = new Ponto(20,20);
        Ponto pB1 = new Ponto(22,40);
        RetanguloSimples B = new RetanguloSimples(pB0,pB1);
        assertFalse(A1.intersects(B));
        Ponto pC0 = new Ponto(3,1);
        Ponto pC1 = new Ponto(5,3);
        RetanguloSimples C = new RetanguloSimples(pC0, pC1);
        assertFalse(A1.intersects(C));
        Ponto pD0 = new Ponto(1,1);
        Ponto pD1 = new Ponto(5,3);
        RetanguloSimples D = new RetanguloSimples(pD0, pD1);
        assertTrue(A1.intersects(D));
    }
}