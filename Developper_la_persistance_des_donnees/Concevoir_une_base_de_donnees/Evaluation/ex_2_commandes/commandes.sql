DROP DATABASE if EXISTS evaluation;

CREATE DATABASE evaluation;

USE evaluation;

CREATE TABLE Client(
   cli_num INT AUTO_INCREMENT,
   cli_nom VARCHAR(50) NOT NULL,
   cli_prenom VARCHAR(50) NOT NULL,
   PRIMARY KEY(cli_num)
);

CREATE TABLE Commande(
   com_num INT AUTO_INCREMENT,
   com_date DATE NOT NULL,
   com_montant DECIMAL(10.2) NOT NULL,
   cli_num INT NOT NULL,
   PRIMARY KEY(com_num),
   FOREIGN KEY(cli_num) REFERENCES Client(cli_num)
);

CREATE TABLE Article(
   art_num INT AUTO_INCREMENT,
   art_libelle VARCHAR(50),
   art_PU DECIMAL(10.2),
   PRIMARY KEY(art_num)
);

CREATE TABLE SeComposeDe(
   com_num INT,
   art_num INT,
   quantite INT NOT NULL,
   tva DECIMAL(4,2) NOT NULL,
   PRIMARY KEY(com_num, art_num),
   FOREIGN KEY(com_num) REFERENCES Commande(com_num),
   FOREIGN KEY(art_num) REFERENCES Article(art_num)
);