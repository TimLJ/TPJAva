package com.epf.Controllers;

import com.epf.Assets.Plantes;
import com.epf.Service.SerPlantes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantes")
public class PlantesController {

    private final SerPlantes plantesService;

    public PlantesController(SerPlantes plantesService) {
        this.plantesService = plantesService;
    }

    @GetMapping
    public ResponseEntity<List<Plantes>> getAllPlantes() {
        return ResponseEntity.ok(plantesService.getAllPlantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantes> getPlanteById(@PathVariable int id) {
        Plantes plante = plantesService.getPlanteById(id);
        return ResponseEntity.ok(plante);
    }

    @PostMapping
    public ResponseEntity<Void> createPlante(@RequestBody Plantes plante) {
        plantesService.addPlante(plante);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlante(@PathVariable int id, @RequestBody Plantes plante) {
        plantesService.updatePlante(id, plante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlante(@PathVariable int id) {
        plantesService.deletePlante(id);
        return ResponseEntity.ok().build();
    }
}