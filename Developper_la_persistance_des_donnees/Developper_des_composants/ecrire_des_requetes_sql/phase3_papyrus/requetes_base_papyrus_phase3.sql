/* 1. Quelles sont les commandes du fournisseur 09120 ? */
SELECT 
entcom.numcom AS `commandes` 
FROM 
entcom
WHERE 
entcom.numfou = 09120;

/* 2. Afficher le code des fournisseurs pour lesquels des commandes ont été passées. */
SELECT 
DISTINCT entcom.numfou AS `code fournisseur` /* SLECT DISCTINCT command returns only distinct (differents) values in the result set */
FROM 
entcom;

/* 3. Afficher le nombre de commandes fournisseurs passées, et le nombre de fournisseur concernés. */
SELECT 
COUNT(entcom.numfou) AS `nombre de fournisseurs concernés`, /* The COUNT() function returns the number of rows that matches a specified criteria. */
COUNT(entcom.numcom) AS `nombre de commandes passées`
FROM 
entcom;

/* 4. Editer les produits ayant un stock inférieur ou égal au stock d'alerte et dont la quantité annuelle est inférieur est inférieure à 1000 (informations à fournir : n° produit, libellé produit, stock, stock actuel d'alerte, quantité annuelle) */
SELECT 
produit.codart AS `n° produit`, 
produit.libart AS `libellé produit`, 
produit.stkphy AS `stock`, 
produit.stkale AS `stock actuel d'alerte`, 
produit.qteann AS `quantité annuelle`
FROM 
produit
WHERE 
produit.stkphy < produit.stkale 
AND 
produit.qteann < 1000;

/* 5. Quels sont les fournisseurs situés dans les départements 75 78 92 77 ? L’affichage (département, nom fournisseur) sera effectué par département décroissant, puis par ordre alphabétique */
SELECT 
SUBSTRING(fournis.posfou, 1, 2) AS `département`, /*  function SUBSTRING(string, start, length) */
fournis.nomfou AS `nom fournisseur` 
FROM 
fournis
WHERE 
SUBSTRING(fournis.posfou, 1, 2) = 75 
OR 
SUBSTRING(fournis.posfou, 1, 2) = 78 
OR 
SUBSTRING(fournis.posfou, 1, 2) = 92 
OR 
SUBSTRING(fournis.posfou, 1, 2) = 77
ORDER BY 
fournis.posfou DESC, fournis.nomfou; /* The ORDER BY keyword is used to sort the result-set in ascending (by default) or descending order. */

/* 6. Quelles sont les commandes passées au mois de mars et avril ? */
SELECT 
entcom.numcom AS `numéro de commande`, 
MONTHNAME(entcom.datcom) AS `mois où la commande a été passée` /* function MONTHNAME(DATE) Return the name of the month for a date */
FROM entcom
WHERE 
MONTHNAME(entcom.datcom) = 'March' 
OR 
MONTHNAME(entcom.datcom) = 'April';

/* 7. Quelles sont les commandes du jour qui ont des observations particulières ? (Affichage numéro de commande, date de commande) */
SELECT 
entcom.numcom AS `numéro de commande`, 
DATE(entcom.datcom) AS `date de commande` /* Function DATE(TIMESTAMP) Extracts the date part from a datetime expression */
FROM 
entcom 
WHERE 
DATE(entcom.datcom) = CURDATE() 
AND 
entcom.obscom IS NOT NULL; /* Function CURDATE(DATE) returns the current date */

/* 8. Lister le total de chaque commande par total décroissant (Affichage numéro de commande et total) */
SELECT 
ligcom.numcom AS `numéro de commande`, 
SUM(ligcom.priuni * ligcom.qteliv) AS `total commande` /* The SUM() function calculates the sum of a set of values */
FROM 
ligcom
GROUP BY 
ligcom.numcom /* The GROUP BY statement groups rows that have the same values into summary rows */
ORDER BY 
SUM(ligcom.priuni * ligcom.qteliv) DESC; 

/* 9. Lister les commandes dont le total est supérieur à 10 000€ ; on exclura dans le calcul du total les articles commandés en quantité supérieure ou égale à 1000. (Affichage numéro de commande et total) */
SELECT 
ligcom.numcom AS `numéro de commande`, 
SUM(ligcom.priuni * ligcom.qteliv) AS `total commande` 
FROM 
ligcom
WHERE 
ligcom.qtecde <= 1000 
GROUP BY 
ligcom.numcom
HAVING /* The HAVING clause was added to SQL because the WHERE keyword could not be used with aggregate functions. */
SUM(ligcom.priuni * ligcom.qteliv) > 10000; 

/* 10.Lister les commandes par nom fournisseur (Afficher le nom du fournisseur, le numéro de commande et la date) */
SELECT 
fournis.nomfou AS `nom fournisseur`, 
entcom.numcom AS `numéro de commande`, 
entcom.datcom AS `date`
FROM 
fournis
JOIN 
entcom
	ON entcom.numfou = fournis.numfou;

/* 11.Sortir les produits des commandes ayant le mot "urgent' en observation? (Afficher le numéro de commande, le nom du fournisseur, le libellé du produit et le sous total = quantité commandée * Prix unitaire) */
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
entcom.obscom LIKE '%urgent%'; /* The LIKE operator is used in a WHERE clause to search for a specified pattern in a column. The % sign represents zero, one, or multiple characters */

