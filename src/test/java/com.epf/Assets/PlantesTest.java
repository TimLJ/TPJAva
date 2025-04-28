package com.epf.Assets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlantesTest {
    @Test
    public void testGetters() {
        Plantes p = new Plantes("Pois Tireur", 150, 1.50, 20, 100, 0.00, "normal", "images/plante/poistireur.png");

        assertEquals("Pois Tireur", p.getNom());
        assertEquals(150,p.getPV());
        assertEquals(1.5,p.getAPS());
        assertEquals(20,p.getDmg_Atk());
        assertEquals(100,p.getCout());
        assertEquals(0.00,p.getSunPS());
        assertEquals("normal",p.getEffet());
        assertEquals("images/plante/poistireur.png",p.getChemin_image());
    }

    @Test
    public void testSetters() {
        Plantes p = new Plantes("Pois Tireur", 150, 1.50, 20, 100, 0.00, "normal", "images/plante/poistireur.png");
        Plantes p2 = new Plantes();

        p2.setNom("Pois Tireur");
        p2.setPV(150);
        p2.setAPS(1.5);
        p2.setDmg_Atk(20);
        p2.setCout(100);
        p2.setSunPS(0.00);
        p2.setEffet("normal");
        p2.setChemin_image("images/plante/poistireur.png");

        assertEquals(p.getNom(),p2.getNom());
        assertEquals(p.getPV(),p2.getPV());
        assertEquals(p.getAPS(),p2.getAPS());
        assertEquals(p.getDmg_Atk(),p2.getDmg_Atk());
        assertEquals(p.getCout(),p2.getCout());
        assertEquals(p.getSunPS(),p2.getSunPS());
        assertEquals(p.getEffet(),p2.getEffet());
        assertEquals(p.getChemin_image(),p2.getChemin_image());

    }
}
