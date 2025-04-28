package com.epf.Controlers;

import com.epf.Assets.Plantes;
import com.epf.Controllers.PlantesController;
import com.epf.Service.SerPlantes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlantesControllerTest {

    @Mock
    private SerPlantes serPlantes;

    private PlantesController plantesController;
    private Plantes testPlante;
    private List<Plantes> testPlanteList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        plantesController = new PlantesController(serPlantes);
        testPlante = new Plantes("Tournesol", 100, 0.00, 0, 50, 25.00, "normal", "images/plante/tournesol.png");
        testPlanteList = Arrays.asList(
                new Plantes("Tournesol", 100, 0.00, 0, 50, 25.00, "normal", "images/plante/tournesol.png"),
                new Plantes("Pois Tireur", 150, 1.50, 20, 100, 0.00, "normal", "images/plante/poistireur.png")
        );
    }

    @Test
    public void testGetAllPlantes() {
        when(serPlantes.getAllPlantes()).thenReturn(testPlanteList);
        ResponseEntity<List<Plantes>> response = plantesController.getAllPlantes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(serPlantes).getAllPlantes();
    }

    @Test
    public void testGetPlanteById() {
        when(serPlantes.getPlanteById(1)).thenReturn(testPlante);
        ResponseEntity<Plantes> response = plantesController.getPlanteById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tournesol", response.getBody().getNom());
        verify(serPlantes).getPlanteById(1);
    }

    @Test
    public void testCreatePlante() {
        ResponseEntity<Void> response = plantesController.createPlante(testPlante);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(serPlantes).addPlante(testPlante);
    }

    @Test
    public void testUpdatePlante() {
        ResponseEntity<Void> response = plantesController.updatePlante(1, testPlante);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(serPlantes).updatePlante(1, testPlante);
    }

    @Test
    public void testDeletePlante() {
        ResponseEntity<Void> response = plantesController.deletePlante(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(serPlantes).deletePlante(1);
    }
}
