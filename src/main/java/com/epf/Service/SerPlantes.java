package com.epf.Service;

import com.epf.Assets.Plantes;

import java.util.List;

public interface SerPlantes {
    List<Plantes> getAllPlantes();
    Plantes getPlanteById(int id);
    void addPlante(Plantes plante);
    void updatePlante(int id, Plantes plante);
    void deletePlante(int id);
}
