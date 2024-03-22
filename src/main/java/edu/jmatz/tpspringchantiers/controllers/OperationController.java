package edu.jmatz.tpspringchantiers.controllers;

import edu.jmatz.tpspringchantiers.dao.OperationDao;
import edu.jmatz.tpspringchantiers.dao.UtilisateurDao;
import edu.jmatz.tpspringchantiers.models.Operation;
import edu.jmatz.tpspringchantiers.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private OperationDao operationDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @GetMapping("/employe/{employeId}")
    @Secured({"ROLE_CHEF_CHANTIER", "ROLE_OUVRIER", "ROLE_ADMIN"})
    public List<Operation> listerOperationsEmploye(@PathVariable Integer employeId) {
        Utilisateur employe = utilisateurDao.findById(employeId).orElse(null);
        if (employe == null) {
            return new ArrayList<>();
        }

        List<Operation> operations = operationDao.findAll();
        List<Operation> operationsEmploye = new ArrayList<>();
        for (Operation operation : operations) {
            if (operation.getOuvrier().equals(employe)) {
                operationsEmploye.add(operation);
            }
        }

        return operationsEmploye;
    }
}