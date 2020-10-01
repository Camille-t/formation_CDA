/* 1- modif_reservation : interdire la modification des réservations (on autorise l'ajout et la suppression). */
DROP TRIGGER if EXISTS modif_reservation;

delimiter |

CREATE TRIGGER modif_reservation 
AFTER UPDATE 
ON reservation
    FOR EACH ROW
    BEGIN
         SIGNAL SQLSTATE '40000' SET MESSAGE_TEXT = 'Un problème est survenu. Les modifications de réservations sont interdites !';
   END|
   
delimiter ;

UPDATE reservation SET res_arrhes = 1265.00 WHERE res_id = 2;

/* 2- insert_reservation : interdire l'ajout de réservation pour les hôtels possédant déjà 10 réservations. */
DROP TRIGGER if EXISTS insert_reservation;

delimiter |

CREATE TRIGGER insert_reservation 
AFTER INSERT 
ON reservation
	FOR EACH ROW 
	BEGIN 
		if 10 < (SELECT COUNT(reservation.res_id) 
					FROM reservation 
					JOIN chambre ON reservation.res_cha_id = chambre.cha_id 
					WHERE chambre.cha_hot_id = new.res_cha_id)
		then  
		SIGNAL SQLSTATE '40000' SET MESSAGE_TEXT = 'Un problème est survenu. Le nombre de réservations est limité à 10 par hôtel!'; 
	END if;
END |

delimiter ;
 /* on test notre trigger en ajoutant 3 réservations à la chambre qui porte l'id 1 (chambre de l'hôtel le magnifique qui compte déjà 8 réservation) */	
INSERT INTO reservation (res_cha_id, res_cli_id, res_date, res_date_debut, res_date_fin, res_prix, res_arrhes)VALUES
(1, 1, '2017-01-10', '2017-07-01', '2017-07-15', 220, 700),
(1, 1, '2017-01-10', '2017-07-01', '2017-07-15', 220, 700),
(1, 2, '2017-01-10', '2017-07-01', '2017-07-15', 220, 700);

/* 3- insert_reservation2 : interdire les réservations si le client possède déjà 3 réservations. */

DROP TRIGGER if EXISTS insert_reservation2;

delimiter |

CREATE TRIGGER insert_reservation2
BEFORE INSERT 
ON reservation
	FOR EACH ROW 
	BEGIN 
		if 2 < (SELECT COUNT(reservation.res_cli_id)
		FROM reservation 
		JOIN chambre ON reservation.res_cha_id = chambre.cha_id
		WHERE chambre.cha_hot_id = new.res_cha_id)
	then 
	SIGNAL SQLSTATE '40000' SET MESSAGE_TEXT = 'Un problème est survenu. Le nombre de réservations est limité à 2 par client!'; 
	END if;
END |

delimiter ;
/* on test notre trigger en  essayant d'ajouter une réservation pour le client qui porte l'id 6 et qui a déjà 2 réservations à son nom */
INSERT INTO reservation (res_cha_id, res_cli_id, res_date, res_date_debut, res_date_fin, res_prix, res_arrhes)VALUES
(1, 6, '2017-01-10', '2017-07-01', '2017-07-15', 220, 700);

/* 4-	insert_chambre : lors d'une insertion, on calcule le total des capacités des chambres pour l'hôtel, si ce total est supérieur à 50, on interdit l'insertion de la chambre. */

DROP TRIGGER if EXISTS insert_chambre;

delimiter |

CREATE TRIGGER insert_chambre
AFTER INSERT 
ON chambre
	FOR EACH ROW 
	BEGIN 
		if 50 < (SELECT SUM(chambre.cha_capacite)
		FROM chambre
		JOIN hotel ON chambre.cha_hot_id = hotel.hot_id
		WHERE hotel.hot_id = new.cha_hot_id)
	then 
	SIGNAL SQLSTATE '40000' SET MESSAGE_TEXT = 'Un problème est survenu. L\'insertion d\'une nouvelle chambre est impossible car la capacité totale d\'un hôtel est limitée à 50!'; 
	END if;
END |	

delimiter ;
/* on test notre trigger en essayant d'ajouter une chambre avec une capacité de 10 personnes à l'hôtel qui a l'id 8 et qui a déjà une capacité totale de 41 personnes */
INSERT INTO chambre (cha_numero, cha_hot_id, cha_capacite, cha_type) VALUES 
(204, 7, 10, 1);	

