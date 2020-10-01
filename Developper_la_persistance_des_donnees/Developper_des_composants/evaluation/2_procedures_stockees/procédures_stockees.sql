/* BASE NORTHWIND */

/* I - Dernière commande d'un fournisseur */
-- Changement de DELIMITER pour passer la procedure
DELIMITER |
-- Creation de la PROCEDURE DateDerniereCommande
DROP PROCEDURE IF EXISTS `Date Derniere Commande`;

CREATE PROCEDURE `Date Derniere Commande`(IN `NomClient` VARCHAR(40)) /* Ici on déclare en argument de la procédure stockée une variable NomClient de type VARCHAR via l'instruction IN */
  -- Debut de la PROCEDURE
  BEGIN
    SELECT DATE(`orders`.`OrderDate`) AS `Date Dernière Commande`
    FROM `orders`
    JOIN `customers` ON `customers`.`CustomerID` = `orders`.`CustomerID`
    WHERE `customers`.`CompanyName` = `NomClient` /* notre paramètre NomClient  va se comporter comme une variable dans la requête (ici, dans une clause WHERE , il faudra donc lui passer une valeur lors de l'appel à la procédure) */
    ORDER BY DATE(`orders`.`OrderDate`) DESC
    LIMIT 1;
  -- Fin de la PROCEDURE
  END |
-- Application du DELIMITER initial
DELIMITER ;
-- Appelle de DateDerniereCommande avec en paramètre le client 'Du monde entier'
CALL `Date Derniere Commande`('Du monde entier');

/* II - Quel est le délai moyen de livraison en jours  */
DELIMITER |

DROP PROCEDURE IF EXISTS `Delai Moyen Livraison`;

CREATE PROCEDURE `Delai Moyen Livraison`() /* ici, on ne déclare pas d'argument à notre procédure stockée car on souhaite qu'elle s'exécute sur l'ensemble de notre BDD*/
	BEGIN 
		SELECT TRUNCATE(AVG(DATEDIFF(`ShippedDate`,`OrderDate`)),0) AS `délai moyen de livraison en jours` /* la fonction TRUNCATE() tronque un nombre au nombre spécifié de décimales, ici 0. La fonction AVG() renvoi la valeur moyenne d'une expression . LA fonction DATEDIFF renvoie le nombre de jours de différence entre deux valeurs */
		FROM orders;
	END |
	
DELIMITER ;

CALL `Delai Moyen Livraison`(); 

/* autre possibilité, on entre en argument/paramètre le nom d'un fournisseur */

DELIMITER |

DROP PROCEDURE IF EXISTS `Delai Moyen Livraison Fournisseur`;

CREATE PROCEDURE `Delai Moyen Livraison Fournisseur`( IN `Nom Fournisseur` VARCHAR(100))
	BEGIN 
		SELECT TRUNCATE(AVG(DATEDIFF(`ShippedDate`,`OrderDate`)),0) AS `délai moyen de livraison en jours`
		FROM `orders` 
		JOIN `order details` ON `order details`.`OrderID` = `orders`.`OrderID`
		JOIN `products` ON `products`.`ProductID` = `order details`.`ProductID`
		JOIN `suppliers` ON `suppliers`.`SupplierID` = `products`.`SupplierID`
		WHERE `suppliers`.`CompanyName` = `Nom Fournisseur`;
	END |
DELIMITER ;

CALL `Delai Moyen Livraison Fournisseur`('Exotic Liquids');

