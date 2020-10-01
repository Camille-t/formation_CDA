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
                                                        <p class="flow-text">Récupération d'un fichier distant.</p>
                                                </span>
                                                <p class="flow-text">Un site partenaire met à votre disposition une liste des nouveaux utilisateurs inscrits.</p>
                                                <p class="flow-text">Cette liste est disponible à cette adresse : http://bienvu.net/misc/customers.csv .</p>
                                                <p class="flow-text">Il s'agit d'un fichier csv où chaque ligne représente un nouvel utilisateur. Les différents champs sont Surname, Firstname, Email, Phone, City, State, ils sont séparés par une virgule, .</p>
                                                <ol class="flow-text">
                                                        <li>Utilisez la fonction file() pour récupérer le contenu de ce fichier.</li>
                                                        <li>Découpez chaque ligne en utilisant une des fonctions suivantes : explode() ou preg_split()</li>
                                                        <li>Affichez le résultat dans un tableau HTML (avec Bootstrap si possible) en prenant bien soin de nommer les colonnes du tableau.</li>
                                                </ol>
                                        </div>
                                </div>

                        </div>


                        <div class="row">

                                <div class="card-panel indigo lighten-3 col s12">
                                        <div class="card-content white-text">
                                                <pre><code>&lt;table class="highlight centered responsive-table"&gt;
        &lt;thead&gt;
                &lt;tr&gt;
                        &lt;th&gt;Firstname&lt;/th&gt;
                        &lt;th&gt;Surname&lt;/th&gt;
                        &lt;th&gt;Email&lt;/th&gt;
                        &lt;th&gt;Phone&lt;/th&gt;
                        &lt;th&gt;City&lt;/th&gt;
                        &lt;th&gt;State&lt;/th&gt;
                &lt;/tr&gt;
        &lt;/thead&gt;
        &lt;tbody&gt;
                &lt;tr&gt;
                &lt;?php
                $lines = file("http://bienvu.net/misc/customers.csv");
                foreach ($lines as $value) {
                        $array = explode(",", $value);
                        foreach ($array as $value) { ?&gt;
                        &lt;td&gt;
                        &lt;?= $value ?&gt;
                        &lt;/td&gt;
                        &lt;?php
                        }
                        ?&gt;
                &lt;/tr&gt;
                &lt;?php
                }
                ?&gt;
        &lt;/tbody&gt;
&lt;/table&gt;</code></pre>
                                        </div>
                                </div>

                        </div>


                        <div class="row">
                                <div class="card indigo lighten-3 center-align col s12">
                                        <div class="card-content white-text">
                                                <p class="flow-text">
                                                        <table class="highlight centered responsive-table">
                                                                <thead>
                                                                        <tr>
                                                                                <th>Firstname</th>
                                                                                <th>Surname</th>
                                                                                <th>Email</th>
                                                                                <th>Phone</th>
                                                                                <th>City</th>
                                                                                <th>State</th>
                                                                        </tr>
                                                                </thead>
                                                                <tbody>
                                                                        <tr>
                                                                                <?php
                                                                                $lines = file("http://bienvu.net/misc/customers.csv");
                                                                                foreach ($lines as $value) {
                                                                                        $array = explode(",", $value);
                                                                                        foreach ($array as $value) {
                                                                                ?>
                                                                                                <td>
                                                                                                        <?= $value ?>
                                                                                                </td>
                                                                                        <?php
                                                                                        }
                                                                                        ?>
                                                                        </tr>
                                                                <?php
                                                                                }
                                                                ?>
                                                                </tbody>
                                                        </table>
                                                </p>
                                        </div>
                                </div>
                        </div>

                </div>
        </main>

        <?php
        include '../templates/footer.php'
        ?>