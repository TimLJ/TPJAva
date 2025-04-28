package com.epf.Service;

import com.epf.Assets.Plantes;
import com.epf.Persistance.PlantesDAO;
import com.epf.Service.PlantesServiceImpl;
import com.epf.Service.SerPlantes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SerPlantesTest {

    @Mock
    private PlantesDAO plantesDAO;

    private SerPlantes serPlantes;
    private Plantes testPlante;
    private List<Plantes> testPlanteList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        serPlantes = new PlantesServiceImpl(plantesDAO);
        testPlante = new Plantes("Tournesol", 100, 0.00, 0, 50, 25.00, "normal", "images/plante/tournesol.png");
        testPlanteList = Arrays.asList(
                new Plantes("Tournesol", 100, 0.00, 0, 50, 25.00, "normal", "images/plante/tournesol.png"),
                new Plantes("Pois Tireur", 150, 1.50, 20, 100, 0.00, "normal", "images/plante/poistireur.png")
        );
    }

    @Test
    public void testGetAllPlantes() {
        when(plantesDAO.getAllPlantes()).thenReturn(testPlanteList);
        List<Plantes> result = serPlantes.getAllPlantes();
        assertEquals(2, result.size());
        verify(plantesDAO).getAllPlantes();
    }

    @Test
    public void testGetPlanteById() {
        when(plantesDAO.getPlanteID(1)).thenReturn(testPlante);
        Plantes result = serPlantes.getPlanteById(1);
        assertEquals("Tournesol", result.getNom());
        verify(plantesDAO).getPlanteID(1);
    }

    @Test
    public void testAddPlante() {
        serPlantes.addPlante(testPlante);
        verify(plantesDAO).addPlante(testPlante);
    }

    @Test
    public void testUpdatePlante() {
        serPlantes.updatePlante(1, testPlante);
        verify(plantesDAO).updatePlante(1, testPlante);
    }

    @Test
    public void testDeletePlante() {
        serPlantes.deletePlante(1);
        verify(plantesDAO).deletePlante(1);
    }
}
