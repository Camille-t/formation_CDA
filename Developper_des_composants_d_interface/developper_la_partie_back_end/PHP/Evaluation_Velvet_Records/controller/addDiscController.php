<?php
require '../model/model.php'; // PDO (connexion between PHP and db server)

$formError = array(); // we declare an array of error recovery that will display error messages to the user in the form
$textPattern = '/^[\w\-\,\.\:\!\"\/ éèàùçâêîôûäëïöü#&]+$/'; // we define our RegexP pattern to make sure that the user won't try to make SQL injections with the value he enters in the input   
$datePattern = '/^[\d]{4}+$/';
$pricePattern = '/^[\d]+[.|,]{0,1}[\d]{0,2}+$/';
$extension = ''; // the picture file extension
$disc_id = '';

//ADD DISC
// we use $_POST superglobale variable to fetch the different form fields' values (the user inputs)
if (isset($_POST['add'])) { // if user clicks on 'add' named submit button of the 'addDisc' view's form
    // we check the value of the disc_title input
    if (!empty($_POST['disc_title'])) { // if the dsic_title input is not empty
        if (preg_match($textPattern, $_POST['disc_title'])) { // we check that the input value passes the Regexp pattern using preg_match function(). If it's ok,
            $disc_title = htmlspecialchars($_POST['disc_title']); // we  store the value in a variable ($disc_title) and we use htmlspecialchars() function in order to convert special characters (the user might have entered) into HTML entities and then prevent any SQL injection
        } else {
            $formError['disc_title'] = 'Veuillez renseigner un titre de disque valide.'; // if the user's input value doesn't pass the pattern we use the $formError array to display an error message 
            // we DO NOT pass the disc_title value from the form to the db through the SQL query because it may contain script tags that could cause SQL injection
        }
    } else {
        $formError['disc_title'] = 'Veuillez renseigner le titre du disque.'; // if the disc_title input is left empty by the user we use the $formError array to display an error message
    }

    //we check the value of the artist_id input
    if (!empty($_POST['artist_id'])) {
        $artist_id = htmlspecialchars($_POST['artist_id']);
    } else {
        $formError['artist_id'] = 'Veuillez sélectionner un artiste.';
    }

    // we check the value of the disc_year input
    if (!empty($_POST['disc_year'])) {
        if (preg_match($datePattern, $_POST['disc_year'])) {
            $disc_year = htmlspecialchars($_POST['disc_year']);
        } else {
            $formError['disc_year'] = 'Veuillez renseigner une année valide.';
        }
    } else {
        $formError['disc_year'] = 'Veuillez renseigner l&#039année de sortie du disque.';
    }
    // we check the value of the disc_genre 
    if (!empty($_POST['disc_genre'])) {
        if (preg_match($textPattern, $_POST['disc_genre'])) {
            $disc_genre = htmlspecialchars($_POST['disc_genre']);
        } else {
            $formError['disc_genre'] = 'Veuillez renseigner un genre musical valide.';
        }
    } else {
        $formError['disc_genre'] = 'Veuillez renseigner le genre musical du disque.';
    }
    // we check the value of the disc_label input
    if (!empty($_POST['disc_label'])) {
        if (preg_match($textPattern, $_POST['disc_label'])) {
            $disc_label = htmlspecialchars($_POST['disc_label']);
        } else {
            $formError['disc_label'] = 'Veuillez renseigner un label valide.';
        }
    } else {
        $formError['disc_label'] = 'Veuillez renseigner le label du disque.';
    }

    // we check the value of the disc_price input
    if (!empty($_POST['disc_price'])) {
        if (preg_match($pricePattern, $_POST['disc_price'])) {
            $disc_price = htmlspecialchars($_POST['disc_price']);
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
        // if the type of file is valid
        if (in_array($mimetype, $aMimeTypes)) { // with in_array() function we check if the $mimetype variable exists in the $aMimeTypes array that we declared earlier
            $extension = pathinfo($_FILES['picture']['name'], PATHINFO_EXTENSION); // we retrieve the file extension and store it in a $extension variable.
            $disc_picture = $disc_title . '.' . $extension;
        }
    } else { // 
        $formError['disc_picture'] = 'Vous devez ajouter une image pour enregistrer un nouveau disque';
    }
    if (count($formError) == 0) {
        $query = ('INSERT INTO disc(disc_id, disc_title, disc_picture, disc_year, disc_label, disc_genre, disc_price, artist_id) 
        VALUES(:disc_id, :disc_title, :disc_picture, :disc_year, :disc_label, :disc_genre, :disc_price, :artist_id)');
        $addDisc = $db->prepare($query);
        $addDisc->bindValue(':disc_id', $disc_id, PDO::PARAM_INT);
        $addDisc->bindValue(':disc_title', $disc_title, PDO::PARAM_STR);
        $addDisc->bindValue(':disc_picture', $disc_picture, PDO::PARAM_STR);
        $addDisc->bindValue(':disc_year', $disc_year, PDO::PARAM_INT);
        $addDisc->bindValue(':disc_label', $disc_label, PDO::PARAM_STR);
        $addDisc->bindValue(':disc_genre', $disc_genre, PDO::PARAM_STR);
        $addDisc->bindValue(':disc_price', $disc_price, PDO::PARAM_INT);
        $addDisc->bindValue(':artist_id', $artist_id, PDO::PARAM_INT);
        $addDisc->execute();
        $upload_dir = '../assets/img/'; // we store the destination path of the file in a $upload_dir variable.
        $_FILES['picture']['name'] = $disc_title; // we rename the picture (using the disc_title field).
        $upload_file = $upload_dir . $_FILES['picture']['name'] . '.' . $extension; // we indicate the destination of the file and also its complete name (disc_title + extension)
        move_uploaded_file($_FILES['picture']['tmp_name'], $upload_file); // moves file and overwrites old picture if the destination file already exists (same name = same extension file type)
    }
    else {
        $formError['error'] = 'Une erreur est survenue lors de l\'insertion du disque dans la base de données.';
    }
}

