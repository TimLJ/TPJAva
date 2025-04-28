package com.epf.Persistance;
import com.epf.Assets.Maps;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MapsDAO extends DAO {
    public List<Maps> getAllMaps() {
        List<Maps> maps;

        maps = jdbcTemplate.query("SELECT * from MAP",(rs, rowNum) ->
                new Maps(rs.getInt("ligne"),rs.getInt("colonne"),rs.getString("chemin_image"))
                );
        return maps;
    }

    public Maps getMapID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM MAP WHERE id_map =?",
                new Object[]{id},
                (rs, rowNum) -> new Maps(rs.getInt("Ligne"),rs.getInt("colonne"),rs.getString("chemin_image")));
    }

    public void addMap(Maps map) {
        String sql = "INSERT INTO MAP (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    public void updateMap(int id, Maps map) {
        String sql = "UPDATE MAP SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image(), id);
    }

    public void deleteMap(int id) {
        String sql = "DELETE FROM MAP WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }

}
