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
                    <li class="tab"><a class="active" href="ex1.php">exercice 1</a></li>
                    <li class="tab"><a href="ex2.php">exercice 2</a></li>
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
                            <p class="flow-text">Reprenez le formulaire que vous avez réalisé dans la séance précédente (JavaScript).</p>
                            <p class="flow-text">Dans ce formulaire, vous devez modifier l'attribut action de la balise form pour indiquer l'adresse d'un script PHP.</p>
                        </span>
                        <p class="flow-text">Puis créez un script PHP permettant d'afficher l'ensemble des valeurs transmises.</p>
                    </div>
                </div>
            </div>


            <div class="row">

                <div class="card-panel indigo lighten-3 col s12">
                    <div class="card-content white-text">
                        <pre><code>&lt;table class="highlight centered responsive-table"&gt;
    &lt;tbody&gt;
        &lt;?php foreach ($formData as $key =&gt; $value) { ?&gt; 
                &lt;tr&gt;
                    &lt;th&gt; &lt;?= $key ?&gt; &lt;/th&gt;
                    &lt;td&gt; &lt;?= $value ?&gt; &lt;/td&gt;
                &lt;/tr&gt;
        &lt;?php } ?&gt;
    &lt;/tbody&gt;
&lt;/table&gt;</code></pre>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="card indigo lighten-5 center-align col s12">
                    <div class="card-content white-text">
                        <p class="flow-text">
                            <?php
                            include 'formulaire.php';
                            ?>
                        </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="card indigo lighten-5 center-align col s12">
                    <div class="card-content black-text">
                        <p class="flow-text">
                            <?php
                            $formData["LastName"] = htmlspecialchars($_REQUEST["lastName"]);
                            $formData["FirstName"] = htmlspecialchars($_REQUEST["firstName"]);
                            $formData["BirthDate"] = htmlspecialchars($_REQUEST["birthDate"]);
                            $formData["Gender"] = htmlspecialchars($_REQUEST["gender"]);
                            $formData["Adress"] = htmlspecialchars($_REQUEST["adress"]);
                            $formData["PostalCode"] = htmlspecialchars($_REQUEST["postalCode"]);
                            $formData["City"] = htmlspecialchars($_REQUEST["city"]);
                            $formData["Country"] = htmlspecialchars($_REQUEST["country"]);
                            $formData["Email"] = htmlspecialchars($_REQUEST["eMail"]);
                            $formData["Phone"] = htmlspecialchars($_REQUEST["phone"]);
                            $formData["Subject"] = htmlspecialchars($_REQUEST["subject"]);
                            $formData["Question"] = htmlspecialchars($_REQUEST["question"]);
                            ?>
                            <table class="highlight centered responsive-table">
                                <tbody>
                                    <?php
                                        foreach ($formData as $key => $value) { ?>                                   
                                            <tr>
                                                <th> <?= $key ?> </th>
                                                <td> <?= $value ?> </td>
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