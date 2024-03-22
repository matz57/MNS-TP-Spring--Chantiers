package edu.jmatz.tpspringchantiers.models;

import com.fasterxml.jackson.annotation.JsonView;
import edu.jmatz.tpspringchantiers.views.RoleView;
import edu.jmatz.tpspringchantiers.views.TacheView;
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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(RoleView.class)
    protected Integer id;

    @Column(unique = true)
    @NotNull(message = "La désignation du rôle est obligatoire")
    @JsonView(RoleView.class)
    protected String designation;
}