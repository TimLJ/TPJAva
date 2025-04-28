package com.epf.Service;

import com.epf.Assets.Zombies;

import java.util.List;

public interface SerZombies {
    List<Zombies> getAllZombies();
    Zombies getZombiesById(int id);
    void addZombie(Zombies zombie);
    void updateZombie(int id, Zombies zombie);
    void deleteZombie(int id);

}
