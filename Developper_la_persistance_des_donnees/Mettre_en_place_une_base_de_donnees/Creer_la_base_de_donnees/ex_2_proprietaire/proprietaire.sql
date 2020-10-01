DROP DATABASE if EXISTS proprietaire;

CREATE DATABASE proprietaire;

USE proprietaire;

CREATE TABLE station(
station_num INT AUTO_INCREMENT, /* NOT NULL inutile sur un AUTO_INC . PRIMARY KEY doit être unique */
station_nom VARCHAR(50) NOT NULL,
PRIMARY KEY(station_num)
);

CREATE TABLE hotel(
hotel_num INT AUTO_INCREMENT,
hotel_capacite INT NOT NULL,
hotel_categorie INT NOT NULL,
hotel_nom VARCHAR(50) NOT NULL,
hotel_adresse VARCHAR(50),
station_num INT, 
PRIMARY KEY(hotel_num),
FOREIGN KEY(station_num) REFERENCES station(station_num) /* FOREIGN KEY permet de lier deux tbales donc de récupérer dans une table les données d'une autre table. Elle doit être initiée comme attribut dune table avant d'être utilisée comme FOREIGN KEY dans une autre table */
);

CREATE TABLE chambre(
chambre_num INT AUTO_INCREMENT,
chambre_capacite TINYINT NOT NULL, /* TINYINT max value = 655  */
cambre_confort TINYINT NOT NULL, 
chambre_exposition INT NOT NULL,
chambre_type INT,
hotel_num INT NOT NULL,
PRIMARY KEY(chambre_num),
FOREIGN KEY(hotel_num) REFERENCES hotel(hotel_num)
);

CREATE TABLE `client`(
client_num INT AUTO_INCREMENT,
client_nom VARCHAR(50) NOT NULL,
client_prenom VARCHAR(50) NOT NULL,
client_adresse VARCHAR(50) NOT NULL,
PRIMARY KEY(client_num)
);

CREATE TABLE reservation(
resa_date_creation TIMESTAMP NOT NULL,
resa_date_debut DATETIME NOT NULL,
resa_date_fin DATETIME NOT NULL,
resa_arrhes_prix DECIMAL(10.2) NOT NULL,
resa_total_prix DECIMAL(10.2) NOT NULL,
chambre_num INT,
client_num INT,
PRIMARY KEY (chambre_num, client_num), /* PRIMARY KEY COMPOSITE permet de récupérer sur une ligne les données chambre_num et client_num (qui deviennent donc UNE donnée unique) */
FOREIGN KEY (chambre_num) REFERENCES chambre(chambre_num),
FOREIGN KEY (client_num) REFERENCES `client`(client_num)
);
