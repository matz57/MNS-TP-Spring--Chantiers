package edu.jmatz.tpspringchantiers.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.jmatz.tpspringchantiers.views.UtilisateurView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UtilisateurView.class)
    protected Integer id;

    @Column(unique = true, length = 50)
    @Length(min = 3, max = 50, message = "Le pseudo doit avoir entre 3 et 50 caractères")
    @NotNull(message = "Le pseudo est obligatoire")
    @JsonView(UtilisateurView.class)
    protected String pseudo;

    @Column
    @NotNull(message = "Le mot de passe est obligatoire")
    @JsonView(UtilisateurView.class)
    protected String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonView(UtilisateurView.class)
    protected Role role;
}