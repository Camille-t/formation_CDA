DROP DATABASE if EXISTS bibliotheque;

CREATE DATABASE bibliotheque;

USE bibliotheque;


CREATE TABLE fiche_livre(
   liv_id INT AUTO_INCREMENT,
   liv_titre VARCHAR(30) NOT NULL,
   liv_editeur VARCHAR(30) NOT NULL,
   liv_auteur VARCHAR(30) NOT NULL,
   liv_edition_date DATE NOT NULL,
   liv_reb_date DATE,
   PRIMARY KEY(liv_id)
);

CREATE TABLE fiche_abonné(
   abo_id INT AUTO_INCREMENT,
   abo_nom VARCHAR(30) NOT NULL,
   abo_prenom VARCHAR(30) NOT NULL,
   abo_adresse_1 VARCHAR(30) NOT NULL,
   abo_adresse_2 VARCHAR(30),
   abo_code_postal CHAR(5) NOT NULL,
   abo_ville VARCHAR(30) NOT NULL,
   abo_inscription_date DATE NOT NULL,
   PRIMARY KEY(abo_id)
);

CREATE TABLE thème(
   th_id INT AUTO_INCREMENT,
   th_nom VARCHAR(30) NOT NULL,
   PRIMARY KEY(th_id)
);

CREATE TABLE emprunt(
   liv_id INT,
   abo_id INT,
   emp_date DATE,
   retour_date DATE,
   PRIMARY KEY(liv_id, abo_id),
   FOREIGN KEY(liv_id) REFERENCES fiche_livre(liv_id),
   FOREIGN KEY(abo_id) REFERENCES fiche_abonné(abo_id)
);

CREATE TABLE relance(
   liv_id INT,
   abo_id INT,
   rel_date DATE,
   rel_nb INT,
   PRIMARY KEY(liv_id, abo_id),
   FOREIGN KEY(liv_id) REFERENCES fiche_livre(liv_id),
   FOREIGN KEY(abo_id) REFERENCES fiche_abonné(abo_id)
);

CREATE TABLE contient(
   abo_id INT,
   th_id INT,
   PRIMARY KEY(abo_id, th_id),
   FOREIGN KEY(abo_id) REFERENCES fiche_abonné(abo_id),
   FOREIGN KEY(th_id) REFERENCES thème(th_id)
);