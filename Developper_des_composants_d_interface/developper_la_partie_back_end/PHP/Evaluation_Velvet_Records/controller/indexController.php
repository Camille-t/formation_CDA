<?php
require 'model/model.php'; // PDO (connexion between PHP and db server)
$query = 'SELECT * FROM disc JOIN artist ON disc.artist_id=artist.artist_id'; // SQL statement that will retrieve all datas from disc table and join the artist table to fetch the artist_name value
$result = $db->query($query); // PDO::query executes the SQL statement, returning a result set as a PDOStatement object.
$discsList = $result->fetchAll(PDO::FETCH_OBJ); // PDOSatement::fetchAll returns an array containing all of the result set rows (every discs)
$count = count($discsList); // count() function gets the number of elements or values in an array (number of discs in our db)
$result->closeCursor(); // frees up the connection to the server so that other SQL statements may be issued.
// Having several rows to display (every discs), we will use a foreach() loop to browse each column of each row.
