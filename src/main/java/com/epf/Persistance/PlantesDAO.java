package com.epf.Persistance;

import com.epf.Assets.Plantes;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PlantesDAO extends DAO {

    // READ - Récupérer toutes les plantes
    public List<Plantes> getAllPlantes() {
        return jdbcTemplate.query("SELECT * FROM Plante", (rs, rowNum) ->
                new Plantes(rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getInt("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("cout"),
                        rs.getInt("soleil_par_seconde"),
                        rs.getString("effet"),
                        rs.getString("chemin_image"))
        );
    }

    // READ - Récupérer une plante par ID
    public Plantes getPlanteID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Plante WHERE id_plante = ?",
                new Object[]{id},
                (rs, rowNum) -> new Plantes(rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getInt("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("cout"),
                        rs.getInt("soleil_par_seconde"),
                        rs.getString("effet"),
                        rs.getString("chemin_image"))
        );
    }

    // CREATE - Ajouter une plante
    public void addPlante(Plantes plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPV(), plante.getAPS(), plante.getDmg_Atk(), plante.getCout(), plante.getSunPS(), plante.getEffet(), plante.getChemin_image());
    }

    // UPDATE - Mettre à jour une plante
    public void updatePlante(int id, Plantes plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPV(), plante.getAPS(), plante.getDmg_Atk(), plante.getCout(), plante.getSunPS(), plante.getEffet(), plante.getChemin_image(), id);
    }

    // DELETE - Supprimer une plante
    public void deletePlante(int id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}

