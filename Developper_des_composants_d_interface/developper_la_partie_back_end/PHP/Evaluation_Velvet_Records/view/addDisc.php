<?php
require '../controller/artists_list_script.php';
require '../controller/addDiscController.php';

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
?>
<main class='container'>
    <?php
    if (isset($_POST['add']) && (count($formError) == 0)) {
    ?>
        <p class='rock'>Le nouveau disque a bien été enregistré dans la base de données.</p>
        <a href='../index.php' title='retour à la liste des disques' class='btn waves-effect waves-light pink darken-4 blue-grey-text text-lighten-5'>Retour
            <i class='material-icons right'>arrow_back</i>
        </a>
    <?php
    } else {
    ?>
    <div class='row'>
        <form class='col s12' action='<?php print $_SERVER['PHP_SELF'] ?>' method='POST' enctype='multipart/form-data'>
            <fieldset>
                <legend class='flow-text'>Ajouter un vinyle</legend>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <label for='disc_title'>Title</label>
                            <input placeholder='Enter title' id='disc_title' name='disc_title' type='text' value='<?= isset($_POST['disc_title']) ? $_POST['disc_title'] : '' ?>'>
                            <span class='error'><?= isset($formError['disc_title']) ? $formError['disc_title'] : '' ?></span>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <div>
                                <label for='artist_id'>Artist</label>
                                <span class='error'><?= isset($formError['artist_id']) ? $formError['artist_id'] : '' ?></span>
                            </div>
                            <select name='artist_id'>
                                <option class='pink-text text-darken-4' value='choose_artist' disabled selected>Choose artist</option>
                                <?php foreach ($artistsList as $artist) : ?>
                                    <option class='pink-text text-darken-4' value='<?= $artist->artist_id ?>' <?= isset($_POST['artist_id']) && $_POST['artist_id'] == $artist->artist_id ? 'selected' : '' ?>><?= $artist->artist_name ?></option>
                                <?php endforeach; ?>
                            </select>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <label for='disc_year'>Year</label>
                            <input placeholder='Enter year' id='disc_year' name='disc_year' type='text' value='<?= isset($_POST['disc_year']) ? $_POST['disc_year'] : '' ?>'>
                            <span class='error'><?= isset($formError['disc_year']) ? $formError['disc_year'] : '' ?></span>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <label for='disc_genre'>Genre</label>
                            <input placeholder='Enter genre (Rock, Pop, Prog ...)' id='disc_genre' name='disc_genre' type='text' value='<?= isset($_POST['disc_genre']) ? $_POST['disc_genre'] : '' ?>'>
                            <span class='error'><?= isset($formError['disc_genre']) ? $formError['disc_genre'] : '' ?></span>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <label for='disc_label'>Label</label>
                            <input placeholder='Enter label (EMI, Warner, PolyGram, Univers sale...)' id='disc_label' name='disc_label' type='text' value='<?= isset($_POST['disc_label']) ? $_POST['disc_label'] : '' ?>'>
                            <span class='error'><?= isset($formError['disc_label']) ? $formError['disc_label'] : '' ?></span>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <label for='disc_price'>Price</label>
                            <input id='disc_price' name='disc_price' type='text' value='<?= isset($_POST['disc_price']) ? $_POST['disc_price'] : '' ?>'>
                            <span class='error'><?= isset($formError['disc_price']) ? $formError['disc_price'] : '' ?></span>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='file-field input-field col s12'>
                            <div>
                                <label for='disc_picture'>Picture</label>
                            </div>
                            <div class='btn-small grey lighten-2 col s7 m3 grey-text'>
                                <span>Choisir un fichier</span>
                                <input id='disc_picture' name='picture' type='file'>
                            </div>
                            <div class='file-path-wrapper'>
                                <input class='file-path validate' type='text'>
                            </div>
                            <span class='info'>Au format .gif, .jpg, .jpeg, .pjpeg ou .png</span>
                            <span class='error'><?= isset($formError['disc_picture']) ? $formError['disc_picture'] : '' ?></span>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='input-field col s12'>
                            <button class='btn waves-effect waves-light pink darken-4 blue-grey-text text-lighten-5' type='submit' name='add'>Ajouter
                                <i class='material-icons right'>add_circle</i>
                            </button>
                            <a class='btn waves-effect waves-light pink darken-1 blue-grey-text text-lighten-5' title='retour à la liste des disques' href='../index.php'>Retour
                            <i class='material-icons right'>arrow_back</i></a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
</main>
<?php
        if (file_exists('footer.php')) {
            include 'footer.php';
        } else {
            echo 'problème de chargement du footer';
        }
    }
?>