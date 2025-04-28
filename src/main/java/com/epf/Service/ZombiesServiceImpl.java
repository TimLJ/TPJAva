package com.epf.Service;

import com.epf.Assets.Zombies;
import com.epf.Persistance.ZombiesDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombiesServiceImpl implements SerZombies {
    private final ZombiesDAO zombiesDAO;

    public ZombiesServiceImpl(ZombiesDAO zombiesDAO) {
        this.zombiesDAO = zombiesDAO;
    }

    @Override
    public List<Zombies> getAllZombies() {
        return zombiesDAO.getAllZombies();
    }

    @Override
    public Zombies getZombiesById(int id) {
        return zombiesDAO.getZombieID(id);
    }

    @Override
    public void addZombie(Zombies zombie) {
        zombiesDAO.addZombie(zombie);
    }

    @Override
    public void updateZombie(int id, Zombies zombie) {
        zombiesDAO.updateZombie(id, zombie);
    }

    @Override
    public void deleteZombie(int id) {
        zombiesDAO.deleteZombie(id);
    }
}