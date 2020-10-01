USE hotel;

/* 1-Afficher la liste des hôtels avec leur station */

DROP VIEW if EXISTS v_liste_hotels_avec_stations;

CREATE VIEW /* creation vue */
v_liste_hotels_avec_stations
AS
SELECT 
hotel.hot_nom AS `nom hotel`,
station.sta_nom AS `nom station`
FROM 
hotel
JOIN 
station 
	ON station.`sta_id` = hotel.`hot_sta_id`;
	
SELECT /* affichage vue */
*
FROM
v_liste_hotels_avec_stations;

/* 2-Afficher la liste des chambres et leur hôtel */

DROP VIEW if EXISTS v_liste_chambres_avec_hotels;

CREATE VIEW 
v_liste_chambres_avec_hotels
AS
SELECT
chambre.cha_numero AS `numéro de chambre`,
hotel.hot_nom AS `nom de l'hôtel`
FROM
hotel
JOIN
chambre
	ON hotel.hot_id = chambre.cha_hot_id;
	
SELECT 
*
FROM
v_liste_chambres_avec_hotels;

/* 3-Afficher la liste des réservations avec le nom des clients */

DROP VIEW if EXISTS v_liste_reservations_avec_noms_clients;

CREATE VIEW 
v_liste_reservations_avec_noms_clients
AS
SELECT 
reservation.res_id AS `numéro de réservation`,
`client`.cli_nom AS `nom du client`
FROM
reservation
JOIN
`client`
	ON reservation.res_cli_id = `client`.cli_id;
	
SELECT
*
FROM
v_liste_reservations_avec_noms_clients;

/* 4-Afficher la liste des chambres avec le nom de l’hôtel et le nom de la station */

DROP VIEW if EXISTS v_liste_chambres_avec_hotels_et_stations;

CREATE VIEW
v_liste_chambres_avec_hotels_et_stations
AS
SELECT
chambre.cha_numero AS `numéro de chambre`,
hotel.hot_nom AS `nom de l'hôtel`,
station.sta_nom AS `nom station`
FROM
chambre
JOIN
hotel
	ON hotel.hot_id = chambre.cha_hot_id
JOIN
station
	ON station.`sta_id` = hotel.`hot_sta_id`;

SELECT 
*
FROM
v_liste_chambres_avec_hotels_et_stations;

/* 5-Afficher les réservations avec le nom du client et le nom de l’hôtel */

DROP VIEW if EXISTS v_liste_reservations_avec_noms_clients_et_hotels;

CREATE VIEW 
v_liste_reservations_avec_noms_clients_et_hotels
AS
SELECT
reservation.res_id AS `numéro de réservation`,
`client`.cli_nom AS `nom du client`,
hotel.hot_nom AS `nom de l'hôtel`
FROM
reservation
JOIN
`client`
	ON reservation.res_cli_id = `client`.cli_id
JOIN
chambre 
	ON reservation.res_cha_id = chambre.cha_id
JOIN 
hotel
	ON chambre.cha_hot_id = hotel.hot_id;

SELECT 
* 
FROM
v_liste_reservations_avec_noms_clients_et_hotels;
