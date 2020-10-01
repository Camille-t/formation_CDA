/*Lot 1 */
/* 1 - Afficher la liste des hôtels. Le résultat doit faire apparaître le nom de l’hôtel et la ville */
SELECT 
hotel.hot_nom AS `NomHotels`,
hotel.hot_ville AS `Ville`
FROM 
hotel;

/* 2 - Afficher la ville de résidence de Mr White Le résultat doit faire apparaître le nom, le prénom, et l'adresse du client */
SELECT 
`client`.cli_nom AS `Nom`,
`client`.cli_prenom AS `Prenom`,
`client`.cli_ville AS `Ville`
FROM 
`client`
WHERE 
`client`.cli_nom = 'White';

/* 3 - Afficher la liste des stations dont l’altitude < 1000 Le résultat doit faire apparaître le nom de la station et l'altitude */
SELECT 
station.sta_nom AS `Nom Station`,
station.sta_altitude AS `Altitude`
FROM 
station
WHERE 
station.sta_altitude > 1000;

/* 4 - Afficher la liste des chambres ayant une capacité > 1 Le résultat doit faire apparaître le numéro de la chambre ainsi que la capacité */
SELECT 
chambre.cha_numero,
chambre.cha_capacite
FROM 
chambre
WHERE 
chambre.cha_capacite > 1;

/* 5 - Afficher les clients n’habitant pas à Londre Le résultat doit faire apparaître le nom du client et la ville */
SELECT 
`client`.cli_nom, 
`client`.cli_ville
FROM 
`client`
WHERE 
`client.`cli_ville != 'Londre';

/* 6 - Afficher la liste des hôtels située sur la ville de Bretou et possédant une catégorie>3 Le résultat doit faire apparaître le nom de l'hôtel, ville et la catégorie */
SELECT 
hotel.hot_nom, 
hotel.hot_ville, 
hotel.hot_categorie
FROM 
hotel 
WHERE 
hotel.hot_ville = 'Bretou' 
AND 
hotel.hot_categorie > 3;

/* Lot 2 */
/* 7 - Afficher la liste des hôtels avec leur station Le résultat doit faire apparaître le nom de la station, le nom de l’hôtel, la catégorie, la ville) */
SELECT 
station.`sta_nom`, 
hotel.`hot_nom`, 
hotel.`hot_categorie`, 
hotel.`hot_ville`
FROM 
hotel 
JOIN 
station
    ON hotel.`hot_sta_id` = station.`sta_id`;

/* 8 - Afficher la liste des chambres et leur hôtel Le résultat doit faire apparaître le nom de l’hôtel, la catégorie, la ville, le numéro de la chambre) */
SELECT 
hotel.`hot_nom`,
hotel.`hot_categorie`, 
hotel.`hot_ville`, 
chambre.`cha_numero`
FROM 
hotel 
JOIN 
chambre
    ON chambre.`cha_hot_id` = hotel.`hot_id`;

/* 9 - Afficher la liste des chambres de plus d'une place dans des hôtels situés sur la ville de Bretou Le résultat doit faire apparaître le nom de l’hôtel, la catégorie, la ville, le numéro de la chambre et sa capacité) */
SELECT 
hotel.`hot_nom`,
hotel.`hot_categorie`,
hotel.`hot_ville`, 
chambre.`cha_numero`, 
chambre.`cha_capacite`
FROM 
chambre 
JOIN 
hotel 
    ON chambre.`cha_hot_id` = hotel.`hot_id`
WHERE 
chambre.`cha_capacite` > 1 
AND 
hotel0`.hot_ville` = 'Bretou';

/* 10 - Afficher la liste des réservations avec le nom des clients Le résultat doit faire apparaître le nom du client, le nom de l’hôtel, la date de réservation */
SELECT `client`.cli_nom AS `nom du client`, 
hotel.hot_nom AS `nom de l'hôtel`, 
reservation.res_date AS `date de la reservation` 
FROM reservation
JOIN `client`
ON reservation.res_cli_id = `client`.cli_id
JOIN chambre
ON chambre.cha_hot_id = reservation.res_cha_id
JOIN hotel
ON chambre.cha_hot_id = hotel.hot_id;


