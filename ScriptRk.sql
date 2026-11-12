-- =====================================================
-- Gestion de vente de voitures - PostgreSQL
-- Généré à partir du MCD Looping (capture)
-- =====================================================

-- ---------- Tables de référence ----------

CREATE TABLE type_carburant (
    id_carburant   VARCHAR(10) PRIMARY KEY,
    carburant      VARCHAR(50) NOT NULL
);

CREATE TABLE marque (
    id_marque      VARCHAR(50) PRIMARY KEY,
    nom_marque     VARCHAR(50) NOT NULL
);

CREATE TABLE categorie (
    id_categorie   VARCHAR(50) PRIMARY KEY,
    nom_categorie  VARCHAR(50) NOT NULL
);

CREATE TABLE role (
    id_role        VARCHAR(50) PRIMARY KEY,
    nom_role       VARCHAR(50) NOT NULL
);

CREATE TABLE mode_payement (
    id_mode_payement VARCHAR(50) PRIMARY KEY,
    type_payement    VARCHAR(50) NOT NULL
);

CREATE TABLE type_mouvement (
    id_type_mvt    VARCHAR(50) PRIMARY KEY,
    statut_mvt     VARCHAR(20) NOT NULL
);

CREATE TABLE mouvement_reservation (
    id_mvt_reservation VARCHAR(50) PRIMARY KEY,
    type_mvt           VARCHAR(50) NOT NULL
);

CREATE TABLE categorie_depense (
    id_categorie_depense VARCHAR(50) PRIMARY KEY,
    nom_categorie        VARCHAR(50) NOT NULL,
    description          VARCHAR(100)
);

-- ---------- Caractéristiques voiture ----------

CREATE TABLE caracteristique_voiture (
    id_detail       VARCHAR(10) PRIMARY KEY,
    annee           INTEGER,
    consommation    NUMERIC(15,2),
    nombre_porte    INTEGER,
    nombre_place    INTEGER,
    model           VARCHAR(50),
    puissance       VARCHAR(50),
    kilometrage     NUMERIC(10,2),   -- NUMERIC(5,2) dans le MCD : trop petit pour un kilométrage
    couleur         VARCHAR(20),
    date_creation   DATE DEFAULT CURRENT_DATE,
    id_carburant    VARCHAR(10) REFERENCES type_carburant(id_carburant),  -- Asso 6
    id_marque       VARCHAR(50) REFERENCES marque(id_marque),             -- Asso 8
    id_categorie    VARCHAR(50) REFERENCES categorie(id_categorie)        -- Asso 9
);

-- ---------- Voiture ----------

CREATE TABLE voiture (
    id_voiture      VARCHAR(50) PRIMARY KEY,
    description     VARCHAR(50),
    date_ajoute     DATE DEFAULT CURRENT_DATE,
    prix_achat      NUMERIC(15,2)
);

CREATE TABLE detail_voiture (
    id_detail_voiture VARCHAR(50) PRIMARY KEY,
    id_voiture        VARCHAR(50) NOT NULL REFERENCES voiture(id_voiture),                 -- Asso 4
    id_detail         VARCHAR(10) NOT NULL REFERENCES caracteristique_voiture(id_detail)   -- Asso 5
);

CREATE TABLE voiture_media (
    id_media        VARCHAR(50) PRIMARY KEY,
    url             VARCHAR(100) NOT NULL,
    id_voiture      VARCHAR(50) NOT NULL REFERENCES voiture(id_voiture)                    -- Asso 18_1
);

-- ---------- Personnes ----------

CREATE TABLE personne (
    id_personne     VARCHAR(50) PRIMARY KEY,
    nom             VARCHAR(50) NOT NULL,
    prenom          VARCHAR(50),
    email           VARCHAR(50) UNIQUE,
    mot_de_passe    VARCHAR(50),
    id_role         VARCHAR(50) NOT NULL REFERENCES role(id_role)                          -- Asso 17
);

-- ---------- Réservation ----------

