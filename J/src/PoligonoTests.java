import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PoligonoTests {
    @Test
    public void testIntersects0(){
        Ponto[] pA = new Ponto[4];
        pA[0] = new Ponto(5,5);
        pA[1] = new Ponto(8,5);
        pA[2] = new Ponto(8,7);
        pA[3] = new Ponto(5,7);
        Poligono A = new Poligono(pA);
        Ponto[] pB = new Ponto[4];
        pB[0] = new Ponto(7,1);
        pB[1] = new Ponto(9,1);
        pB[2] = new Ponto(9,3);
        pB[3] = new Ponto(7,3);
        Poligono B = new Poligono(pB);
        assertFalse(A.intersects(B));
        pA[0] = new Ponto(5,5);
        pA[1] = new Ponto(8,5);
        pA[2] = new Ponto(8,7);
        pA[3] = new Ponto(5,7);
        Poligono C = new Poligono(pA);
        pB[0] = new Ponto(7,4);
        pB[1] = new Ponto(9,4);
        pB[2] = new Ponto(9,6);
        pB[3] = new Ponto(7,6);
        Poligono D = new Poligono(pB);
        assertTrue(C.intersects(D));
    }

    @Test
    public void testIsDuplicate(){
        Ponto[] pA = new Ponto[4];
        pA[0] = new Ponto(5,5);
        pA[1] = new Ponto(8,5);
        pA[2] = new Ponto(8,7);
        pA[3] = new Ponto(5,7);
        Ponto[] pB = new Ponto[4];
        pB[0] = new Ponto(8,7);
        pB[1] = new Ponto(5,7);
        pB[2] = new Ponto(5,5);
        pB[3] = new Ponto(8,5);
        Poligono A = new Poligono(pA);
        Poligono B = new Poligono(pB);
        assertTrue(A.isDuplicate(B));
        Ponto[] pC = new Ponto[3];
        pC[0] = new Ponto(8,7);
        pC[1] = new Ponto(5,7);
        pC[2] = new Ponto(5,5);
        Poligono C = new Poligono(pC);
        assertFalse(A.isDuplicate(C));
        pB[0] = new Ponto(10,7);
        pB[1] = new Ponto(5,7);
        pB[2] = new Ponto(5,5);
        pB[3] = new Ponto(8,5);
        B = new Poligono(pB);
        assertFalse(A.isDuplicate(B));
        pB[0] = new Ponto(8,7);
        pB[1] = new Ponto(5,7);
        pB[2] = new Ponto(6,5);
        pB[3] = new Ponto(8,5);
        B = new Poligono(pB);
        assertFalse(A.isDuplicate(B));
    }

    @Test
    public void testStringToPontos(){
        String s0 = "4 5 5 8 6 8 7 5 7";
        Ponto p00 = new Ponto(5,5);
        Ponto p01 = new Ponto(8,6);
        Ponto p02 = new Ponto(8,7);
        Ponto p03 = new Ponto(5,7);
        Ponto[] p0s = new Ponto[]{p00,p01,p02,p03};
        Poligono p0 = new Poligono(s0);
        for(int i = 0; i < 4; i++){
            assertEquals(p0.pontos[i].x(), p0s[i].x());
            assertEquals(p0.pontos[i].y(), p0s[i].y());
        }
        String s1 = "7 1 9 1 9 3";
        Ponto p10 = new Ponto(7,1);
        Ponto p11 = new Ponto(9,1);
        Ponto p12 = new Ponto(9,3);
        Ponto[] p1s = new Ponto[]{p10,p11,p12};
        Poligono p1 = new Poligono(s1);
        for(int i = 0; i < 3; i++){
            assertEquals(p1.pontos[i].x(), p1s[i].x());
            assertEquals(p1.pontos[i].y(), p1s[i].y());
        }
    }

    @Test
    public void testFindCentroid(){
        Ponto p00 = new Ponto(1,1);
        Ponto p01 = new Ponto(3,1);
        Ponto p02 = new Ponto(3,3);
        Ponto p03 = new Ponto(1,3);
        Ponto[] p0s = new Ponto[]{p00,p01,p02,p03};
        Poligono p0 = new Poligono(p0s);
        Ponto c0 = p0.findCentroid();
        assertEquals(c0.x(), 2.0);
        assertEquals(c0.y(), 2.0);
    }

    @Test
    public void testRotate(){
        Ponto p00 = new Ponto(1,1);
        Ponto p01 = new Ponto(3,1);
        Ponto p02 = new Ponto(3,5);
        Ponto p03 = new Ponto(1,5);
        Ponto[] p0s = new Ponto[]{p00,p01,p02,p03};
        Poligono p0 = new Poligono(p0s);
        Poligono p0r = p0.rotate(90);
        assertEquals(p0r.pontos[0].x(), 4);
        assertEquals(p0r.pontos[0].y(), 2);
        assertEquals(p0r.pontos[1].x(), 4);
        assertEquals(p0r.pontos[1].y(), 4);
        assertEquals(p0r.pontos[2].x(), 0);
        assertEquals(p0r.pontos[2].y(), 4);
        assertEquals(p0r.pontos[3].x(), 0);
        assertEquals(p0r.pontos[3].y(), 2);
        Poligono p1 = new Poligono(p0s);
        Poligono p1r = p1.rotate(-90, new Ponto(3,1));
        assertEquals(p1r.pontos[0].x(), 3);
        assertEquals(p1r.pontos[0].y(), 3);
        assertEquals(p1r.pontos[1].x(), 3);
        assertEquals(p1r.pontos[1].y(), 1);
        assertEquals(p1r.pontos[2].x(), 7);
        assertEquals(p1r.pontos[2].y(), 1);
        assertEquals(p1r.pontos[3].x(), 7);
        assertEquals(p1r.pontos[3].y(), 3);
    }

    @Test
    public void testTranslate(){
        Ponto p00 = new Ponto(1,2);
        Ponto p01 = new Ponto(5,6);
        Ponto p02 = new Ponto(8,7);
        Ponto p03 = new Ponto(12,14);
        Ponto[] p0s = new Ponto[]{p00,p01,p02,p03};
        Poligono p0 = new Poligono(p0s);
        Poligono p0t = p0.translate(-1,3);
        assertEquals(p0t.pontos[0].x(), 0);
        assertEquals(p0t.pontos[0].y(), 5);
        assertEquals(p0t.pontos[1].x(), 4);
        assertEquals(p0t.pontos[1].y(), 9);
        assertEquals(p0t.pontos[2].x(), 7);
        assertEquals(p0t.pontos[2].y(), 10);
        assertEquals(p0t.pontos[3].x(), 11);
        assertEquals(p0t.pontos[3].y(), 17);
    }
}