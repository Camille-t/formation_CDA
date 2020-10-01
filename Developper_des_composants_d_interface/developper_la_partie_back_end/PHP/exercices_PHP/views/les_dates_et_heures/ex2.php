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
                    <li class="tab"><a class="active" href="ex2.php">exercice 2</a></li>
                    <li class="tab"><a href="ex3.php">exercice 3</a></li>
                    <li class="tab"><a href="ex4.php">exercice 4</a></li>
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
                                                <p class="flow-text">Combien reste-t-il de jour avant la fin de votre formation?</p>
                                        </span>
                                </div>
                        </div>

                </div>


                <div class="row">

                        <div class="card-panel indigo lighten-3 col s12">
                                <div class="card-content white-text">
                                        <pre><code></code></pre>
                                </div>
                        </div>

                </div>


                <div class="row">
                        <div class="card indigo lighten-3 center-align col s12">
                                <div class="card-content white-text">
                                        <p class="flow-text">
                                                <?php
                                                date_default_timezone_set("Europe/Paris");
                                                $dateFinFormation = new DateTime("25-09-2020"); // on passe dans une variable la date de fin de formation en objet DateTime (classe)
                                                $dateDuJour = new DateTime(); // on passe dans una variable la date du jour en objet DateTime
                                                

                                                $nombreDeJours = date_diff($dateDuJour,$dateFinFormation); // date_diff() retourne la différence entre deux objets DateTimeInterface
                                                echo $nombreDeJours->format("%a jours"); // formate l'intervalle obtenue grâce à date_diff

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