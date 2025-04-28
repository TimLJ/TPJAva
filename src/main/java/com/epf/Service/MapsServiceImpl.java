package com.epf.Service;

import com.epf.Assets.Maps;
import com.epf.Persistance.MapsDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapsServiceImpl implements SerMaps {
    private final MapsDAO mapsDAO;

    public MapsServiceImpl(MapsDAO mapsDAO) {
        this.mapsDAO = mapsDAO;
    }

    @Override
    public List<Maps> getAllMaps() {
        return mapsDAO.getAllMaps();
    }

    @Override
    public Maps getMapsById(int id) {
        return mapsDAO.getMapID(id);
    }

    @Override
    public void addMaps(Maps maps) {
        mapsDAO.addMap(maps);
    }

    @Override
    public void updateMaps(int id, Maps maps) {
        mapsDAO.updateMap(id, maps);
    }

    @Override
    public void deleteMaps(int id) {
        mapsDAO.deleteMap(id);
    }
}
