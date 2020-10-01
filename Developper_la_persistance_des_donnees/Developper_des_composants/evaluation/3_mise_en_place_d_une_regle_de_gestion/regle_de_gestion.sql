/* Décrivez par quel moyen et comment vous pourriez implémenter la règle de gestion suivante.

Pour tenir compte des coûts liés au transport, on vérifiera que pour chaque produit d’une commande, le client réside dans le même pays que le fournisseur du même produit */



/*  On créé un trigger qui va empêcher l'insertion d'un produit dans une commande (via `order details`) lorsque le pays du fournisseur de ce produit (suppliers.Country) est différent du pays de livraison de la commande (orders.ShipCountry) */
DROP TRIGGER IF EXISTS `pays client et fournisseur identique`;

DELIMITER |

CREATE TRIGGER `pays client et fournisseur identique`
AFTER INSERT 
ON `order details` /* notre trigger sera appelé après l'insertion d'une nouvelle ligne de commande via la table `order details` */
	FOR EACH ROW 
	BEGIN 
		
		DECLARE `client pays` VARCHAR(30);
		DECLARE `fournisseur pays` VARCHAR(30);
		
		SET `client pays` = (SELECT DISTINCT `orders`.`ShipCountry` FROM `orders` /* on va récupérer le pays de livraison de la commande (indiqué par le client) et le stocker dans notre variable client_pays */
			JOIN `order details` ON `order details`.`OrderID` = `orders`.`OrderID`
			WHERE `order details`.`OrderID` = `NEW`.`OrderID`);
		SET `fournisseur pays` = (SELECT DISTINCT `suppliers`.`Country` FROM `suppliers`  /* on va récupérer le pays du fournisseur du produit que le client souhaite commander et le stocker dans notre variable fournisseur_pays */
			JOIN `products` ON `suppliers`.`SupplierID` = `products`.`SupplierID`
			JOIN `order details` ON `order details`.`productID` = `products`.`ProductID`
			WHERE `order details`.`ProductID` = `NEW`.`ProductID`);
			
		IF `client pays` != `fournisseur pays` THEN /* on ajoute notre condition pour interdire l'insertion de la ligne de commande */
		SIGNAL SQLSTATE '40000' SET MESSAGE_TEXT = 'Commande de ce produit impossible. Pays client différent du pays fournisseur!'; /* on affiche un message d'erreur si la condition est vraie et on empêche l'insertion de la ligne de commande */
	END IF;
END |	

DELIMITER ;

 /* on test notre trigger */
 
 /* cas où client_pays et fournisseur_pays identique
 orders.ShipCountry = France
 suppliers.supplierID = 5 dc suppliers.Country = Spain */
  
 INSERT INTO `order details` (`OrderID`, `ProductID`, `UnitPrice`, `Quantity`, `Discount`) VALUES
  	(10248, 11, 14.0000, 12, 0);

 /* cas où client_pays et fournisseur_pays différent 
 orders.ShipCountry = France
 suppliers.supplierID = 28 dc suppliers.Country = France */ 
 
  INSERT INTO `order details` (`OrderID`, `ProductID`, `UnitPrice`, `Quantity`, `Discount`) VALUES
  	(10248, 60, 34.8000, 5, 0);


