package edu.jmatz.tpspringchantiers.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.jmatz.tpspringchantiers.views.ChantierView;
import edu.jmatz.tpspringchantiers.views.ConsommableView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ChantierView.class)
    protected Integer id;

    @Column(length = 100)
    @Length(min = 3, max = 100, message = "Le nom du chantier doit avoir entre 3 et 100 caractères")
    @NotNull(message = "Le nom du chantier est obligatoire")
    @JsonView(ChantierView.class)
    protected String nom;

    @Column(length = 150)
    @Length(min = 5, max = 150, message = "L'adresse du chantier doit avoir entre 5 et 150 caractères")
    @NotNull(message = "L'adresse du chantier est obligatoire")
    @JsonView(ChantierView.class)
    protected String adresse;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonView(ChantierView.class)
    protected Utilisateur client;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
    @JsonView(ChantierView.class)
    protected Utilisateur ouvrier;

    @OneToMany(mappedBy = "chantier")
    @JsonView(ChantierView.class)
    protected List<Operation> operations = new ArrayList<>();
}