-- Insertion des rôles
INSERT INTO `role` (`designation`) VALUES
                                       ('CHEF_CHANTIER'),
                                       ('OUVRIER'),
                                       ('ADMIN');

-- Insertion des utilisateurs
INSERT INTO `utilisateur` (`role_id`, `pseudo`, `mot_de_passe`) VALUES
                                                                    (1, 'chef1', '$2y$10$YTP6/Q1D2zSmEs5gi0Vx1uED40e0NGTUe0ceqlrmJ8FRciBf824cG'),
                                                                    (1, 'chef2', '$2y$10$YTP6/Q1D2zSmEs5gi0Vx1uED40e0NGTUe0ceqlrmJ8FRciBf824cG'),
                                                                    (2, 'ouvrier1', '$2y$10$YTP6/Q1D2zSmEs5gi0Vx1uED40e0NGTUe0ceqlrmJ8FRciBf824cG'),
                                                                    (2, 'ouvrier2', '$2y$10$YTP6/Q1D2zSmEs5gi0Vx1uED40e0NGTUe0ceqlrmJ8FRciBf824cG'),
                                                                    (1, 'chef3', '$2y$10$YTP6/Q1D2zSmEs5gi0Vx1uED40e0NGTUe0ceqlrmJ8FRciBf824cG'),
                                                                    (2, 'ouvrier3', '$2y$10$YTP6/Q1D2zSmEs5gi0Vx1uED40e0NGTUe0ceqlrmJ8FRciBf824cG');

-- Insertion des consommables
INSERT INTO `consommable` (`nom`) VALUES
                                      ('Clous'),
                                      ('Peinture'),
                                      ('Béton'),
                                      ('Bois'),
                                      ('Acier'),
                                      ('Câbles électriques'),
                                      ('Plaques de plâtre'),
                                      ('Vis'),
                                      ('Ciment');

-- Insertion des tâches
INSERT INTO `tache` (`temps`, `nom`) VALUES
                                         (60, 'Préparation du terrain'),
                                         (120, 'Construction des murs'),
                                         (90, 'Pose des fondations'),
                                         (180, 'Installation des installations électriques'),
                                         (150, 'Finition intérieure'),
                                         (90, 'Planification architecturale'),
                                         (120, 'Pose de câbles électriques'),
                                         (150, 'Pose de plaques de plâtre'),
                                         (60, 'Peinture extérieure'),
                                         (120, 'Finitions électriques'),
                                         (180, 'Pose de vis'),
                                         (90, 'Finitions en ciment');

-- Insertion des chantiers
INSERT INTO `chantier` (`client_id`, `ouvrier_id`, `nom`, `adresse`) VALUES
                                                                         (1, 3, 'Rénovation Maison Dupont', '123 Rue Principale'),
                                                                         (2, 4, 'Construction Immeuble Martin', '456 Avenue des Champs'),
                                                                         (3, 5, 'Extension Villa Dubois', '789 Boulevard des Roses');

-- Insertion des opérations
INSERT INTO `operation` (`chantier_id`, `date`, `ouvrier_id`, `tache_id`, `nom`) VALUES
                                                                                     (1, '2024-03-22', 3, 1, 'Préparation du terrain Chantier A'),
                                                                                     (1, '2024-03-23', 3, 2, 'Construction des murs Chantier A'),
                                                                                     (2, '2024-03-24', 4, 3, 'Pose des fondations Chantier B'),
                                                                                     (2, '2024-03-25', 4, 4, 'Installation électrique Chantier B'),
                                                                                     (3, '2024-03-26', 5, 5, 'Finition intérieure Villa Dubois');

-- Insertion des associations tâche-consommable
INSERT INTO `tache_consommable` (`tache_id`, `consommable_id`) VALUES
                                                                   (1, 1),
                                                                   (2, 4),
                                                                   (2, 5),
                                                                   (3, 3),
                                                                   (3, 4),
                                                                   (4, 5),
                                                                   (5, 2),
                                                                   (6, 9),
                                                                   (7, 6),
                                                                   (8, 7),
                                                                   (9, 8),
                                                                   (10, 6),
                                                                   (11, 9),
                                                                   (12, 5);