CREATE TABLE reservation (
    id_reservation      VARCHAR(50) PRIMARY KEY,
    date_reservation    DATE NOT NULL DEFAULT CURRENT_DATE,
    date_expiration     DATE,
    id_voiture          VARCHAR(50) NOT NULL REFERENCES voiture(id_voiture),                        -- Asso 15
    id_personne         VARCHAR(50) NOT NULL REFERENCES personne(id_personne),                      -- Asso 18
    id_mvt_reservation  VARCHAR(50) NOT NULL REFERENCES mouvement_reservation(id_mvt_reservation),  -- Asso 14
    CHECK (date_expiration IS NULL OR date_expiration >= date_reservation)
);

-- ---------- Vente & paiement ----------

CREATE TABLE vente (
    id_vente        VARCHAR(50) PRIMARY KEY,
    prix_vente      NUMERIC(15,2) NOT NULL,
    date_vente      DATE NOT NULL DEFAULT CURRENT_DATE,
    id_voiture      VARCHAR(50) NOT NULL REFERENCES voiture(id_voiture)                    -- Asso 23
);

CREATE TABLE payement (
    id_payement         VARCHAR(50) PRIMARY KEY,
    montant             NUMERIC(15,2) NOT NULL,
    date_payement       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reference_payement  VARCHAR(50),     -- corrigé : « reference_payemnt » dans le MCD
    id_vente            VARCHAR(50) NOT NULL REFERENCES vente(id_vente),                   -- Asso 19_1
    id_mode_payement    VARCHAR(50) NOT NULL REFERENCES mode_payement(id_mode_payement)    -- Asso 20_1
);

-- ---------- Mouvement de stock ----------

CREATE TABLE mouvement_stock (
    id_mvt_stock    VARCHAR(50) PRIMARY KEY,
    quantite        INTEGER NOT NULL,
    date_mouvement  DATE NOT NULL DEFAULT CURRENT_DATE,
    id_voiture      VARCHAR(50) NOT NULL REFERENCES voiture(id_voiture),                   -- Asso 19
    id_type_mvt     VARCHAR(50) NOT NULL REFERENCES type_mouvement(id_type_mvt),           -- Asso 20
    id_personne     VARCHAR(50) NOT NULL REFERENCES personne(id_personne)                  -- Asso 21
);

-- ---------- Dépenses ----------

CREATE TABLE depense (
    id_depense           VARCHAR(50) PRIMARY KEY,
    montant              NUMERIC(15,2) NOT NULL,   -- VARCHAR(50) dans le MCD : numérique pour les calculs
    date_depense         DATE NOT NULL DEFAULT CURRENT_DATE,
    description          VARCHAR(100),
    id_categorie_depense VARCHAR(50) NOT NULL REFERENCES categorie_depense(id_categorie_depense)  -- Asso 24
);

-- ---------- Tables indépendantes ----------

CREATE TABLE faq (
    id_faq      VARCHAR(50) PRIMARY KEY,
    question    TEXT NOT NULL,
    reponse     TEXT,
    statut      VARCHAR(30)
);

CREATE TABLE contact (
    id_contact           VARCHAR(50) PRIMARY KEY,
    nom                  VARCHAR(50),
    telephone            VARCHAR(50),
    telephone_secondaire VARCHAR(50),
    email                VARCHAR(50),
    address              VARCHAR(50),
    whatsapp             VARCHAR(50),
    maps                 VARCHAR(50)
);

-- ---------- Index sur les clés étrangères ----------

CREATE INDEX idx_caract_carburant  ON caracteristique_voiture(id_carburant);
CREATE INDEX idx_caract_marque     ON caracteristique_voiture(id_marque);
CREATE INDEX idx_caract_categorie  ON caracteristique_voiture(id_categorie);
CREATE INDEX idx_detail_voiture    ON detail_voiture(id_voiture);
CREATE INDEX idx_detail_caract     ON detail_voiture(id_detail);
CREATE INDEX idx_media_voiture     ON voiture_media(id_voiture);
CREATE INDEX idx_personne_role     ON personne(id_role);
CREATE INDEX idx_resa_voiture      ON reservation(id_voiture);
CREATE INDEX idx_resa_personne     ON reservation(id_personne);
CREATE INDEX idx_vente_voiture     ON vente(id_voiture);
CREATE INDEX idx_payement_vente    ON payement(id_vente);
CREATE INDEX idx_mvt_stock_voiture ON mouvement_stock(id_voiture);
CREATE INDEX idx_depense_categorie ON depense(id_categorie_depense);