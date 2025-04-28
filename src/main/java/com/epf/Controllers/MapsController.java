package com.epf.Controllers;

import com.epf.Assets.Maps;
import com.epf.Service.SerMaps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maps")
public class MapsController {

    private final SerMaps mapsService;

    public MapsController(SerMaps mapsService) {
        this.mapsService = mapsService;
    }

    @GetMapping
    public ResponseEntity<List<Maps>> getAllMaps() {
        List<Maps> maps = mapsService.getAllMaps();
        return ResponseEntity.ok(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maps> getMapById(@PathVariable int id) {
        Maps map = mapsService.getMapsById(id);
        return ResponseEntity.ok(map);
    }

    @PostMapping
    public ResponseEntity<Void> createMap(@RequestBody Maps map) {
        mapsService.addMaps(map);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMap(@PathVariable int id, @RequestBody Maps map) {
        mapsService.updateMaps(id, map);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable int id) {
        mapsService.deleteMaps(id);
        return ResponseEntity.ok().build();
    }
}