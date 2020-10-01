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
                    <li class="tab"><a class="active" href="ex3.php">exercice 3</a></li>
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
                            <p class="flow-text">Écrire un script qui affiche la table de multiplication totale de {1,...,12} par {1,...,12} dans un tableau.</h1>
                            </p>
                        </span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card-panel indigo lighten-3">
                    <div class="card-content white-text">
                        <pre><code>&lt;table class="highlight centered responsive-table"&gt;
    &lt;thead&gt;
        &lt;tr&gt;
            &lt;th&gt;&lt;/th&gt;
            &lt;?php
            $x = 0;
            while ($x &lt;= 12) {
            ?&gt;
                &lt;th&gt;&lt;?= $x ?&gt;&lt;/th&gt;
            &lt;?php
                $x++;
            }
            ?&gt;
        &lt;/tr&gt;
    &lt;/thead&gt;
    &lt;tbody&gt;
        &lt;?php
        $y = 0;
        while ($y &lt;= 12) {
        ?&gt;
            &lt;tr&gt;
                &lt;td&gt;
                    &lt;?= $y ?&gt;
                &lt;/td&gt;
                &lt;?php
                $x = 0;
                while ($x &lt;= 12) {
                ?&gt;
                    &lt;td&gt;
                        &lt;?= $x * $y ?&gt;
                        &lt;?php $x++; ?&gt;
                    &lt;/td&gt;
                &lt;?php
                } 
                ?&gt;
            &lt;/tr&gt;
        &lt;?php
        $y++;
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
                        <table class="highlight centered responsive-table">
                            <thead>
                                <tr>
                                    <th></th>
                                    <?php
                                    $x = 0;
                                    while ($x <= 12) {
                                    ?>
                                        <th><?= $x ?></th>
                                    <?php
                                        $x++;
                                    }
                                    ?>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                                $y = 0;
                                while ($y <= 12) {
                                ?>
                                    <tr>
                                        <td>
                                            <?= $y ?>
                                        </td>
                                        <?php
                                        $x = 0;
                                        while ($x <= 12) {
                                        ?>
                                            <td>
                                                <?= $x * $y ?>
                                                <?php $x++; ?>
                                            </td>
                                        <?php
                                        }
                                        ?>
                                    </tr>
                                <?php
                                    $y++;
                                }
                                ?>
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