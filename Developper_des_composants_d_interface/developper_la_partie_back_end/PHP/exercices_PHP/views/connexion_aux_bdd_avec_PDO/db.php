<?php
include '../templates/head.php'
?>

<body class="indigo lighten-5">
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
                    <li class="tab"><a class="active" href="ex1.php">exemple 1</a></li>
                    <li class="tab"><a href="details_disc.php">exemple 2</a></li>
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
                            <p class="flow-text">Connexion à la BDD et requête</p>
                        </span>
                        <p class="flow-text">Une fois connectés à la base, affichez les différents artistes.</p>
                    </div>
                </div>

            </div>


            <div class="row">

                <div class="card-panel indigo lighten-3 col s12">
                    <div class="card-content white-text">
                        <pre><code>try {
 // on se connecte &agrave; MySQL
 $db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', '');
 } catch (Exception $e) {
 // en cas d'erreur, on affiche un message et on arr&ecirc;t tout
 die('Erreur : ' . $e-&gt;getMessage());
 }
 // si tout va bien, on peut continuer

 // on r&eacute;cup&egrave;re tout le contenu de la table artist
 $answer = $db-&gt;query('SELECT * FROM disc');

 // on passe dans un tableau les donn&eacute;es r&eacute;cup&eacute;r&eacute;es gr&acirc;ce &agrave; fetchAll()
 $array = $answer-&gt;fetchAll(PDO::FETCH_OBJ);
 $answer-&gt;closeCursor();

 // on utilise une boucle foreach pour parcourir toutes les donn&eacute;es 
 foreach ($array as $disc) : ?&gt;
 &lt;div&gt;
 &lt;?= $disc-&gt;disc_title ?&gt;
 &lt;/div&gt;
 &lt;?php endforeach; ?&gt;</code></pre>
                    </div>
                </div>

            </div>


            <div class="row">
                <div class="card indigo lighten-4 center-align col s12">
                    <div class="card-content">
                        <p class="flow-text">
                            <?php
                            try {
                                // on se connecte à MySQL
                                $db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', '');
                            } catch (Exception $e) {
                                // en cas d'erreur, on affiche un message et on arrêt tout
                                die('Erreur : ' . $e->getMessage());
                            }
                            // si tout va bien, on peut continuer

                            // on récupère tout le contenu de la table artist
                            $answer = $db->query('SELECT * FROM disc');

                            // on passe dans un tableau les données récupérées grâce à fetchAll()
                            $array = $answer->fetchAll(PDO::FETCH_OBJ);
                            $answer->closeCursor();

                            // on utilise une boucle foreach pour parcourir toutes les données 
                            foreach ($array as $disc) : ?>
                                <div>
                                    <?= $disc->disc_title ?>
                                </div>
                            <?php endforeach; ?>
                        </p>
                    </div>
                </div>
            </div>

        </div>
    </main>

    <?php
    include '../templates/footer.php'
    ?>




   