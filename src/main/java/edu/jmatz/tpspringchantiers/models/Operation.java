package edu.jmatz.tpspringchantiers.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.jmatz.tpspringchantiers.views.OperationView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(OperationView.class)
    protected Integer id;

    @Column(length = 100)
    @Length(min = 3, max = 100, message = "Le nom de l'opération doit avoir entre 3 et 100 caractères")
    @NotNull(message = "Le nom de l'opération est obligatoire")
    @JsonView(OperationView.class)
    protected String nom;

    @Column
    @NotNull(message = "La date de l'opération est obligatoire")
    @JsonView(OperationView.class)
    protected LocalDate date;

    @ManyToOne
    @JoinColumn(name = "chantier_id")
    @JsonView(OperationView.class)
    protected Chantier chantier;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    @JsonView(OperationView.class)
    protected Tache tache;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
    @JsonView(OperationView.class)
    protected Utilisateur ouvrier;
}