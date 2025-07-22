import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetaTests {

    @Test
    void testIsParallel() {
        Reta r0 = new Reta(new Ponto(0,0), new Ponto(100,0));
        Reta r1 = new Reta(new Ponto(1,1), new Ponto(20,1));
        assertTrue(r0.isParallel(r1));
        Reta r2 = new Reta(new Ponto(0,0), new Ponto(0,100));
        Reta r3 = new Reta(new Ponto(1,1), new Ponto(1,100));
        assertTrue(r2.isParallel(r3));
        assertFalse(r1.isParallel(r2));
        Reta r4 = new Reta(new Ponto(0,0), new Ponto(1,1));
        Reta r5 = new Reta(new Ponto(1,2), new Ponto(2,3));
        assertTrue(r4.isParallel(r5));
    }

}