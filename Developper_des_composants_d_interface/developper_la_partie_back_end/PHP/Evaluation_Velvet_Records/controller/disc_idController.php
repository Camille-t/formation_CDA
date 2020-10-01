<?php
require '../model/model.php'; // PDO (connexion between PHP and db server)
$disc_id = $_GET['disc_id']; // We will start by retrieving the product id that we have previously passed to the url using the $_GET method, allowing us to retrieve information passed in the url
// Once connexion to db is made, we will execute an SQL statement using prepare statement that will prepare a statement for execution and return a statement object.
// The statement template contains a named (:name) parameter marker for which real value of disc_id will be substituted when the statement is executed.
$query = 'SELECT * FROM disc JOIN artist ON disc.artist_id = artist.artist_id WHERE disc_id = :disc_id'; // SQL statement will retrieve all datas from disc table fuflfilling the disc_id specified condition.
$result = $db->prepare($query); // prepares the SQL statement.
$result->bindValue(':disc_id', $disc_id, PDO::PARAM_INT); // we bind(link) the disc_id value to our named parameter marker using bindValue() statement. We also explicit the data type for this parameter(INT).
$result->execute(); // executes the SQL statement.
$disc = $result->fetch(PDO::FETCH_OBJ); // fetches one row from the result set associated to the PDOStatement object.
$result->closeCursor(); // frees up the connection to the server so that other SQL statements may be issued.


