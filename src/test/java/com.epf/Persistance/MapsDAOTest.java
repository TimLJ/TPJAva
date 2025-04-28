package com.epf.Persistance;

import com.epf.Assets.Maps;
import com.epf.Persistance.MapsDAO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapsDAOTest {

    @Test
    public void testGetAllMaps() {
        List<Maps> expected = Arrays.asList(
                new Maps(5, 9, "images/map/gazon.png"),
                new Maps(6, 9, "images/map/gazon.png"),
                new Maps(4, 8, "images/map/gazon.png")
        );

        MapsDAO mapsDAO = new MapsDAO();
        List<Maps> actual = mapsDAO.getAllMaps();

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getLigne(), actual.get(i).getLigne());
            assertEquals(expected.get(i).getColonne(), actual.get(i).getColonne());
            assertEquals(expected.get(i).getChemin_image(), actual.get(i).getChemin_image());
        }
    }

    @Test
    public void testGetMapID() {
        Maps expeced = new Maps(5,9,"images/map/gazon.png");

        MapsDAO mapsDAO = new MapsDAO();
        Maps actual = mapsDAO.getMapID(1);

        assertEquals(expeced.getLigne(),actual.getLigne());
        assertEquals(expeced.getColonne(),actual.getColonne());
        assertEquals(expeced.getChemin_image(),actual.getChemin_image());
    }

    @Test
    public void testAddMap() {
        Maps toAdd = new Maps(4, 4, "images/map/gazon.png");

        MapsDAO mapsDAO = new MapsDAO();
        List<Maps> témoin = mapsDAO.getAllMaps();
        mapsDAO.addMap(toAdd);
        List<Maps> modifié = mapsDAO.getAllMaps();

        assertEquals(témoin.size() + 1, modifié.size());
        Maps lastAdded = modifié.get(modifié.size() - 1);
        assertEquals(toAdd.getLigne(), lastAdded.getLigne());
        assertEquals(toAdd.getColonne(), lastAdded.getColonne());
        assertEquals(toAdd.getChemin_image(), lastAdded.getChemin_image());
    }
    
    @Test
    public void testDeleteMap() {
        MapsDAO mapsDAO = new MapsDAO();
        List<Maps> before = mapsDAO.getAllMaps();
        int lastId = before.size();

        mapsDAO.deleteMap(lastId);
        List<Maps> after = mapsDAO.getAllMaps();

        assertEquals(before.size() - 1, after.size());
        for (int i = 0; i < after.size(); i++) {
            assertEquals(before.get(i).getLigne(), after.get(i).getLigne());
            assertEquals(before.get(i).getColonne(), after.get(i).getColonne());
            assertEquals(before.get(i).getChemin_image(), after.get(i).getChemin_image());
        }
    }
    
    @Test
    public void testUpdateMap() {
        Maps testMap = new Maps(1, 1, "images/map/test.png");
        MapsDAO mapsDAO = new MapsDAO();
        
        mapsDAO.addMap(testMap);
        List<Maps> cartes = mapsDAO.getAllMaps();
        int lastId = cartes.size(); // Ou mieux : récupérer l'ID réel

        Maps updater = new Maps(2, 2, "images/map/gazon.png");
        try {
            mapsDAO.updateMap(lastId, updater);

            Maps updated = mapsDAO.getMapID(lastId);
            assertEquals(updater.getLigne(), updated.getLigne());
            assertEquals(updater.getColonne(), updated.getColonne());
            assertEquals(updater.getChemin_image(), updated.getChemin_image());
        } finally {
            mapsDAO.deleteMap(lastId);
        }

    }
}
