package com.epf.Controlers;

import com.epf.Assets.Zombies;
import com.epf.Controllers.ZombiesController;
import com.epf.Service.SerZombies;
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

public class ZombiesControllerTest {

    @Mock
    private SerZombies serZombies;
    
    private ZombiesController zombiesController;
    private Zombies testZombie;
    private List<Zombies> testZombieList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        zombiesController = new ZombiesController(serZombies);
        testZombie = new Zombies("Zombie de base", 100, 0.80, 10, 0.50, "images/zombie/zombie.png", 1);
        testZombieList = Arrays.asList(
                new Zombies("Zombie de base", 100, 0.80, 10, 0.50, "images/zombie/zombie.png", 1),
                new Zombies("Zombie Cone", 200, 0.80, 10, 0.45, "images/zombie/conehead.png", 1)
        );
    }

    @Test
    public void testGetAllZombies() {
        when(serZombies.getAllZombies()).thenReturn(testZombieList);
        ResponseEntity<List<Zombies>> response = zombiesController.getAllZombies();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(serZombies).getAllZombies();
    }

    @Test
    public void testGetZombieById() {
        when(serZombies.getZombiesById(1)).thenReturn(testZombie);
        ResponseEntity<Zombies> response = zombiesController.getZombieById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Zombie de base", response.getBody().getNom());
        verify(serZombies).getZombiesById(1);
    }

    @Test
    public void testCreateZombie() {
        ResponseEntity<Void> response = zombiesController.createZombie(testZombie);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(serZombies).addZombie(testZombie);
    }

    @Test
    public void testUpdateZombie() {
        ResponseEntity<Void> response = zombiesController.updateZombie(1, testZombie);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(serZombies).updateZombie(1, testZombie);
    }

    @Test
    public void testDeleteZombie() {
        ResponseEntity<Void> response = zombiesController.deleteZombie(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(serZombies).deleteZombie(1);
    }
}