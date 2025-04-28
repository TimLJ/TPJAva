package com.epf.Service;

import com.epf.Assets.Zombies;
import com.epf.Persistance.ZombiesDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class serZombiesTest {

    @Mock
    private ZombiesDAO zombieDAO;

    private SerZombies serZombies;
    private Zombies testZombie;
    private List<Zombies> testZombieList;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        serZombies = new ZombiesServiceImpl(zombieDAO);
        testZombie = new Zombies("Zombie de base", 100, 0.80, 10, 0.50, "images/zombie/zombie.png", 1);
        testZombieList = Arrays.asList(
                new Zombies("Zombie de base", 100, 0.80, 10, 0.50, "images/zombie/zombie.png", 1),
                new Zombies("Zombie Cone", 200, 0.80, 10, 0.45, "images/zombie/conehead.png", 1)
        );
    }

    @Test
    public void testGetAllZombies() {
        when(zombieDAO.getAllZombies()).thenReturn(testZombieList);
        List<Zombies> result = serZombies.getAllZombies();
        assertEquals(2, result.size());
        verify(zombieDAO).getAllZombies();
    }

    @Test
    public void testGetZombieById() {
        when(zombieDAO.getZombieID(1)).thenReturn(testZombie);
        Zombies result = serZombies.getZombiesById(1);
        assertEquals("Zombie de base", result.getNom());
        assertEquals(100, result.getPV());
        verify(zombieDAO).getZombieID(1);
    }

    @Test
    public void testAddZombie() {
        serZombies.addZombie(testZombie);
        verify(zombieDAO).addZombie(testZombie);
    }

    @Test
    public void testUpdateZombie() {
        serZombies.updateZombie(1, testZombie);
        verify(zombieDAO).updateZombie(1, testZombie);
    }

    @Test
    public void testDeleteZombie() {
        serZombies.deleteZombie(1);
        verify(zombieDAO).deleteZombie(1);
    }
}
