/* Rechercher le prénom des employés et le numéro de la région de leur département. */
SELECT
employe.prenom AS `prénom de l'employé`,
dept.noregion AS `numéro de la région du département de l'employé`
FROM
employe
JOIN
dept
	ON employe.nodep = dept.nodept;

/* Rechercher le numéro du département, le nom du département, le nom des employés classés par numéro de département (renommer les tables utilisées).*/
SELECT
dept.nodept AS `numéro du département`,
dept.nom AS `nom du département`,
employe.nom AS `nom de l'employé`
FROM
employe
JOIN
dept
	ON employe.nodep = dept.nodept
ORDER BY
dept.nodept;

/* Rechercher le nom des employés du département Distribution. */
SELECT 
employe.nom AS `nom de l'employé du département Distribution`
FROM 
employe
JOIN
dept
	ON employe.nodep = dept.nodept
WHERE dept.nom = 'distribution';

/* Rechercher le nom et le salaire des employés qui gagnent plus que leur patron, et le nom et le salaire de leur patron. */
SELECT  /* on renomme temporairement nos tables (en t1 et t2) dans la requête afin de réaliser une auto-jointure (jointure sur une même table) */
e1.nom AS `nom patron`, 
e1.salaire AS `salaire patron`, 
e2.nom AS `nom employe`, 
e2.salaire AS `salaire employe`
FROM 
employe AS e1
JOIN 
employe AS e2
	ON e1.noemp = e2.nosup
WHERE 
e1.salaire < e2.salaire;	

/* Rechercher le nom et le titre des employés qui ont le même titre que Amartakaldire. */
SELECT 
employe.nom,
employe.titre
FROM
employe
WHERE
employe.titre IN
	(SELECT employe.titre FROM employe WHERE employe.nom = 'Amartakaldire');

/* Rechercher le nom, le salaire et le numéro de département des employés qui gagnent plus qu'un seul employé du département 31, classés par numéro de département et salaire. */
SELECT 
employe.nom,
employe.salaire,
employe.nodep
FROM
employe
WHERE
employe.salaire > any 
	(SELECT employe.salaire FROM employe WHERE employe.nodep = 31)
ORDER BY employe.nodep, employe.salaire;

/* Rechercher le nom, le salaire et le numéro de département des employés qui gagnent plus que tous les employés du département 31, classés par numéro de département et salaire. */
SELECT 
employe.nom,
employe.salaire,
employe.nodep
FROM
employe
WHERE 
employe.salaire > ALL
	(SELECT employe.salaire FROM employe WHERE employe.nodep = 31)
ORDER BY employe.nodep, employe.salaire;

/* Rechercher le nom et le titre des employés du service 31 qui ont un titre que l'on trouve dans le département 32*/
SELECT
employe.nom,
employe.titre
FROM
employe
WHERE 
employe.nodep = 31
AND
employe.titre IN 
	(SELECT employe.titre FROM employe WHERE employe.nodep = 32);

/* Rechercher le nom et le titre des employés du service 31 qui ont un titre l'on ne trouve pas dans le département 32. */
SELECT
employe.nom,
employe.titre
FROM
employe
WHERE 
employe.nodep = 31
AND
employe.titre NOT IN 
	(SELECT employe.titre FROM employe WHERE employe.nodep = 32);

/* Rechercher le nom, le titre et le salaire des employés qui ont le même titre et le même salaire que Fairent. */
SELECT 
employe.nom,
employe.titre,
employe.salaire
FROM
employe
WHERE
employe.salaire IN
	(SELECT employe.salaire FROM employe WHERE employe.nom = 'Fairent')
AND employe.titre IN 
	(SELECT employe.titre FROM employe WHERE employe.nom = 'Fairent')
AND employe.nom != 'Fairent';
	
/* Rechercher le numéro de département, le nom du département, le nom des employés, en affichant aussi les départements dans lesquels il n'y a personne, classés par numéro de département. */
SELECT
employe.nodep,
dept.nom,
employe.nom
FROM
dept
LEFT JOIN
employe
	ON employe.nodep = dept.nodept
ORDER BY 
dept.nodept;

SELECT 
employe.nodep,
dept.nom,
employe.nom
FROM
employe
RIGHT JOIN 
dept
	ON employe.nodep = dept.nodept
ORDER BY 
dept.nodept;

/* 1. Calculer le nombre d'employés de chaque titre. */
SELECT 
COUNT(employe.noemp) AS `nombre d'employés`,
employe.titre AS `titre`
FROM
employe 
GROUP BY 
employe.titre;  
 
/* 2. Calculer la moyenne des salaires et leur somme, par région.*/
SELECT 
AVG(employe.salaire) AS `moyenne des salaires`,
SUM(employe.salaire) AS `somme des salaires`,
dept.noregion AS `numéro de région`
FROM
employe
JOIN
dept
	ON dept.nodept = employe.nodep
GROUP BY 
dept.noregion;

/* 3. Afficher les numéros des départements ayant au moins 3 employés. */
SELECT 
employe.nodep AS `numéro de département`,
COUNT(employe.noemp) AS `nombre d'employés`
FROM
employe
GROUP BY 
employe.nodep
HAVING 
COUNT(employe.noemp) >= 3; 

/* 4. Afficher les lettres qui sont l'initiale d'au moins trois employés. */
SELECT 
SUBSTRING(nom, 1, 1) AS `initiale Nom`,
COUNT(SUBSTRING(nom, 1, 1)) AS `occurence initiale`
FROM 
employe 
GROUP BY 
`initiale nom`
	HAVING `occurence initiale` > 2;

/* 5. Rechercher le salaire maximum et le salaire minimum parmi tous les salariés et l'écart entre les deux. */
SELECT 
MAX(employe.salaire) AS `salaire maximum`, 
MIN(employe.salaire) AS `salaire minimum`, 
(MAX(salaire)-MIN(salaire)) AS `écart entre salaire max et min`
FROM employe;

/* 6. Rechercher le nombre de titres différents. */
SELECT 
COUNT(DISTINCT employe.titre) AS `nombre de titres différents`
FROM 
employe;

/* 7. Pour chaque titre, compter le nombre d'employés possédant ce titre. */
SELECT 
DISTINCT employe.titre, 
COUNT(employe.noemp) AS `nombre d'employés`
FROM 
employe
GROUP BY 
employe.titre;

/* 8. Pour chaque nom de département, afficher le nom du département et le nombre d'employés.*/
SELECT 
dept.nom AS `nom du département`,
COUNT(employe.noemp) AS `nombre d'employés`
FROM
employe
JOIN 
dept
	ON dept.nodept = employe.nodep
GROUP BY 
`nom du département`;

/* 9. Rechercher les titres et la moyenne des salaires par titre dont la moyenne est supérieure à la moyenne des salaires des Représentants. */
SELECT 
DISTINCT employe.titre, 
AVG(salaire) AS `salaire moyen`
FROM 
employe 
GROUP BY 
titre
	HAVING 
	AVG(employe.salaire) >= (SELECT AVG(employe.salaire) FROM employe WHERE employe.titre = 'représentant');

/* 10.Rechercher le nombre de salaires renseignés et le nombre de taux de commission renseignés. */
SELECT 
COUNT(employe.salaire) AS `nombre de salaires renseignés`, 
COUNT(employe.tauxcom) AS `nombre de taux de commission renseignés` 
FROM 
employe
WHERE 
employe.salaire IS NOT NULL 
OR 
employe.tauxcom IS NOT NULL;