USE papyrus;

CREATE USER 'util1'@'%' IDENTIFIED BY 'mot_de_passe1'; -- on créé 3 utilisateurs pour la base papyrus
CREATE USER 'util2'@'%' IDENTIFIED BY 'mot_de_passe2';
CREATE USER 'util3'@'%' IDENTIFIED BY 'mot_de_passe3';

GRANT ALL PRIVILEGES ON papyrus.* TO 'util1'@'%' -- util1 peut effectuer toutes les opérations sur papyrus
IDENTIFIED BY 'mot_de_passe1';

GRANT SELECT -- util2 ne peut que sélectionner les informations dans la base papyrus
ON papyrus.*
TO util2
IDENTIFIED BY 'mot_de_passe2';

GRANT SELECT -- util3 n'a aucun droit sur la base de données, sauf d'afficher la table FOURNIS
ON papyrus.FOURNIS
TO util3
IDENTIFIED BY 'mot_de_passe3';