/* BDD cp
1- Mettez en place ce trigger, puis ajoutez un produit dans une commande, vérifiez que le champ total est bien mis à jour. */

USE cp;

DROP TRIGGER if EXISTS after_insert_maj_total; 

delimiter |
	
CREATE TRIGGER after_insert_maj_total 
AFTER INSERT ON lignedecommande
    FOR EACH ROW
    BEGIN
        DECLARE id_c INT;
        DECLARE tot DOUBLE;
        SET id_c = NEW.id_commande; /* nous captons le numéro de commande concerné */
        SET tot = (SELECT DISTINCT sum(prix*quantite) FROM lignedecommande WHERE id_commande=id_c); /* on recalcul le total */
        UPDATE commande SET total=tot WHERE id=id_c; /*  on stocke le total dans la table commande */
END|

delimiter ;

INSERT INTO lignedecommande (id_commande, id_produit, quantite, prix) VALUES 
(3, 4, 2, 100); /* le champ total dans la table commande a été mis à jour = 260 pour la commande qui porte l'id 3 */

/* 2- Ce trigger ne fonctionne que lorsque l'on ajoute des produits dans la commande, les modifications ou suppressions ne permettent pas de recalculer le total. Modifiez le code ci-dessus pour faire en sorte que la modification ou la suppression de produit recalcul le total de la commande. */

DROP TRIGGER if EXISTS after_update_maj_total; 

delimiter |
	
CREATE TRIGGER after_update_maj_total 
AFTER UPDATE ON lignedecommande
    FOR EACH ROW
    BEGIN
        DECLARE id_c INT;
        DECLARE tot DOUBLE;
        SET id_c = NEW.id_commande; /* nous captons le numéro de commande concerné */
        SET tot = (SELECT DISTINCT sum(prix*quantite) FROM lignedecommande WHERE id_commande=id_c); /* on recalcul le total */
        UPDATE commande SET total=tot WHERE id=id_c; /*  on stocke le total dans la table commande */
END|

delimiter ;	

DROP TRIGGER if EXISTS after_delete_maj_total; 

delimiter |
	
CREATE TRIGGER after_delete_maj_total 
AFTER DELETE ON lignedecommande
    FOR EACH ROW
    BEGIN
        DECLARE id_c INT;
        DECLARE tot DOUBLE;
        SET id_c = OLD.id_commande; /* pas de NEW.nom_valeur dans un DELETE mais un OLD pour accéder à la nouvelle valeur de id_commande*/
        SET tot = (SELECT DISTINCT sum(prix*quantite) FROM lignedecommande WHERE id_commande=id_c); /* on recalcul le total */
        UPDATE commande SET total=tot WHERE id=id_c; /*  on stocke le total dans la table commande */
END|

delimiter ;

/* vérifications de nos deux nouveaux triggers */
UPDATE lignedecommande SET `quantite` = 1 WHERE `id_commande` = 1; /* ici , volontairement on a modifié la qualtité pour tous les id_produit de la commande qui porte l'id 1 */

DELETE FROM lignedecommande WHERE `id_produit` = 1 AND `id_commande` = 2; /* ici, on supprime de la table lignedecommande la ligne qui correspond à l'id_commande = 2  et à l'id_produit 1 (soit 2 quantités à 10 € pièce)*/

 /* 4-Un champ remise était prévu dans la table commande. Prenez en compte ce champ dans le code de votre trigger. */ 
DROP TRIGGER if EXISTS after_update_maj_total_remise; 

delimiter |
	
CREATE TRIGGER after_update_maj_total_remise 
AFTER UPDATE ON lignedecommande
    FOR EACH ROW
    BEGIN
        DECLARE id_c INT;
        DECLARE rem INT;
        DECLARE tot DOUBLE;
        SET id_c = NEW.id_commande; /* on capte le numéro de commande concerné */
        SET rem = (SELECT DISTINCT remise FROM commande WHERE id=id_c); /* on capte la remise concernée*/
        SET tot = (SELECT DISTINCT sum(prix*quantite) FROM lignedecommande WHERE id_commande=id_c); /* on recalcule le total */
        UPDATE commande SET total=tot - tot * ((100 - rem)/100) WHERE id=id_c; /* on recalcule le total en soustrayant la remise et on stocke le total dans la table commande */
END|

delimiter ;

UPDATE lignedecommande SET `quantite` = 4 WHERE `id_commande` = 3 AND `id_produit` = 3;