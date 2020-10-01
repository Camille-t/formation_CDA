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
					<li class="tab"><a href="ex1.php">exemple 1</a></li>
					<li class="tab"><a class="active" href="details_disc.php">exemple 2</a></li>
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
							<p class="flow-text">Concevoir une page permettabt d'afficher le détail d'un disque.</p>
						</span>
						<p class="flow-text">Le numéro d'un disque sera passé en paramètre de la page.</p>
						<p class="flow-text">Si la page se nomme details_disc.php, elle sera déclenchée de cette façon :</p>
						<p class="flow-text">details_disc.php?disc_id=7</p>
					</div>
				</div>

			</div>


			<div class="row">

				<div class="card-panel indigo lighten-3 col s12">
					<div class="card-content white-text">
						<pre><code>&lt;form action="details_disc.php" method="GET"&gt;
 &lt;input type="hidden" name="disc_id" value="7"&gt;
 &lt;input type="submit" name="" value="envoyer"&gt;
 &lt;/form&gt;</code></pre>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="card indigo lighten-4 center-align col s12">
					<div class="card-content">
						<form action="details_disc.php" method="GET">
							<input type="hidden" name="disc_id" value="7">
							<input type="submit" name="" value="envoyer">
						</form>
						<p class="flow-text">
							<?php
							$db = new PDO('mysql:host=localhost;charset=utf8;dbname=record', 'root', '');
							$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
							$requete = $db->prepare("select * from disc where disc_id=?");
							$requete->execute(array($_GET["disc_id"]));
							$disc = $requete->fetch(PDO::FETCH_OBJ);

							if ($disc == null) {
								echo 'Le disque n\'existe pas';
							} else {
							?>
								<p>Disc N° <?= $disc->disc_id ?></p>
								<p>Disc name <?= $disc->disc_title ?> </p>
								<p>Disc year <?= $disc->disc_year ?> </p>
							<?php
							} ?>
						</p>
					</div>
				</div>
			</div>

		</div>
	</main>

	<?php
	include '../templates/footer.php'
	?>