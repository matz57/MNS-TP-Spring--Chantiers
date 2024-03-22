package edu.jmatz.tpspringchantiers.dao;

import edu.jmatz.tpspringchantiers.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheDao extends JpaRepository<Tache, Integer> {
    List<Tache> findByNom(String nom);
}
