USE papyrus;

/* Exercice 1 : création d'une procédure stockée sans paramètre
Créez la procédure stockée Lst_fournis correspondant à la requête n°2 afficher le code des fournisseurs pour lesquels une commande a été passée.
Exécutez la pour vérifier qu’elle fonctionne conformément à votre attente.
Exécutez la commande SQL suivante pour obtenir des informations sur cette procédure stockée : SHOW CREATE PROCEDURE nom_procedure; */

DROP PROCEDURE if EXISTS Lst_fournis; 

delimiter | /* on modifie le délimiteur initial ";" en le remplaçant par "|". Ce sera le caractère spécial de fin pour les instructions SQL (requêtes à exécuter) comprises dans le bloc BEGIN...END*/

CREATE PROCEDURE /* on créé notre procédure stockée */
Lst_fournis() /* on nomme notre procédure stockée */
BEGIN /* on indique le début de notre procédure avec BEGIN */ 
	SELECT /* création d'une procédure stockée avec un simple SELECT */
	DISTINCT entcom.numfou AS `code fournisseur` 
	FROM 
	entcom;
END | /* on indique la fin de notre procédure stockée avec END et notre délimiteur */

delimiter ; /* on réatblit le délimiteur initial */

CALL Lst_fournis; /* pour exécuter une procédure stockée, on l'appelle avec l'instruction CALL nom_de_la_procédure */

SHOW CREATE PROCEDURE Lst_fournis; /* commande pour obtenir des infos sur cette procédure stockée */

/* Exercice 2 : création d'une procédure stockée avec un paramètre en entrée
Créer la procédure stockée Lst_Commandes, qui liste les commandes ayant un libellé particulier dans le champ obscom (cette requête sera construite à partir de la requête n°11). */

DROP PROCEDURE if EXISTS Lst_Commandes;

delimiter |

CREATE PROCEDURE
Lst_Commandes (IN observation VARCHAR(50)) /*  Ici en déclare en argument de la procédure stockée le paramètre observation de type varchar via l'instruction IN */
BEGIN
	SELECT 
	ligcom.numcom AS `numéro de commande`, 
	fournis.nomfou AS `nom du fournisseur`, 
	produit.libart AS `libellé du produit`, 
	(ligcom.qtecde * ligcom.priuni) AS `sous total`
	FROM 
	entcom
	JOIN 
	fournis
		ON fournis.numfou = entcom.numfou
	JOIN 
	ligcom
		ON entcom.numcom = ligcom.numcom
	JOIN 
	produit
		ON ligcom.codart = produit.codart
	WHERE
	entcom.obscom LIKE observation; /* le paramètre observation va se comporter comme une variable dans la requête (ici dans une clause WHERE, il faudra donc lui passer une valeur lors de l'appel à la procédure). */
END |

delimiter ;

CALL Lst_Commandes('%urgent%'); /* Ici on appelle la procédure stockée en lui donnant au paramètre obervation la valeur %urgent%. */

/* Exercice 3 : création d'une procédure stockée avec plusieurs paramètres
Créer la procédure stockée CA_ Fournisseur, qui pour un code fournisseur et une année entrée en paramètre, calcule et restitue le CA potentiel de ce fournisseur pour l'année souhaitée (cette requête sera construite à partir de la requête n°19).
On exécutera la requête que si le code fournisseur est valide, c'est-à-dire dans la table FOURNIS.
Testez cette procédure avec différentes valeurs des paramètres. */

DROP PROCEDURE if EXISTS CA_Fournisseur;

delimiter |

CREATE PROCEDURE 
CA_Fournisseur
(
	IN `code fournisseur` INT,
	IN année INT
)
BEGIN
	SELECT 
	fournis.numfou AS `fournisseur`, 
	SUM(ligcom.qteliv * ligcom.priuni) * 1.2 AS `Chiffre d'affaire` 
	FROM 
	fournis 
	JOIN 
	vente 
		ON vente.numfou = fournis.numfou
	JOIN 
	ligcom 
		ON ligcom.codart = vente.codart
	JOIN 
	entcom
		ON fournis.numfou = entcom.numfou
	WHERE 
	fournis.numfou = `code fournisseur`
	AND 
	EXTRACT(YEAR from entcom.datcom) = année
	GROUP BY 
	fournis.nomfou;
END |

delimiter ;

CALL CA_Fournisseur(9120, 2018);
CALL CA_Fournisseur(9180, 2020);	