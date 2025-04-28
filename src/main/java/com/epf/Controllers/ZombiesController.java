package com.epf.Controllers;

import com.epf.Assets.Zombies;
import com.epf.Service.SerZombies;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zombies")
public class ZombiesController {

    private final SerZombies zombiesService;

    public ZombiesController(SerZombies zombiesService) {
        this.zombiesService = zombiesService;
    }

    @GetMapping
    public ResponseEntity<List<Zombies>> getAllZombies() {
        List<Zombies> zombies = zombiesService.getAllZombies();
        return ResponseEntity.ok(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zombies> getZombieById(@PathVariable int id) {
        Zombies zombie = zombiesService.getZombiesById(id);
        return ResponseEntity.ok(zombie);
    }

    @PostMapping
    public ResponseEntity<Void> createZombie(@RequestBody Zombies zombie) {
        zombiesService.addZombie(zombie);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZombie(@PathVariable int id, @RequestBody Zombies zombie) {
        zombiesService.updateZombie(id, zombie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable int id) {
        zombiesService.deleteZombie(id);
        return ResponseEntity.ok().build();
    }
}