/* 12.Coder de 2 manières différentes la requête suivante : Lister le nom des fournisseurs susceptibles de livrer au moins un article */
SELECT 
DISTINCT fournis.nomfou AS 'nom du fournisseur'
FROM 
fournis
JOIN 
entcom 
	ON fournis.numfou = entcom.numfou
JOIN 
ligcom
	ON ligcom.numcom = entcom.numcom
WHERE 
ligcom.qteliv > 0;
-- HURRYTAPE numfou=9180 n'a pas livré la commande numcom=70629 comportant les articles codart=B001 et codart=B002.
-- DISCOBOL numfou=9120 n'a pas livré la commande numcom=70020 comportant les articles codart=B001 et codart=B002 mais elle a livré la commande numcom=70300 comportant l'article codart=I100.
-- MEDICIS numfou=8700 a livré la commande numcom=70250(pour laquelle il manque 3000 unités de codart=P230)
-- GROBRIGAN numfou=120 a livré toutes ses commandes : numcom=70625(OK), numcom=70210(OK), numcom=70010(pour laquelle il manque 400 unités de codart=P240)
-- ECLIPSE numfou=540 a livré toutes ses commandes :  numcom=70011(OK) numcom=70620(OK)
-- DEPANPAP numfou=9150 a livré sa commande numcom=70025

/* 13.Coder de 2 manières différentes la requête suivante Lister les commandes (Numéro et date) dont le fournisseur est celui de la commande 70210 */
SELECT 
entcom.numcom AS `numéro de commande`, 
entcom.datcom AS `date de commande`
FROM 
entcom
WHERE 
entcom.numfou = (SELECT entcom.numfou FROM entcom WHERE entcom.numcom= 70210);

/* 14.Dans les articles susceptibles d’être vendus, lister les articles moins chers (basés sur Prix1) que le moins cher des rubans (article dont le premier caractère commence par R). On affichera le libellé de l’article et prix1 */
SELECT 
DISTINCT produit.libart AS `Libellé article`, 
vente.prix1 AS `Prix1` 
FROM 
vente 
JOIN 
produit 
	ON produit.codart = vente.codart
WHERE 
vente.prix1 < ALL (SELECT vente.prix1 FROM vente WHERE vente.codart LIKE 'r%');

/* 15.Editer la liste des fournisseurs susceptibles de livrer les produits dont le stock est inférieur ou égal à 150 % du stock d'alerte. La liste est triée par produit puis fournisseur */
SELECT 
DISTINCT fournis.nomfou AS `Fournisseur`, 
produit.libart AS `Produit`
FROM 
produit 
JOIN 
vente 
	ON produit.codart = vente.codart
JOIN 
fournis 
	ON vente.numfou = fournis.numfou
WHERE 
produit.stkphy <= (1.5 * produit.stkale)
ORDER BY 
produit.libart, fournis.nomfou;

/* 16.Éditer la liste des fournisseurs susceptibles de livrer les produit dont le stock est inférieur ou égal à 150 % du stock d'alerte et un délai de livraison d'au plus 30 jours. La liste est triée par fournisseur puis produit */
SELECT 
DISTINCT fournis.nomfou AS `Fournisseur`, 
produit.libart AS `Produit`
FROM 
fournis 
JOIN 
vente 
	ON vente.numfou = fournis.numfou
JOIN 
produit 
	ON produit.codart = vente.codart
WHERE 
produit.stkphy <= (1.5 * produit.stkale)
AND 
vente.delliv <= 30
ORDER BY 
fournis.nomfou, 
produit.libart;

/* 17.Avec le même type de sélection que ci-dessus, sortir un total des stocks par fournisseur trié par total décroissant */
SELECT 
fournis.nomfou AS `Fournisseur`,
SUM(produit.stkphy) AS `total des stocks`
FROM
produit
JOIN
vente
	ON produit.codart = vente.codart
JOIN
fournis
	ON vente.numfou = fournis.numfou
GROUP BY 
fournis.nomfou
ORDER BY 
SUM(produit.stkphy) DESC;


/* 18.En fin d'année, sortir la liste des produits dont la quantité réellement commandée dépasse 90% de la quantité annuelle prévue. */
SELECT 
produit.libart AS `produit`
FROM 
produit 
JOIN 
ligcom 
	ON produit.codart = ligcom.codart
WHERE 
(produit.qteann * 0.9) < ligcom.qtecde
GROUP BY 
ligcom.codart;

/* 19.Calculer le chiffre d'affaire par fournisseur pour l'année sachant que les prix indiqués sont hors taxes et que le taux de TVA est 20%. */
SELECT 
fournis.nomfou AS `fournisseur`, 
SUM(ligcom.qteliv * ligcom.priuni) * 1.2 AS `Chiffre d'affaire`
FROM 
fournis 
JOIN 
vente 
	ON vente.numfou = fournis.numfou
JOIN 
ligcom 
	ON ligcom.codart = vente.codart
GROUP BY 
fournis.nomfou;

/* 20.Existe-t-il des lignes de commande non cohérentes avec les produits vendus par les fournisseurs. ? */