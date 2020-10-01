<?php
    include '../templates/head.php'
    ?> <body class="indigo lighten-5">
    <header>
        <nav class="nav-extended indigo lighten-1">
            <div class="nav-wrapper">
                <a href="../../index.php" class="brand-logo"><img class="responsive-img" src="../../assets/img/icons8-logo-php-480.png"></a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="../initiation/ex1.php">Initiation</a></li>
                    <li><a href="../les_instructions_conditionnelles_et_les_boucles/ex1.php">conditions et boucles</a></li>
                    <li><a href="../les_tableaux/ex1.php">tableaux</a></li>
                    <li><a href="../les_fonctions/ex1.php">fonctions</a></li>
                    <li><a href="../les_dates_et_heures/ex1.php">dates et heures</a></li>
                    <li><a href="../les_fichiers/ex1.php">fichiers</a></li>
                    <li><a href="../serveur_et_formulaires/ex1.php">serveur & formulaires</a></li>
                    <li><a href="../connexion_aux_bdd_avec_PDO/db.php">DB & PDO</a></li>
                </ul>
            </div>
            <div class="nav-content">
                <ul class="tabs tabs-transparent">
                    <li class="tab"><a href="ex1.php">exercice 1</a></li>
                    <li class="tab"><a class="active" href="ex2.php">exercice 2</a></li>
                </ul>
            </div>
        </nav>
        <ul class="sidenav" id="mobile-demo">
            <li><a href="../initiation/ex1.php">Initiation</a></li>
            <li><a href="../les_instructions_conditionnelles_et_les_boucles/ex1.php">conditions et boucles</a></li>
            <li><a href="../les_tableaux/ex1.php">tableaux</a></li>
            <li><a href="../les_fonctions/ex1.php">fonctions</a></li>
            <li><a href="../les_dates_et_heures/ex1.php">dates et heures</a></li>
            <li><a href="../les_fichiers/ex1.php">fichiers</a></li>
            <li><a href="../serveur_et_formulaires/ex1.php">serveur & formulaires</a></li>
            <li><a href="../connexion_aux_bdd_avec_PDO/db.php">DB & PDO</a></li>
        </ul>
    </header>

    <main>
        <div class="container">
            <div class="row">
                <div class="card indigo lighten-2 center-align col s12">
                    <div class="card-content white-text">
                        <span class="card-title">
                            <p class="flow-text">Upload un fichier.</p>
                        </span>
                    </div>
                </div>
            </div>


            <div class="row">

                <div class="card-panel indigo lighten-3 col s12">
                    <div class="card-content white-text">
                        <pre><code>&lt;form class="col s12" id="form" action="ex2.php" method="POST" enctype="multipart/form-data"&gt;
&lt;!-- on ajoute l'attribut enctype &agrave; la balise &lt;form&gt; avec l'attribut multipart/form-data --&gt;
    &lt;div class="section"&gt;
        &lt;legend class="flow-text indigo-text"&gt;
        Envoyez-nous vos images
        &lt;/legend&gt;
        &lt;div class="row"&gt;
            &lt;div class="input-field"&gt;
                &lt;input class="col s12" type="file" name="userfile"&gt; &lt;!-- on ajoute un champ de type file qui fera appara&icirc;tre un bouton contenant le texte Parcourir avec lequel on pourra choisir un fichier pr&eacute;sent sur le PC --&gt;
            &lt;/div&gt;
        &lt;/div&gt;
        &lt;div class="row"&gt;
            &lt;button class="btn waves-effect wave-light indigo btn-small" id="submit" type="submit"&gt;Envoyer le fichier&lt;/button&gt;
        &lt;/div&gt;
    &lt;/div&gt;
&lt;/form&gt;</code></pre>
<pre><code>
$uploaddir = "uploads/";
$uploadfile = $uploaddir . basename($_FILES["userfile"]["name"]);

if (move_uploaded_file($_FILES['userfile']['tmp_name'], $uploadfile)) {
    echo "Le fichier est valide, et a &eacute;t&eacute; t&eacute;l&eacute;charg&eacute; avec succ&egrave;s. Voici plus d'informations :\n";
} else {
    echo "Attaque potentielle par t&eacute;l&eacute;chargement de fichiers. Voici plus d'informations :\n";
}

print_r($_FILES);</code></pre>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="card indigo lighten-5 center-align col s12">
                    <div class="card-content indigo-text">
                        <form class="col s12" id="form" action="ex2.php" method="POST" enctype="multipart/form-data">
                            <!-- on ajoute l'attribut enctype à la balise <form> avec l'attribut multipart/form-data -->
                            <div class="section">
                                <legend class="flow-text indigo-text">
                                    Envoyez-nous vos images
                                </legend>
                                <div class="row">
                                    <div class="input-field">
                                        <input class="col s12" type="file" name="userfile"> <!-- on ajoute un champ de type file qui fera apparaître un bouton contenant le texte Parcourir avec lequel on pourra choisir un fichier présent sur le PC -->
                                    </div>
                                </div>
                                <div class="row">
                                    <button class="btn waves-effect wave-light indigo btn-small" id="submit" type="submit">Envoyer le fichier</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card indigo lighten-5 center-align col s12">
                    <div class="card-content indigo-text">
                        <p class="flow-text">
                            <?php
                            $uploaddir = "uploads/";
                
                            $uploadfile = $uploaddir . basename($_FILES["userfile"]["name"]);
                            if (move_uploaded_file($_FILES['userfile']['tmp_name'], $uploadfile)) {
                                echo "Le fichier est valide, et a été téléchargé
                                       avec succès. Voici plus d'informations :\n";
                            } else {
                                echo "Attaque potentielle par téléchargement de fichiers.
                                      Voici plus d'informations :\n";
                            }

                            print_r($_FILES);
                            ?>
                        </p>
                    </div>
                </div>
            </div>

        </div>
    </main>

    <?php
    include '../templates/footer.php'
    ?>