package edu.jmatz.tpspringchantiers.controllers;

import edu.jmatz.tpspringchantiers.dao.ChantierDao;
import edu.jmatz.tpspringchantiers.dao.OperationDao;
import edu.jmatz.tpspringchantiers.models.Chantier;
import edu.jmatz.tpspringchantiers.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chantiers")
public class ChantierController {

    @Autowired
    private ChantierDao chantierDao;

    @Autowired
    private OperationDao operationDao;

    @GetMapping("/list")
    @Secured({"ROLE_CHEF_CHANTIER", "ROLE_ADMIN"})
    public List<Chantier> listerChantiers() {
        return chantierDao.findAll();
    }

    @GetMapping("/{id}/temps")
    @Secured({"ROLE_CHEF_CHANTIER", "ROLE_ADMIN"})
    public long tempsTotalChantier(@PathVariable Integer id) {
        Chantier chantier = chantierDao.findById(id).orElse(null);
        if (chantier == null) {
            return -1;
        }

        List<Operation> operations = operationDao.findAll();
        long tempsTotal = 0;
        for (Operation operation : operations) {
            if (operation.getChantier().equals(chantier)) {
                tempsTotal += operation.getTache().getTemps();
            }
        }

        return tempsTotal;
    }
}
