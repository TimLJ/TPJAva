package com.epf.Persistance;

import com.epf.Assets.Zombies;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ZombiesDAOTest {

    @Test
    public void testGetAllZombies() {
        List<Zombies> expected = Arrays.asList(
                new Zombies("Zombie de base", 100, 0.8, 10, 0.5, "images/zombie/zombie.png", 1),
                new Zombies("Zombie Cone", 200, 0.8, 10, 0.45, "images/zombie/conehead.png", 1),
                new Zombies("Zombie Seau", 300, 0.7, 10, 0.4, "images/zombie/buckethead.png", 1),
                new Zombies("Runner Zombie", 80, 1.0, 8, 0.7, "images/zombie/runner.png", 2),
                new Zombies("Football Zombie", 250, 0.9, 12, 0.6, "images/zombie/football.png", 3)
        );

        ZombiesDAO zombiesDAO = new ZombiesDAO();
        List<Zombies> actual = zombiesDAO.getAllZombies();

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getNom(), actual.get(i).getNom());
            assertEquals(expected.get(i).getPV(), actual.get(i).getPV());
            assertEquals(expected.get(i).getAPS(), actual.get(i).getAPS(), 0.01);
            assertEquals(expected.get(i).getDmg_Atk(), actual.get(i).getDmg_Atk());
            assertEquals(expected.get(i).getVit(), actual.get(i).getVit(), 0.01);
            assertEquals(expected.get(i).getChemin_image(), actual.get(i).getChemin_image());
            assertEquals(expected.get(i).getIDMap(), actual.get(i).getIDMap());
        }
    }

    @Test
    public void testGetZombieID() {
        Zombies expected = new Zombies("Zombie de base", 100, 0.8, 10, 0.5, "images/zombie/zombie.png", 1);

        ZombiesDAO zombiesDAO = new ZombiesDAO();
        Zombies actual = zombiesDAO.getZombieID(1);

        assertEquals(expected.getNom(), actual.getNom());
        assertEquals(expected.getPV(), actual.getPV());
        assertEquals(expected.getAPS(), actual.getAPS(), 0.01);
        assertEquals(expected.getDmg_Atk(), actual.getDmg_Atk());
        assertEquals(expected.getVit(), actual.getVit(), 0.01);
        assertEquals(expected.getChemin_image(), actual.getChemin_image());
        assertEquals(expected.getIDMap(), actual.getIDMap());
    }

    @Test
    public void testAddZombie() {
        Zombies toAdd = new Zombies("Test Zombie", 150, 1.0, 15, 0.55, "images/zombie/test.png", 1);

        ZombiesDAO zombiesDAO = new ZombiesDAO();
        List<Zombies> before = zombiesDAO.getAllZombies();
        zombiesDAO.addZombie(toAdd);
        List<Zombies> after = zombiesDAO.getAllZombies();

        assertEquals(before.size() + 1, after.size());
        Zombies lastAdded = after.get(after.size() - 1);
        assertEquals(toAdd.getNom(), lastAdded.getNom());
        assertEquals(toAdd.getPV(), lastAdded.getPV());
        assertEquals(toAdd.getAPS(), lastAdded.getAPS(), 0.01);
        assertEquals(toAdd.getDmg_Atk(), lastAdded.getDmg_Atk());
        assertEquals(toAdd.getVit(), lastAdded.getVit(), 0.01);
        assertEquals(toAdd.getChemin_image(), lastAdded.getChemin_image());
        assertEquals(toAdd.getIDMap(), lastAdded.getIDMap());
    }

    @Test
    public void testUpdateZombie() {
        Zombies testZombie = new Zombies("Test Zombie", 100, 1.0, 10, 0.5, "images/zombie/test.png", 1);
        ZombiesDAO zombiesDAO = new ZombiesDAO();

        zombiesDAO.addZombie(testZombie);
        List<Zombies> zombies = zombiesDAO.getAllZombies();
        int lastId = zombies.size();

        Zombies updater = new Zombies("Updated Zombie", 150, 1.2, 15, 0.6, "images/zombie/updated.png", 2);
        try {
            zombiesDAO.updateZombie(lastId, updater);

            Zombies updated = zombiesDAO.getZombieID(lastId);
            assertEquals(updater.getNom(), updated.getNom());
            assertEquals(updater.getPV(), updated.getPV());
            assertEquals(updater.getAPS(), updated.getAPS(), 0.01);
            assertEquals(updater.getDmg_Atk(), updated.getDmg_Atk());
            assertEquals(updater.getVit(), updated.getVit(), 0.01);
            assertEquals(updater.getChemin_image(), updated.getChemin_image());
            assertEquals(updater.getIDMap(), updated.getIDMap());
        } finally {
            zombiesDAO.deleteZombie(lastId);
        }
    }

    @Test
    public void testDeleteZombie() {
        ZombiesDAO zombiesDAO = new ZombiesDAO();
        List<Zombies> before = zombiesDAO.getAllZombies();
        int lastId = before.size();

        zombiesDAO.deleteZombie(lastId);
        List<Zombies> after = zombiesDAO.getAllZombies();

        assertEquals(before.size() - 1, after.size());
        for (int i = 0; i < after.size(); i++) {
            assertEquals(before.get(i).getNom(), after.get(i).getNom());
            assertEquals(before.get(i).getPV(), after.get(i).getPV());
            assertEquals(before.get(i).getAPS(), after.get(i).getAPS(), 0.01);
            assertEquals(before.get(i).getDmg_Atk(), after.get(i).getDmg_Atk());
            assertEquals(before.get(i).getVit(), after.get(i).getVit(), 0.01);
            assertEquals(before.get(i).getChemin_image(), after.get(i).getChemin_image());
            assertEquals(before.get(i).getIDMap(), after.get(i).getIDMap());
        }
    }
}
