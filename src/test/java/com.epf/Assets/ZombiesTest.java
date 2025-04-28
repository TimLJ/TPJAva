package com.epf.Assets;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ZombiesTest {
    @Test
    public void testGetters() {
        Zombies z = new Zombies("Zombie de base", 100, 0.80, 10, 0.50, "images/zombie/zombie.png", 1);

        assertEquals("Zombie de base",z.getNom());
        assertEquals(100,z.getPV());
        assertEquals(0.80,z.getAPS());
        assertEquals(10,z.getDmg_Atk());
        assertEquals(0.50,z.getVit());
        assertEquals("images/zombie/zombie.png",z.getChemin_image());
        assertEquals(1,z.getIDMap());
    }


    @Test
    public void testSetters() {
        Zombies z = new Zombies("Zombie de base", 100, 0.80, 10, 0.50, "images/zombie/zombie.png", 1);
        Zombies z2 = new Zombies();

        z2.setNom("Zombie de base");
        z2.setPV(100);
        z2.setAPS(0.80);
        z2.setDmg_Atk(10);
        z2.setVit(0.50);
        z2.setChemin_image("images/zombie/zombie.png");
        z2.setIDMap(1);

        assertEquals(z.getNom(),z2.getNom());
        assertEquals(z.getPV(),z2.getPV());
        assertEquals(z2.getAPS(),z2.getAPS());
        assertEquals(z2.getDmg_Atk(),z2.getDmg_Atk());
        assertEquals(z2.getVit(),z2.getVit());
        assertEquals(z2.getChemin_image(),z2.getChemin_image());
        assertEquals(z2.getIDMap(),z2.getIDMap());

    }
}
