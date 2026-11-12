-- ============================================================
-- SYSTEME DE GESTION - VENTE DE VOITURES
-- PostgreSQL : structure simple (tables uniquement)
-- Sans fonctions, triggers, vues, index supplémentaires ni règles métier.
-- ============================================================

CREATE TABLE role (
    id_role SERIAL PRIMARY KEY,
    nom_role VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE personne (
    id_personne SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    telephone VARCHAR(30),
    mot_de_passe TEXT,
    id_role INTEGER REFERENCES role(id_role)
);

CREATE TABLE marque (
    id_marque SERIAL PRIMARY KEY,
    nom_marque VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE modele (
    id_modele SERIAL PRIMARY KEY,
    nom_modele VARCHAR(100) NOT NULL,
    id_marque INTEGER NOT NULL REFERENCES marque(id_marque)
);

CREATE TABLE voiture (
    id_voiture SERIAL PRIMARY KEY,
    vin VARCHAR(100) UNIQUE,
    id_modele INTEGER NOT NULL REFERENCES modele(id_modele),
    prix_achat NUMERIC(12,2),
    prix_vente NUMERIC(12,2),
    statut VARCHAR(30),
    date_arrivee DATE
);

CREATE TABLE voiture_detail (
    id_detail SERIAL PRIMARY KEY,
    id_voiture INTEGER NOT NULL UNIQUE REFERENCES voiture(id_voiture),
    annee INTEGER,
    kilometrage INTEGER,
    carburant VARCHAR(30),
    transmission VARCHAR(30),
    couleur VARCHAR(50),
    description TEXT
);

CREATE TABLE voiture_media (
    id_media SERIAL PRIMARY KEY,
    id_voiture INTEGER NOT NULL REFERENCES voiture(id_voiture),
    type_media VARCHAR(20),
    url TEXT,
    ordre INTEGER
);

CREATE TABLE reservation (
    id_reservation SERIAL PRIMARY KEY,
    id_personne INTEGER NOT NULL REFERENCES personne(id_personne),
    id_voiture INTEGER NOT NULL REFERENCES voiture(id_voiture),
    date_reservation DATE,
    date_expiration DATE,
    statut VARCHAR(30),
    prix_reservation NUMERIC(12,2)
);

CREATE TABLE vente (
    id_vente SERIAL PRIMARY KEY,
    id_voiture INTEGER NOT NULL REFERENCES voiture(id_voiture),
    id_client INTEGER NOT NULL REFERENCES personne(id_personne),
    id_reservation INTEGER REFERENCES reservation(id_reservation),
    date_vente DATE,
    prix_final NUMERIC(12,2),
    statut VARCHAR(30)
);

CREATE TABLE paiement (
    id_paiement SERIAL PRIMARY KEY,
    id_vente INTEGER NOT NULL REFERENCES vente(id_vente),
    montant NUMERIC(12,2) NOT NULL,
    mode_paiement VARCHAR(30),
    date_paiement DATE,
    reference_paiement VARCHAR(100),
    statut VARCHAR(30)
);

CREATE TABLE depense (
    id_depense SERIAL PRIMARY KEY,
    id_voiture INTEGER REFERENCES voiture(id_voiture),
    categorie VARCHAR(50),
    montant NUMERIC(12,2) NOT NULL,
    date_depense DATE,
    description TEXT,
    id_personne INTEGER REFERENCES personne(id_personne)
);
