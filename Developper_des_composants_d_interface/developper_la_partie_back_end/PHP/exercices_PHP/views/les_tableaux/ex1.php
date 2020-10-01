<?php
include '../templates/head.php'
?>

<body>
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
                    <li class="tab"><a class="active" href="ex1.php">exercice 1</a></li>
                    <li class="tab"><a href="ex2.php">exercice 2</a></li>
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
                            <p class="flow-text">Mois de l'année non bissextile</p>
                        </span>
                        <p class="flow-text">Créez un tableau associant à chaque mois de l'année le nombre de jours du mois.</p>
                        <p class="flow-text">Utilisez le nom des mois comme clés de votre tableau associatif.</p>
                        <p class="flow-text">Affichez votre tableau (dans un tableau HTML) pour faire apparâitre sur chaque ligne le nom du mois et le nombre de jours du mois.</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>&lt;table class="highlight centered responsive-table"&gt;
    &lt;thead&gt;
        &lt;tr&gt;
            &lt;th&gt;Mois&lt;/th&gt;
            &lt;th&gt;Nombre de jours&lt;/th&gt;
        &lt;/tr&gt;
    &lt;/thead&gt;
    &lt;tbody&gt;
    &lt;?php
    foreach ($tableau as $mois =&gt; $nombreDeJours) { 
    ?&gt;
        &lt;tr&gt;
            &lt;td&gt;
            &lt;?= $mois ?&gt;
            &lt;/td&gt;
            &lt;td&gt;
            &lt;?= $nombreDeJours ?&gt;
            &lt;/td&gt;
        &lt;/tr&gt;
    &lt;?php
    } 
    ?&gt;
    &lt;/tbody&gt;
&lt;/table&gt;

&lt;?php
asort($tableau);
?&gt;

&lt;table class="highlight centered responsive-table"&gt;
    &lt;thead&gt;
        &lt;tr&gt;
            &lt;th&gt;Mois&lt;/th&gt;
            &lt;th&gt;Nombre de jours&lt;/th&gt;
        &lt;/tr&gt;
    &lt;/thead&gt;
    &lt;tbody&gt;
    &lt;?php
    foreach ($tableau as $mois =&gt; $nombreDeJours) { 
    ?&gt;
        &lt;tr&gt;
            &lt;td&gt;
            &lt;?= $mois ?&gt;
            &lt;/td&gt;
            &lt;td&gt;
            &lt;?= $nombreDeJours ?&gt;
            &lt;/td&gt;
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
                <div class="card-panel indigo lighten-3 center-align col s12">
                    <div class="card-content white-text">
                        <?php
                        $tableau = array(
                            "Janvier" => 31,
                            "Février" => 28,
                            "Mars" => 31,
                            "Avril" => 30,
                            "Mai" => 31,
                            "Juin" => 30,
                            "Juillet" => 31,
                            "Août" => 31,
                            "Septembre" => 30,
                            "Octobre" => 31,
                            "Novembre" => 30,
                            "Décembre" => 31
                        ); ?>
                        <table class="highlight centered responsive-table">
                            <thead>
                                <tr>
                                    <th>Mois</th>
                                    <th>Nombre de jours</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                                foreach ($tableau as $mois => $nombreDeJours) {
                                ?>
                                    <tr>
                                        <td>
                                            <?= $mois ?>
                                        </td>
                                        <td>
                                            <?= $nombreDeJours ?>
                                        </td>
                                    </tr>
                                <?php
                                }
                                ?>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-2 center-align col s12">
                    <div class="card-content white-text">
                        <span class="card-title">
                            <p class="flow-text">Triez ensuite votre tableau en utilisant comme critère le nombre de jours, puis affichez le résultat.</p>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>asort($tableau);
&lt;table class="highlight centered responsive-table"&gt;
    &lt;thead&gt;
        &lt;tr&gt;
            &lt;th&gt;Mois&lt;/th&gt;
            &lt;th&gt;Nombre de jours&lt;/th&gt;
        &lt;/tr&gt;
    &lt;/thead&gt;
    &lt;tbody&gt;
    &lt;?php
    foreach ($tableau as $mois =&gt; $nombreDeJours) { 
    ?&gt;
        &lt;tr&gt;
            &lt;td&gt;
            &lt;?= $mois ?&gt;
            &lt;/td&gt;
            &lt;td&gt;
            &lt;?= $nombreDeJours ?&gt;
            &lt;/td&gt;
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
                <div class="card-panel indigo lighten-3 center-align col s12">
                    <div class="card-content white-text">
                        <?php
                        asort($tableau);
                        ?>
                        <table class="highlight centered responsive-table">
                            <thead>
                                <tr>
                                    <th>Mois</th>
                                    <th>Nombre de jours</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                                foreach ($tableau as $mois => $nombreDeJours) { ?>
                                    <tr>
                                        <td>
                                            <?= $mois ?>
                                        </td>
                                        <td>
                                            <?= $nombreDeJours ?>
                                        </td>
                                    </tr>
                                <?php
                                } ?>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </main>
    <?php
    include '../templates/footer.php'
    ?>