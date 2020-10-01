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
                <div class="card-panel indigo lighten-2 center-align col s12">
                    <div class="card-content white-text">
                        <span class="card-title">
                            <p class="flow-text">Capitales</p>
                        </span>
                        <p class="flow-text">À partir du tableau ci-dessus :</p>
                        <p class="flow-text">Affichez la liste des capitales (par ordre alphabétique) suivie du nom du pays.</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>ksort($capitales);

foreach ($capitales as $capitale =&gt; $pays) {
    echo "$capitale : $pays &lt;br&gt;";
}</code></pre>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3 center-align col s12">
                    <div class="card-content white-text">
                        <?php
                        $capitales = array(
                            "Bucarest" => "Roumanie",
                            "Bruxelles" => "Belgique",
                            "Oslo" => "Norvège",
                            "Ottawa" => "Canada",
                            "Paris" => "France",
                            "Port-au-Prince" => "Haïti",
                            "Port-d'Espagne" => "Trinité-et-Tobago",
                            "Prague" => "République tchèque",
                            "Rabat" => "Maroc",
                            "Riga" => "Lettonie",
                            "Rome" => "Italie",
                            "San José" => "Costa Rica",
                            "Santiago" => "Chili",
                            "Sofia" => "Bulgarie",
                            "Alger" => "Algérie",
                            "Amsterdam" => "Pays-Bas",
                            "Andorre-la-Vieille" => "Andorre",
                            "Asuncion" => "Paraguay",
                            "Athènes" => "Grèce",
                            "Bagdad" => "Irak",
                            "Bamako" => "Mali",
                            "Berlin" => "Allemagne",
                            "Bogota" => "Colombie",
                            "Brasilia" => "Brésil",
                            "Bratislava" => "Slovaquie",
                            "Varsovie" => "Pologne",
                            "Budapest" => "Hongrie",
                            "Le Caire" => "Egypte",
                            "Canberra" => "Australie",
                            "Caracas" => "Venezuela",
                            "Jakarta" => "Indonésie",
                            "Kiev" => "Ukraine",
                            "Kigali" => "Rwanda",
                            "Kingston" => "Jamaïque",
                            "Lima" => "Pérou",
                            "Londres" => "Royaume-Uni",
                            "Madrid" => "Espagne",
                            "Malé" => "Maldives",
                            "Mexico" => "Mexique",
                            "Minsk" => "Biélorussie",
                            "Moscou" => "Russie",
                            "Nairobi" => "Kenya",
                            "New Delhi" => "Inde",
                            "Stockholm" => "Suède",
                            "Téhéran" => "Iran",
                            "Tokyo" => "Japon",
                            "Tunis" => "Tunisie",
                            "Copenhague" => "Danemark",
                            "Dakar" => "Sénégal",
                            "Damas" => "Syrie",
                            "Dublin" => "Irlande",
                            "Erevan" => "Arménie",
                            "La Havane" => "Cuba",
                            "Helsinki" => "Finlande",
                            "Islamabad" => "Pakistan",
                            "Vienne" => "Autriche",
                            "Vilnius" => "Lituanie",
                            "Zagreb" => "Croatie"
                        );

                        ksort($capitales);

                        foreach ($capitales as $capitale => $pays) {
                            echo "$capitale : $pays <br>";
                        }
                        ?>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-2 center-align col s12">
                    <div class="card-content white-text">
                        <span class="card-title">
                            <p class="flow-text">Affichez la liste des pays (par ordre alphabétique) suivie du nom de la capitale.</p>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>asort($capitales);

foreach ($capitales as $capitale =&gt; $pays) {
    echo "$pays : $capitale &lt;br&gt;";
}</code></pre>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3 center-align col s12">
                    <div class="card-content white-text">
                        <?php
                        asort($capitales);

                        foreach ($capitales as $capitale => $pays) {
                            echo "$pays : $capitale <br>";
                        }
                        ?>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-2 center-align col s12">
                    <div class="card-content white-text">
                        <span class="card-title">
                            <p class="flow-text">Affichez le nombre de pays dans le tableau.</p>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>echo "Nombre de pays dans le tableau : " . count($capitales) . ".";</code></pre>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3 center-align col s12">
                    <div class="card-content white-text">
                        <?php
                        echo "Nombre de pays dans le tableau : " . count($capitales) . ".";
                        ?>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-2 center-align col s12">
                    <div class="card-content white-text">
                        <span class="card-title">
                            <p class="flow-text">Supprimez du tableau toutes les capitales ne commençant pas par la lettre 'B', puis affichez le contenu du tableau.</p>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>ksort($capitales);
                            
foreach ($capitales as $capitale =&gt; $pays) {
    if (!preg_match("/^b/i", $capitale)) {
        unset($capitales[$capitale]);
    }
}

foreach ($capitales as $capitale =&gt; $pays) {
    echo "$capitale : $pays &lt;br&gt;";
}</code></pre>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3 center-align col s12">
                    <div class="card-content white-text">
                        <?php
                        ksort($capitales);
                        foreach ($capitales as $capitale => $pays) {
                            if (!preg_match("/^b/i", $capitale)) {
                                unset($capitales[$capitale]);
                            }
                        }
                        foreach ($capitales as $capitale => $pays) {
                            echo "$capitale : $pays <br>";
                        }
                        ?>
                    </div>
                </div>
            </div>

        </div>
    </main>
    <?php
    include '../templates/footer.php'
    ?>