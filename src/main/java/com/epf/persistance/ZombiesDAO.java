package com.epf.persistance;

import com.epf.Assets.Zombies;
import com.epf.Assets.Zombies;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ZombiesDAO extends DAO {

    // READ - Récupérer tous les zombies
    public List<Zombies> getAllZombies() {
        return jdbcTemplate.query("SELECT * FROM ZOMBIES", (rs, rowNum) ->
                new Zombies(rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getInt("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("vitesse_de_deplacement"),
                        rs.getString("chemin_image"),
                        rs.getInt("id_map"))
        );
    }

    // READ - Récupérer un zombie par ID
    public Zombies getZombieID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ZOMBIES WHERE id_zombie = ?",
                new Object[]{id},
                (rs, rowNum) -> new Zombies(rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getInt("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("vitesse_de_deplacement"),
                        rs.getString("chemin_image"),
                        rs.getInt("id_map"))
        );
    }

    // CREATE - Ajouter un zombie
    public void addZombie(Zombies zombie) {
        String sql = "INSERT INTO ZOMBIES (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPV(), zombie.getAPS(), zombie.getDmg_Atk(), zombie.getVit(), zombie.getChemin_image(), zombie.getIDMap());
    }

    // UPDATE - Mettre à jour un zombie
    public void updateZombie(int id, Zombies zombie) {
        String sql = "UPDATE ZOMBIES SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPV(), zombie.getAPS(), zombie.getDmg_Atk(), zombie.getVit(), zombie.getChemin_image(), zombie.getIDMap(), id);
    }

    // DELETE - Supprimer un zombie
    public void deleteZombie(int id) {
        String sql = "DELETE FROM ZOMBIES WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }
}