/* 11 - Afficher la liste des chambres avec le nom de l’hôtel et le nom de la station Le résultat doit faire apparaître le nom de la station, le nom de l’hôtel, le numéro de la chambre et sa capacité */
SELECT 
chambre.cha_id, 
chambre.cha_numero AS `numéro de la chambre`, 
chambre.cha_capacite AS `capacité de la chambre`, 
hotel.hot_nom AS `nom de l'hôtel`, 
station.sta_nom AS `nom de la station`
FROM 
chambre
JOIN 
hotel
    ON chambre.cha_hot_id = hotel.hot_id
JOIN 
station
    ON hotel.hot_sta_id = station.sta_id;

/* 12 - Afficher les réservations avec le nom du client et le nom de l’hôtel Le résultat doit faire apparaître le nom du client, le nom de l’hôtel, la date de début du séjour et la durée du séjour */
SELECT 
`client`.cli_nom AS `nom du client`, 
hotel.hot_nom AS `nom de l'hôtel`, 
reservation.res_date_debut AS `date de début du séjour`, 
DATEDIFF(reservation.res_date_fin, reservation.res_date_debut) AS `durée du séjour`
FROM 
`client`
JOIN 
reservation
    ON `client`.cli_id = reservation.res_cli_id
JOIN 
chambre
    ON reservation.res_cha_id = chambre.cha_id
JOIN 
hotel
    ON chambre.cha_hot_id = hotel.hot_id;


/* Lot 3 */
/* 13 - Compter le nombre d’hôtel par station */
SELECT 
COUNT(hotel.hot_id) AS `nombre d'hôtels`, 
station.sta_nom
FROM 
hotel
JOIN 
station
    ON hotel.hot_sta_id = station.sta_id
GROUP BY 
station.sta_nom;

/* 14 - Compter le nombre de chambre par station */
SELECT 
COUNT(chambre.cha_id) AS `nombre de chambres`, 
station.sta_nom AS `nom de la station`
FROM 
chambre
JOIN 
hotel
    ON chambre.cha_hot_id = hotel.hot_id
JOIN 
station
    ON hotel.hot_sta_id = station.sta_id
GROUP BY 
station.sta_nom;

/* 15 - Compter le nombre de chambre par station ayant une capacité > 1 */
SELECT 
COUNT(chambre.cha_id) AS `nombre de chambres avec capacité > 1`, 
station.sta_nom AS `nom de la station`
FROM 
chambre
JOIN 
hotel
    ON chambre.cha_hot_id = hotel.hot_id
JOIN 
station
    ON hotel.hot_sta_id = station.sta_id
WHERE 
chambre.cha_capacite > 1
GROUP BY 
station.sta_nom;


/* 16 - Afficher la liste des hôtels pour lesquels Mr Squire a effectué une réservation */
SELECT 
hotel.hot_nom AS `liste des hôtels pour lesquels Mr Squire a effectué une réservation`
FROM 
hotel
JOIN 
chambre
    ON hotel.hot_id = chambre.cha_hot_id
JOIN 
reservation 
    ON chambre.cha_id = reservation.res_cha_id
JOIN 
`client`
    ON reservation.res_cli_id = `client`.cli_id
WHERE 
`client`.cli_nom = 'Squire'
GROUP BY 
hotel.hot_nom;


/* 17 - Afficher la durée moyenne des réservations par station */
SELECT 
station.sta_nom AS `station`, 
AVG(DATEDIFF(reservation.res_date_fin, reservation.res_date_debut)) AS `durée moyenne des réservations`
FROM 
station 
JOIN 
hotel 
    ON hotel.hot_sta_id = station.sta_id
JOIN 
chambre 
    ON chambre.cha_hot_id = hotel.hot_id
JOIN 
reservation 
    ON reservation.res_cha_id = chambre.cha_id
GROUP BY 
station.sta_nom;