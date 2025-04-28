package com.epf.Service;

import com.epf.Assets.Maps;

import java.util.List;

public interface SerMaps {
    List<Maps> getAllMaps();
    Maps getMapsById(int id);
    void addMaps(Maps Maps);
    void updateMaps(int id, Maps Maps);
    void deleteMaps(int id);
}
