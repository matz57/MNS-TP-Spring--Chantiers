package edu.jmatz.tpspringchantiers.dao;

import edu.jmatz.tpspringchantiers.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {
    List<Operation> findByNom(String nom);
}
