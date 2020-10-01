<?php
require '../model/model.php'; // PDO (connexion between PHP and db server)
$query = 'SELECT * FROM artist ORDER BY artist_name';
$result = $db->query($query);
$artistsList = $result->fetchAll(PDO::FETCH_OBJ); 
$result->closeCursor();