/*  
Tant qu'une transaction n'est pas COMMITTED, un autre utilisateur ne peut pas lire les modifications apportées sur la ligne car par défaut le niveau d'isolement des requêtes de lecture sur cette transaction est COMMIT. 
En indiquant avant le début d'une transaction que le niveau d'isolement des requêtes de lecture (select) est UNCOMMITTED, un autre utilisateur (que celui qui écrit la transaction mais qui ne l'a pas encore validé par COMMIT) peut lire les données modifiées (avant qu'elles soient validées donc.)
*/