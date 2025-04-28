package com.epf.Assets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapsTest {

    @Test
    public void testGetters() {
        Maps m = new Maps(6,12,"images/map/gazon.png");

        assertEquals(6, m.getLigne());
        assertEquals(12, m.getColonne());
        assertEquals("images/map/gazon.png", m.getChemin_image());
    }

    @Test
    public void testSetters() {
        Maps m = new Maps(6,12,"images/map/gazon.png");
        Maps m2 = new Maps();

        m2.setLigne(6);
        m2.setColonne(12);
        m2.setChemin_image("images/map/gazon.png");

        assertEquals(m.getLigne(), m2.getLigne());
        assertEquals(m.getColonne(), m2.getColonne());
        assertEquals(m.getChemin_image(), m2.getChemin_image());
    }
}
