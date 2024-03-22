package edu.jmatz.tpspringchantiers.dao;

import edu.jmatz.tpspringchantiers.models.Chantier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChantierDao extends JpaRepository<Chantier, Integer> {
    List<Chantier> findByNom(String nom);
}
