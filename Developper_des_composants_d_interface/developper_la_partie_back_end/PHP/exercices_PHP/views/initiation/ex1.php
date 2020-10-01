<?php
include '../templates/head.php';
include '../templates/header.php';
?>

<main>
        <div class="container">
                <div class="row">

                        <div class="card indigo lighten-2 center-align col s12">
                                <div class="card-content white-text">
                                        <span class="card-title">
                                                <p class="flow-text">Écrivez un script qui affiche l'adresse IP du serveur et celle du client.</p>
                                        </span>
                                </div>
                        </div>

                </div>


                <div class="row">

                        <div class="card-panel indigo lighten-3">
                                <div class="card-content white-text">
                                        <pre><code>echo "L'adresse IP du client est " . $_SERVER['REMOTE_ADDR'];
echo "L'adresse IP du serveur est " . $_SERVER['SERVER_ADDR'];</code></pre>
                                </div>
                        </div>

                </div>


                <div class="row">
                        <div class="card indigo lighten-3 center-align col s12">
                                <div class="card-content white-text">
                                        <p class="flow-text">
                                                <?php
                                                echo "L'adresse IP du client est " . $_SERVER['REMOTE_ADDR'];
                                                ?>
                                        </p>
                                        <p class="flow-text">
                                                <?php
                                                echo "L'adresse IP du serveur est " . $_SERVER['SERVER_ADDR'];
                                                ?>
                                        </p>
                                </div>
                        </div>
                </div>

        </div>
</main>

<?php
include '../templates/footer.php';
?>