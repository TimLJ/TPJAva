package com.epf.Service;

import com.epf.Assets.Maps;
import com.epf.Persistance.MapsDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SerMapsTest {

    @Mock
    private MapsDAO mapsDAO;

    private SerMaps serMaps;
    private Maps testMap;
    private List<Maps> testMapList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        serMaps = new MapsServiceImpl(mapsDAO);
        testMap = new Maps(5, 9, "images/map/gazon.png");
        testMapList = Arrays.asList(
                new Maps(5, 9, "images/map/gazon.png"),
                new Maps(6, 9, "images/map/gazon.png")
        );
    }

    @Test
    public void testGetAllMaps() {
        when(mapsDAO.getAllMaps()).thenReturn(testMapList);
        List<Maps> result = serMaps.getAllMaps();
        assertEquals(2, result.size());
        verify(mapsDAO).getAllMaps();
    }

    @Test
    public void testGetMapById() {
        when(mapsDAO.getMapID(1)).thenReturn(testMap);
        Maps result = serMaps.getMapsById(1);
        assertEquals(5, result.getLigne());
        assertEquals(9, result.getColonne());
        verify(mapsDAO).getMapID(1);
    }

    @Test
    public void testAddMap() {
        serMaps.addMaps(testMap);
        verify(mapsDAO).addMap(testMap);
    }

    @Test
    public void testUpdateMap() {
        serMaps.updateMaps(1, testMap);
        verify(mapsDAO).updateMap(1, testMap);
    }

    @Test
    public void testDeleteMap() {
        serMaps.deleteMaps(1);
        verify(mapsDAO).deleteMap(1);
    }
}