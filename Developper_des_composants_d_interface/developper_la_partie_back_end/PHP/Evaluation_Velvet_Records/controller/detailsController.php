<?php
require '../model/model.php'; // PDO (connexion between PHP and db server)

$disc_id = $_GET['disc_id']; // We catch the disc_id value through $_GET

// DELETE DISC
if (isset($_POST['delete'])) { // if user clicks on the modal's form 'delete' named submit button we trigger the SQL query the will delete the disc in the db
    $query = 'DELETE FROM disc WHERE disc_id = :disc_id';
    $result = $db->prepare($query);
    $result->bindValue(':disc_id', $disc_id, PDO::PARAM_INT);
    return $result->execute();
}



$formError = array(); // we declare an array of error recovery that will display error messages to the user in the form
$textPattern = '/^[\w\-\,\.\:\!\"\/ éèàùçâêîôûäëïöü#&]+$/'; // we define our RegexP pattern to make sure that the user won't try to make SQL injections with the value he enters in the input   
$datePattern = '/^[\d]{4}+$/';
$pricePattern = '/^[\d]+[.|,]{0,1}[\d]{0,2}+$/';
$extension = ''; // the picture file extension

// DISC UPDATE
if (isset($_POST['update'])) { // if user clicks on 'update' named submit button of the 'details' view's form
    // we check the value of the disc_title input
    if (!empty($_POST['disc_title'])) { // if the dsic_title input is not empty
        if (preg_match($textPattern, $_POST['disc_title'])) { // we check that the input value passes the Regexp pattern using preg_match function(). If it's ok,
            $disc_title = $_POST['disc_title']; // we use $_POST to pass the disc_title value form the form to the db.
        } else {
            $formError['disc_title'] = 'Veuillez renseigner un titre de disque valide.'; // if the user's input value doesn't pass the pattern we use the $formError array to display an error message 
            // we DO NOT pass the disc_title value from the form to the db through the SQL query because it may contain script tags that could cause SQL injection
        }
    } else {
        $formError['disc_title'] = 'Veuillez renseigner le titre du disque.'; // if the disc_title input is left empty by the user we use the $formError array to display an error message
    }

    // the value of the artist_id input is determined by the SELECT tag
    $artist_id = $_POST['artist_id'];

    // we check the value of the disc_year input
    if (!empty($_POST['disc_year'])) {
        if (preg_match($datePattern, $_POST['disc_year'])) {
            $disc_year = $_POST['disc_year'];
        } else {
            $formError['disc_year'] = 'Veuillez renseigner une année valide.';
        }
    } else {
        $formError['disc_year'] = 'Veuillez renseigner l&#039année de sortie du disque.';
    }
    // we check the value of the disc_genre 
    if (!empty($_POST['disc_genre'])) {
        if (preg_match($textPattern, $_POST['disc_genre'])) {
            $disc_genre = $_POST['disc_genre'];
        } else {
            $formError['disc_genre'] = 'Veuillez renseigner un genre musical valide.';
        }
    } else {
        $formError['disc_genre'] = 'Veuillez renseigner le genre musical du disque.';
    }
    // we check the value of the disc_label input
    if (!empty($_POST['disc_label'])) {
        if (preg_match($textPattern, $_POST['disc_label'])) {
            $disc_label = $_POST['disc_label'];
        } else {
            $formError['disc_label'] = 'Veuillez renseigner un label valide.';
        }
    } else {
        $formError['disc_label'] = 'Veuillez renseigner le label du disque.';
    }

    // we check the value of the disc_price input
    if (!empty($_POST['disc_price'])) {
        if (preg_match($pricePattern, $_POST['disc_price'])) {
            $disc_price = $_POST['disc_price'];
        } else {
            $formError['disc_price'] = 'Veuillez renseigner un prix valide.';
        }
    } else {
        $formError['disc_price'] = 'Veuillez renseigner le prix du disque.';
    }

    // we check the UPLOAD of the disc_picture...
    if ($_FILES['picture']['name'] != '' && count($formError) == 0) { // if the 'picture' named file upload field is not empty
        // we can check that the file's type is accepted
        $aMimeTypes = array('image/gif', 'image/jpg', 'image/jpeg', 'image/pjpeg', 'image/png', 'image/x-png', 'image/tiff'); // we define the types of files accepted
        $finfo = finfo_open(FILEINFO_MIME_TYPE); // the file type is extracted with the FILEINFO extension. It returns the file's mime type in the finfo variable.
        $mimetype = finfo_file($finfo, $_FILES['picture']['tmp_name']); // we retrieve the mime type from the file and store it in a $mimetype variable.
        finfo_close($finfo);
        if (in_array($mimetype, $aMimeTypes)) { // with in_array() function we check if the $mimetype variable exists in the $aMimeTypes array that we declared earlier
            $extension = pathinfo($_FILES['picture']['name'], PATHINFO_EXTENSION); // we retrieve the file extension and store it in a $extension variable.
            $upload_dir = '../assets/img/'; // we store the destination path of the file in a $upload_dir variable.
            $_FILES['picture']['name'] = $disc_title; // we rename the picture (using the disc_title field).
            $upload_file = $upload_dir . $_FILES['picture']['name'] . '.' . $extension; // we indicate the destination of the file and also its complete name (disc_title + extension)
            move_uploaded_file($_FILES['picture']['tmp_name'], $upload_file); // moves file and overwrites old picture if the destination file already exists (same name = same extension file type)
            $disc_picture = $disc_title . '.' . $extension;
            // we execute a prepared SQL query that will update the picture name in the db
            $query = 'UPDATE disc SET disc_picture = :new_disc_picture WHERE disc_id = :disc_id';
            $result = $db->prepare($query);
            $result->bindValue(':disc_id', $disc_id, PDO::PARAM_INT);
            $result->bindValue(':new_disc_picture', $disc_picture, PDO::PARAM_STR);
            $result->execute();
            $result->closeCursor();
        } else { // if the type of file is incorrect
            $formError['disc_picture'] = 'Format de fichier incorrect. Veuillez insérer une autre photo'; // we display an error message that will inform user that the file he tried to upload is not valid
        }
    }
    // if the $formError array is empty...
    if (count($formError) == 0) { //... we execute a prepared sql query that will update the entire disc table (except the disc_picture field wich we deal with separatly)
        $query = 'UPDATE disc SET disc_title = :new_disc_title, artist_id = :new_artist_id, 
        disc_year = :new_disc_year, disc_label = :new_disc_label, disc_genre = :new_disc_genre, disc_price = :new_disc_price 
        WHERE disc_id = :disc_id';
        $result = $db->prepare($query);
        $result->bindValue(':disc_id', $disc_id, PDO::PARAM_INT);
        $result->bindValue(':new_disc_title', $disc_title, PDO::PARAM_STR);
        $result->bindValue(':new_artist_id', $artist_id, PDO::PARAM_INT);
        $result->bindValue(':new_disc_year', $disc_year, PDO::PARAM_STR);
        $result->bindValue(':new_disc_label', $disc_label, PDO::PARAM_STR);
        $result->bindValue(':new_disc_genre', $disc_genre, PDO::PARAM_STR);
        $result->bindValue(':new_disc_price', $disc_price);
        $result->execute();
        $result->closeCursor();
    }
}
