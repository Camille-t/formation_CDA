DROP DATABASE if EXISTS ex1;

CREATE DATABASE ex1;

USE ex1;

CREATE TABLE personne(
per_num INT AUTO_INCREMENT,
per_nom VARCHAR(30),
per_prenom VARCHAR(30),
per_adresse VARCHAR(50),
per_ville VARCHAR(20),
PRIMARY KEY(per_num)
);

CREATE TABLE groupe(
gro_num INT AUTO_INCREMENT,
gro_libelle VARCHAR(30),
PRIMARY KEY(gro_num)
);

CREATE TABLE appartient(
per_num INT,
gro_num INT,
PRIMARY KEY(per_num,gro_num),
FOREIGN KEY(per_num) REFERENCES personne(per_num),
FOREIGN KEY(gro_num) REFERENCES groupe(gro_num)
);