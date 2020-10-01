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
                                        <li class="tab"><a href="ex1.php">exercice 1</a></li>
                                        <li class="tab"><a href="ex2.php">exercice 2</a></li>
                                        <li class="tab"><a href="ex3.php">exercice 3</a></li>
                                        <li class="tab"><a class="active" href="ex4.php">exercice 4</a></li>
                                        <li class="tab"><a href="ex5.php">exercice 5</a></li>
                                        <li class="tab"><a href="ex6.php">exercice 6</a></li>
                                        <li class="tab"><a href="ex7.php">exercice 7</a></li>

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
                                                        <p class="flow-text">Montrez que la date du 32/17/2019 est erronée.</p>
                                                </span>
                                        </div>
                                </div>

                        </div>


                        <div class="row">

                                <div class="card-panel indigo lighten-3 col s12">
                                        <div class="card-content white-text">
                                                <pre><code>$date = DateTime::createFromFormat("d-m-Y", "32-17-2019");
$tableau = DateTime::getLastErrors(); // on récupère les erreurs de l'objet DateTime grâce à DateTime::getLastErrors (sous forme de tableau)
//var_dump($tableau);

if ($tableau["error_count"]&gt;0 || $tableau["warning_count"]&gt;0) { // si le tableau renvoyé comporte une ou plusieurs erreurs(error) OU un ou plusieurs avertissements(warning)
        foreach($tableau["warnings"] as $warning) { // on affiche la valeur du sous-tableau warning() = chaîne 
        echo $warning;
        }
        foreach($tableau["errors"] as $errors) { // on affiche la valeur du sous-tableau error()
        echo $errors;
        }
}</code></pre>
                                        </div>
                                </div>

                        </div>


                        <div class="row">
                                <div class="card indigo lighten-3 center-align col s12">
                                        <div class="card-content white-text">
                                                <p class="flow-text">
                                                        <?php
                                                        $date = DateTime::createFromFormat("d-m-Y", "32-17-2019"); 
                                                        $tableau = DateTime::getLastErrors(); // on récupère les erreurs de l'objet DateTime grâce à DateTime::getLastErrors (sous forme d'un tableau qui comportent le nombres d'error et de warning et les messages associés)
                                                        //var_dump($tableau);
                                                        if ($tableau["error_count"]>0 || $tableau["warning_count"]>0) { // si le tableau renvoyé comporte une ou plusieurs erreurs(error) OU un ou plusieurs avertissements(warning)
                                                                foreach($tableau["warnings"] as $warning) { // on affiche la valeur du sous-tableau warning() = chaîne  
                                                                        echo $warning;
                                                                }
                                                                foreach($tableau["errors"] as $errors) { // on affiche la valeur du sous-tableau error()
                                                                        echo $errors;
                                                                }
                                                        } 
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