<?php
$dsn = 'mysql:host=localhost;dbname=ctoulisse;charset=utf8'; //DSN, contains the information required to connect to the database.
$user = 'ctoulisse'; //the name of the db's user
$password = '19141ct'; //the password of the db's user
$options = [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]; 
// sets attributes on the database handle :
// PDO::ERRMODE_EXCEPTION : error reporting; throw exceptions (errors raised by PDO)

try { // the try block contains the code that may potentially throw an eception. All of the code within the try block is executed until an exception is potentially thrown.
    $db = new PDO($dsn, $user, $password, $options); // Creates a PDO instance ($db) representing a connection to the requested database.
} catch (Exception $e) { // this block of code will be called if an exception occurs within the try code block. The code within the catch statement handles the exception that could be thrown.
    echo 'erreur :' . $e->getMessage() . '<br>'; // displays the error message of the exception
    echo 'N° : ' . $e->getCode(); // displays the error code of the exception
    die('fin du script'); // ends script
}



