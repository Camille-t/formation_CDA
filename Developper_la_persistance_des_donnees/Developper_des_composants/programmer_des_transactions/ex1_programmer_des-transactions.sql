/*
Tant qu'une transaction (débutée par l'instruction START TRANSACTION) n'est pas terminée par l'instruction COMMIT ou ROLLBACK, elle n'est pas définitive : les données ne sont pas modifiées dans la table si on effectue une requête d'interrogation avec une instruction SELECT depuis une nouvelle fenêtre de requête.
De plus, aucune modification (avec l'instruction UPDATE) n'est possible dans une autre fenêtre de requête tant que la transaction n'est pas terminée dans la première fenêtre de requête.
Pour rendre la modification permanente il faut terminer la transaction par une instruction COMMIT.
Tant que la transaction n'est pas validée par une instruction COMMIT, on peut l'annuler avec l'instruction ROLLBACK. 
*/