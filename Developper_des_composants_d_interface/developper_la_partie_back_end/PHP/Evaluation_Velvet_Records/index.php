<?php
// require statement is identical to include except upon failure it will also halt the script whereas include only emits a warning wich alllows the script to continue.
require 'controller/indexController.php'; // controller used to fetch the discs_list
?>
<!DOCTYPE html>
<html lang='fr'>

<head>
    <meta charset='UTF-8'>
    <title>liste</title>
    <link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rock+Salt&display=swap'>
    <link rel='stylesheet' href='assets/css/materialize.css'>
    <link rel='stylesheet' href='assets/css/style.css'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
</head>

<body class='#eceff1 blue-grey lighten-5'>
    <header>
        <div class='navbar-fixed'>
            <div class='nav-wrapper'>
                <nav class='blue-grey darken-4 valign-wrapper'>
                    <a href='#!' class='rock flow-text brand-logo center pink-text text-darken-4' id='velvet_record'>VELVET RECORDS</a>
                    <a href='#' data-target="mobile-demo" class='sidenav-trigger'><i class='material-icons pink-text text-darken-4'>menu</i></a>
                    <ul class='right hide-on-med-and-down' id='nav_mobile'>
                        <li><a href='view/addDisc.php' class='rock blue-grey-text text-lighten-5'>Ajouter un disque</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <ul class='rock sidenav blue-grey lighten-5' id='mobile-demo'>
            <li><a href='view/addDisc.php'>Ajouter un disque</a></li>
        </ul>
    </header>

    <main class='container'>
        <div class='row'>
            <div class='col s12 valign-wrapper'>
                <h1 class='rock flow-text col s7 m9 l10 blue-grey-text text-darken-4'>Liste des disques (<?= $count ?>)</h1>
                <a class='btn waves-effect waves-light pink darken-4 blue-grey-text text-lighten-5' href='view/addDisc.php'>Ajouter<i class='material-icons right'>edit</i></a> <!-- ici, on ajoute un lien vers le formulaire d'ajout add_form.php  -->
            </div>
        </div>
        <div class='row'>
            <?php foreach ($discsList as $disc) : ?>
                <!-- We use a foreach loop to go through the entries one by one.-->
                <div class='col s12 m6 l4'>
                    <div class='card large blue-grey lighten-3'>
                        <div class='card-image blue-grey lighten-3'>
                            <img class='cardImg' title='photo du disque' alt='photo du disque' src='assets/img/<?= $disc->disc_picture ?>'>
                        </div>
                        <div class='card-content'>
                            <p id='title'><?= $disc->disc_title ?></p>
                            <p id='artist'><?= $disc->artist_name ?></p>
                            <p><?= $disc->disc_label ?></p>
                            <p><?= $disc->disc_year ?></p>
                            <p><?= $disc->disc_genre ?></p>
                        </div>
                        <div class='card-action blue-grey lighten-3 center-align'>
                            <a href='view/details.php?disc_id=<?= $disc->disc_id ?>' title='lien vers la fiche détaillée d&#039un disque' alt='lien vers la fiche détaillée d&#039un disque'>
                                <button class='btn waves-effect waves-light pink darken-4 blue-grey-text text-lighten-5'>Détails
                                    <i class='material-icons right'>description</i>
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
            <?php endforeach; ?>
        </div>
    </main>
    <footer class='page-footer blue-grey darken-4'>
        <div class='container'>
            <div class='row'>
            </div>
        </div>
        <div class='footer-copyright'>
        </div>
    </footer>
    <script src='assets/js/materialize.js'></script>
    <script src='assets/js/script.js'></script>
</body>

</html>