package com.epf.Service;

import com.epf.Assets.Plantes;
import com.epf.Persistance.PlantesDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantesServiceImpl implements SerPlantes {
    private final PlantesDAO plantesDAO;

    public PlantesServiceImpl(PlantesDAO plantesDAO) {
        this.plantesDAO = plantesDAO;
    }

    @Override
    public List<Plantes> getAllPlantes() {
        return plantesDAO.getAllPlantes();
    }

    @Override
    public Plantes getPlanteById(int id) {
        return plantesDAO.getPlanteID(id);
    }

    @Override
    public void addPlante(Plantes plante) {
        plantesDAO.addPlante(plante);
    }

    @Override
    public void updatePlante(int id, Plantes plante) {
        plantesDAO.updatePlante(id, plante);
    }

    @Override
    public void deletePlante(int id) {
        plantesDAO.deletePlante(id);
    }
}
