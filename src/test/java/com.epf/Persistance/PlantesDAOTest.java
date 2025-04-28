package com.epf.Persistance;

import com.epf.Assets.Plantes;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlantesDAOTest {

    @Test
    public void testGetAllPlantes() {
        List<Plantes> expected = Arrays.asList(
                new Plantes("Tournesol", 100, 0.00, 0, 50, 25.00, "normal", "images/plante/tournesol.png"),
                new Plantes("Pois Tireur", 150, 1.50, 20, 100, 0.00, "normal", "images/plante/poistireur.png"),
                new Plantes("Double Pisto P", 150, 1.50, 40, 200, 0.00, "normal", "images/plante/doublepois.png"),
                new Plantes("Glace Pois", 120, 1.00, 10, 175, 0.00, "slow low", "images/plante/glacepois.png"),
                new Plantes("Noix", 300, 0.00, 0, 50, 0.00, "normal", "images/plante/noix.png")
        );

        PlantesDAO plantesDAO = new PlantesDAO();
        List<Plantes> actual = plantesDAO.getAllPlantes();

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getNom(), actual.get(i).getNom());
            assertEquals(expected.get(i).getPV(), actual.get(i).getPV());
            assertEquals(expected.get(i).getAPS(), actual.get(i).getAPS(), 0.01);
            assertEquals(expected.get(i).getDmg_Atk(), actual.get(i).getDmg_Atk());
            assertEquals(expected.get(i).getCout(), actual.get(i).getCout());
            assertEquals(expected.get(i).getSunPS(), actual.get(i).getSunPS(), 0.01);
            assertEquals(expected.get(i).getEffet(), actual.get(i).getEffet());
            assertEquals(expected.get(i).getChemin_image(), actual.get(i).getChemin_image());
        }
    }

    @Test
    public void testGetPlanteID() {
        Plantes expected = new Plantes("Tournesol", 100, 0.00, 0, 50, 25.00, "normal", "images/plante/tournesol.png");

        PlantesDAO plantesDAO = new PlantesDAO();
        Plantes actual = plantesDAO.getPlanteID(1);

        assertEquals(expected.getNom(), actual.getNom());
        assertEquals(expected.getPV(), actual.getPV());
        assertEquals(expected.getAPS(), actual.getAPS(), 0.01);
        assertEquals(expected.getDmg_Atk(), actual.getDmg_Atk());
        assertEquals(expected.getCout(), actual.getCout());
        assertEquals(expected.getSunPS(), actual.getSunPS(), 0.01);
        assertEquals(expected.getEffet(), actual.getEffet());
        assertEquals(expected.getChemin_image(), actual.getChemin_image());
    }

    @Test
    public void testAddPlante() {
        Plantes toAdd = new Plantes("Test Plante", 100, 1.0, 10, 75, 0.0, "test", "images/plante/test.png");

        PlantesDAO plantesDAO = new PlantesDAO();
        List<Plantes> before = plantesDAO.getAllPlantes();
        plantesDAO.addPlante(toAdd);
        List<Plantes> after = plantesDAO.getAllPlantes();

        assertEquals(before.size() + 1, after.size());
        Plantes lastAdded = after.get(after.size() - 1);
        assertEquals(toAdd.getNom(), lastAdded.getNom());
        assertEquals(toAdd.getPV(), lastAdded.getPV());
        assertEquals(toAdd.getAPS(), lastAdded.getAPS(), 0.01);
        assertEquals(toAdd.getDmg_Atk(), lastAdded.getDmg_Atk());
        assertEquals(toAdd.getCout(), lastAdded.getCout());
        assertEquals(toAdd.getSunPS(), lastAdded.getSunPS(), 0.01);
        assertEquals(toAdd.getEffet(), lastAdded.getEffet());
        assertEquals(toAdd.getChemin_image(), lastAdded.getChemin_image());
    }

    @Test
    public void testUpdatePlante() {
        PlantesDAO plantesDAO = new PlantesDAO();
        Plantes original = new Plantes("Test", 100, 1.0, 10, 50, 0.0, "test", "test.png");
        plantesDAO.addPlante(original);
        List<Plantes> plantes = plantesDAO.getAllPlantes();
        int lastId = plantes.size();

        Plantes updater = new Plantes("Updated", 200, 2.0, 20, 100, 1.0, "updated", "updated.png");
        plantesDAO.updatePlante(lastId, updater);

        Plantes updated = plantesDAO.getPlanteID(lastId);
        assertEquals(updater.getNom(), updated.getNom());
        assertEquals(updater.getPV(), updated.getPV());
        assertEquals(updater.getAPS(), updated.getAPS(), 0.01);
        assertEquals(updater.getDmg_Atk(), updated.getDmg_Atk());
        assertEquals(updater.getCout(), updated.getCout());
        assertEquals(updater.getSunPS(), updated.getSunPS(), 0.01);
        assertEquals(updater.getEffet(), updated.getEffet());
        assertEquals(updater.getChemin_image(), updated.getChemin_image());
    }

    @Test
    public void testDeletePlante() {
        PlantesDAO plantesDAO = new PlantesDAO();
        List<Plantes> before = plantesDAO.getAllPlantes();
        int lastId = before.size();

        plantesDAO.deletePlante(lastId);
        List<Plantes> after = plantesDAO.getAllPlantes();

        assertEquals(before.size() - 1, after.size());
        for (int i = 0; i < after.size(); i++) {
            assertEquals(before.get(i).getNom(), after.get(i).getNom());
            assertEquals(before.get(i).getPV(), after.get(i).getPV());
            assertEquals(before.get(i).getAPS(), after.get(i).getAPS(), 0.01);
            assertEquals(before.get(i).getDmg_Atk(), after.get(i).getDmg_Atk());
            assertEquals(before.get(i).getCout(), after.get(i).getCout());
            assertEquals(before.get(i).getSunPS(), after.get(i).getSunPS(), 0.01);
            assertEquals(before.get(i).getEffet(), after.get(i).getEffet());
            assertEquals(before.get(i).getChemin_image(), after.get(i).getChemin_image());
        }
    }
}
