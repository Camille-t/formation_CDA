<?php
if (file_exists('head.php')) {
    include 'head.php';
} else {
    echo 'problème de chargement du head';
}

if (file_exists('header.php')) {
    include 'header.php';
} else {
    echo 'problème de chargement du header';
}
require '../controller/artists_list_script.php';
require '../controller/disc_idController.php';
require '../controller/detailsController.php';
?>
<!-- Since we stay on the same view (details) to perform both update and delete actions on the db
we need to add a condition whether the value of the form submit button is either 'update' or 'delete' in order to display the right confirmation message (on the view).
We will also add the same condition on our PHP script in the controller (detailsController).
This way we will be able to trigger the right SQL query for both updating and deletting a disc in the db. -->

<main class='container'>
    <?php
    if (isset($_POST['update']) && (count($formError) == 0)) { // if the user clicks on the 'delete' named submit button of the view's form and that the controllers
    ?>
        <p>Les modifications ont bien été enregistrées.</p>
        <a href='../index.php' title='retour à la liste des disques' class='btn waves-effect waves-light pink darken-4 blue-grey-text text-lighten-5'>Retour
            <i class='material-icons right'>arrow_back</i>
        </a>
    <?php
    } else if (isset($_POST['delete'])) { // if the user clicks on the 'delete' named submit button of the modal's form
    ?>
        <p>Le disque a bien été supprimé de la base de données.</p>
        <a href='../index.php' title='retour à la liste des disques' class='btn waves-effect waves-light pink darken-4 blue-grey-text text-lighten-5'>Retour
            <i class='material-icons right'>arrow_back</i>
        </a>
    <?php
    } else {
    ?>
        <h1 class='flow-text'>Details</h1>
        <div class='row'>
            <form class='col s12' action='#' method='POST' enctype='multipart/form-data'>
                <!-- send form-data encoded as multipart/form-data -->
                <input type='hidden' value='<?= $disc->disc_id ?>' name='disc_id'>
                <div class='row'>
                    <div class='input-field col s12 m6'>
                        <label for='disc_title'>Title</label>
                        <input id='disc_title' name='disc_title' type='text' value='<?= isset($_POST['disc_title']) ? $_POST['disc_title'] : $disc->disc_title ?>'>
                        <span class='error'><?= isset($formError['disc_title']) ? $formError['disc_title'] : '' ?></span>
                    </div>
                    <div class='input-field col s12 m6'>
                        <div>
                            <label for='artist_id'>Artist</label>
                            <span class='error'><?= isset($formError['artist_id']) ? $formError['artist_id'] : '' ?></span>
                        </div>
                        <select name='artist_id'>
                            <option value='<?= $disc->artist_id ?>' selected><?= $disc->artist_name ?></option>
                            <?php
                            foreach ($artistsList as $artist) : ?>
                                <option value='<?= $artist->artist_id ?>' <?= isset($_POST['artist_id']) && $_POST['artist_id'] == $artist->artist_id ? 'selected' : '' ?>><?= $artist->artist_name ?></option>
                            <?php endforeach; ?>
                        </select>
                    </div>
                </div>
                <div class='row'>
                    <div class='input-field col s12 m6'>
                        <label for='disc_year'>Year</label>
                        <input id='disc_year' name='disc_year' type='text' value='<?= isset($_POST['disc_year']) ? $_POST['disc_year'] : $disc->disc_year ?>'>
                        <span class='error'><?= isset($formError['disc_year']) ? $formError['disc_year'] : '' ?></span> <!-- if there is an error in the $formError array we display it in the span field -->
                    </div>
                    <div class='input-field col s12 m6'>
                        <label for='disc_genre'>Genre</label>
                        <input id='disc_genre' name='disc_genre' type='text' value='<?= isset($_POST['disc_genre']) ? $_POST['disc_genre'] : $disc->disc_genre ?>'>
                        <span class='error'><?= isset($formError['disc_genre']) ? $formError['disc_genre'] : '' ?></span>
                    </div>
                </div>
                <div class='row'>
                    <div class='input-field col s12 m6'>
                        <label for='disc_label'>Label</label>
                        <input id='disc_label' name='disc_label' type='text' value='<?= isset($_POST['disc_label']) ? $_POST['disc_label'] : $disc->disc_label ?>'>
                        <span class='error'><?= isset($formError['disc_label']) ? $formError['disc_label'] : '' ?></span>
                    </div>
                    <div class='input-field col s12 m6'>
                        <label for='disc_price'>Price</label>
                        <input id='disc_price' name='disc_price' type='text' value='<?= isset($_POST['disc_price']) ? $_POST['disc_price'] : $disc->disc_price ?>'>
                        <span class='error'><?= isset($formError['disc_price']) ? $formError['disc_price'] : '' ?></span>
                    </div>
                </div>
                <div class='row'>
                    <div class='file-field input-field col s12'>
                        <div>
                            <label for='disc_picture'>Picture</label>
                        </div>
                        <div class='btn-small grey lighten-2 col s7 m3 grey-text'>
                            <span>Insérer une photo</span>
                            <input id='disc_picture' name='picture' type='file'> <!-- we will use the name attribute ('picture') of the file input to trigger both verification script, uploading the file in the system and updating the db-->
                        </div>
                        <div class='file-path-wrapper'>
                            <input class='file-path validate' type='text'>
                        </div>
                        <span class='info'>Au format .gif, .jpg, .jpeg, .pjpeg ou .png</span>
                        <span class='error'><?= isset($formError['disc_picture']) ? $formError['disc_picture'] : '' ?></span>
                    </div>
                </div>
                <div class='row'>
                    <div class='input-field col s12 m6'>
                        <img class='responsive-img' src='../assets/img/<?= isset($_POST['disc_picture']) ? $_POST['disc_picture'] : $disc->disc_picture ?>'></img>
                    </div>
                </div>
                <div class='row'>
                    <div class='row'>
                        <button class='btn waves-effect waves-light orange col s9 m5 l4 offset-s1 offset-m3 offset-l4' type='submit' name='update'>Valider les modifications
                            <i class='material-icons right'>edit</i>
                        </button>
                    </div>
                    <div class='row'>
                        <!-- Modal Trigger -->
                        <a class='btn modal-trigger waves-effect waves-light red col s9 m5 l4 offset-s1 offset-m3 offset-l4' href='#deleteModal<?= $disc->disc_id ?>'>Supprimer
                            <i class='material-icons right'>delete_forever</i>
                        </a>
                    </div>
                    <div class='row'>
                        <a class='btn waves-effect waves-light green col s9 m5 l4 offset-s1 offset-m3 offset-l4' title='retour à la liste des disques' href='../index.php'>Retour
                            <i class='material-icons right'>arrow_back</i>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    <?php
    }
    if (isset($disc->disc_id)) {
    ?>
        <!-- Modal Structure -->
        <div class='modal' id='deleteModal<?= $disc->disc_id ?>'>
            <div class='modal-content'>
                <h1>Attention</h1>
                <p>Vous êtes sur le point de supprimer défintivement un disque de la base de données.</p>
                <p>Etes-vous sûr de vouloir le supprimer?</p>
            </div>
            <div class='modal-footer row'>
                <form action='#' method='POST'>
                    <div class='col s10 m7'>
                        <button href='!#' class='modal-close waves-effect waves-green green btn' alt='annuler la supression'>Annuler la supression du disque</button>
                    </div>
                    <div class='col s12 m4'>
                        <button href='!#' class='modal-close waves-effect waves-red red btn' type='submit' name='delete' alt='supprimer définitivement le disque de la base de données'>Supprimer définitivement</button>
                    </div>
                </form>
            </div>
        </div>
</main>
<?php
    }
    if (file_exists('footer.php')) {
        include 'footer.php';
    } else {
        echo 'problème de chargement du footer';
    }
?>