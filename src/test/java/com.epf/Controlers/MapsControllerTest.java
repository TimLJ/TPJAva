package com.epf.Controlers;

import com.epf.Assets.Maps;
import com.epf.Controllers.MapsController;
import com.epf.Service.SerMaps;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MapsControllerTest {

    @Mock
    private SerMaps mapsService;

    private MapsController mapsController;
    private Maps testMap;
    private List<Maps> testMapList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mapsController = new MapsController(mapsService);
        testMap = new Maps(5, 9, "images/map/gazon.png");
        testMapList = Arrays.asList(
                new Maps(5, 9, "images/map/gazon.png"),
                new Maps(6, 9, "images/map/gazon.png")
        );
    }

    @Test
    public void testGetAllMaps() {
        when(mapsService.getAllMaps()).thenReturn(testMapList);
        ResponseEntity<List<Maps>> result = mapsController.getAllMaps();
        assertEquals(2, result.getBody().size());
        verify(mapsService).getAllMaps();
    }

    @Test
    public void testGetMapById() {
        when(mapsService.getMapsById(1)).thenReturn(testMap);
        ResponseEntity<Maps> response = mapsController.getMapById(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(testMap, response.getBody());
        verify(mapsService).getMapsById(1);
    }

    @Test
    public void testCreateMap() {
        ResponseEntity<Void> response = mapsController.createMap(testMap);
        assertEquals(200, response.getStatusCodeValue());
        verify(mapsService).addMaps(testMap);
    }

    @Test
    public void testUpdateMap() {
        ResponseEntity<Void> response = mapsController.updateMap(1, testMap);
        assertEquals(200, response.getStatusCodeValue());
        verify(mapsService).updateMaps(1, testMap);
    }

    @Test
    public void testDeleteMap() {
        ResponseEntity<Void> response = mapsController.deleteMap(1);
        assertEquals(200, response.getStatusCodeValue());
        verify(mapsService).deleteMaps(1);
    }
}
