<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="js/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- personal stylesheet link after materialize css link -->
    <link rel="stylesheet" href="assets/stylesheet.css">
</head>

<body>
    <header>
        <!--Bandeau site avec logo + slogan-->
        <img class="responsive-img" src="assets/jarditou_logo.jpg" alt="logo jarditou" width="40%" />
        <!-- with class responsive-img the image has a max-width: 100% and height:auto -->
    </header>
    <nav>
        <div class="nav-wrapper green darken-4">
            <a class="sidenav-trigger" href="#" data-target="mobile-demo"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="index.html">Accueil</a></li>
                <!-- active class on li tag denote the current page-->
                <li class="active"><a href="catalogue.html">Catalogue</a></li> 
                <li><a href="formulaire.html">Contact</a></li>
            </ul>
        </div>
    </nav>

    <ul class="sidenav" id="mobile-demo">
        <li><a href="index.html">Accueil</a></li>
        <li><a href="catalogue.html">Catalogue</a></li>
        <li><a href="formulaire.html">Contact</a></li>
    </ul>
    <!-- bandeau promotions -->
    <img class="responsive-img" src="assets/promotion.jpg" alt="promotions" width="100%">
    <main class="row">
        <form class="col s12" id="jarditouForm" action="ex1.php" method="POST">
            <div class="section">
                <legend class="flow-text indigo-text">
                    Vos coordonnées
                </legend>
                <span class="asterisk red-text">*</span>
                <span class="indigo-text">champs obligatoires</span>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="lastName" name="lastName" type="text">
                        <label for="lastName">Votre Nom<span class="asterisk">*</span></label>
                        <span id="errorLastName"></span>
                    </div>
                    <div class="input-field col s6">
                        <input id="firstName" name="firstName" type="text">
                        <label for="firstName">Votre Prénom<span class="asterisk">*</span></label>
                        <span id="errorFirstName"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input class="field datepicker" id="birthDate" name="birthDate" type="text">
                        <label for="birthDate">Votre date de naissance</label>
                    </div>
                    <div class="col s6">
                        <label class="col s6">
                            <input class="with-gap" id="female" name="gender" type="radio" value="F" checked />
                            <span>Féminin</span>
                        </label>
                        <label class="col s12 m6 l6">
                            <input class="with-gap" id="male" name="gender" type="radio" value="M" />
                            <span>Masculin</span>
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12 m6">
                        <input id="adress" name="adress" type="text">
                        <label for="adress">Adresse<span class="asterisk">*</span></label>
                        <span id="errorAdress"></span>
                    </div>
                    <div class="input-field col s12 m6">
                        <input id="postalCode" name="postalCode" type="text">
                        <label for="postalCode">Code postal<span class="asterisk">*</span></label>
                        <span id="errorPostalCode"></span>
                    </div>
                    <div class="input-field col s12 m6">
                        <input id="city" name="city" type="text">
                        <label for="city">Ville<span class="asterisk">*</span></label>
                        <span id="errorCity"></span>
                    </div>
                    <div class="input-field col s12 m6">
                        <select name="country">
                            <option value="0" disabled selected>Pays</option>
                            <option id="france" value="France">France</option>
                            <option id="uk" value="Royaume-Uni">Royaume-Uni</option>
                            <option id="spain" value="Espagne">Espagne</option>
                            <option id="portugal" value="Portugal">Portugal</option>
                            <option id="italy" value="Italie">Italie</option>
                            <option id="germany" value="Allemagne">Allemagne</option>
                        </select>
                        <label></label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">contact_mail</i>
                        <input id="icon_prefix" name="eMail" type="email" placeholder="dave.loper@afpa.fr">
                        <label for="icon_prefix">Courriel<span class="asterisk">*</span></label>
                        <span id="errorEmail"></span>
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">contact_phone</i>
                        <input id="icon_telephone" name="phone" type="tel">
                        <label for="icon_telephone">Téléphone<span class="asterisk">*</span></label>
                        <span id="errorTelephone"></span>
                    </div>
                </div>
            </div>
            <div class="section">
                <legend class="flow-text indigo-text">
                    Votre demande<span class="asterisk">*</span>
                </legend>
                <div class="row">
                    <div class="input-field col s12">
                        <select id="subject" name="subject">
                            <option value="0" disabled selected>Indiquez le sujet de votre demande</option>
                            <option id="order" value="mes commandes">mes commandes</option>
                            <option id="product" value="question sur un produit">question sur un produit</option>
                            <option id="claim" value="réclamation">réclamation</option>
                            <option id="other" value="autres : merci de préciser.">autres</option>
                        </select>
                        <span id="errorSubject"></span>
                        <label></label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">mode_edit</i>
                        <textarea class="materialize-textarea" name="question" id="textarea1" data-length="120"></textarea>
                        <span id="errorQuestion"></span>
                        <label id="textareaLabel" for="textarea1">Votre question<span class="asterisk">*</span></label>
                    </div>
                </div>
            </div>
        </form>
        <div class="switch row">
            <!-- switch -->
            <label>
                <input id="accept" type="checkbox">
                <span class="lever"></span>
                J'accepte le traitement informatique de ce formulaire.<span class="asterisk">*</span>
            </label>
            <div id="errorAccept"></div>
        </div>
        <div class="row">
            <!-- form reset button -->
            <button class="btn waves-effect waves-green col s3 m2 l1 col offset-s1 offset-m1 offset-l1" id="reset"
                type="reset">Effacer</button>
            <!-- form validation button -->
            <button class="btn waves-effect waves-green col s3 m2 l1" id="submit" type="submit">Envoyer</button>
        </div>
    </main>
    <footer class="page-footer green darken-4">
        <nav>
            <div class="nav-wrapper green darken-4">
                <a class="sidenav-trigger" href="#" data-target="mobile-demo_2"><i class="material-icons">menu</i></a>
                <ul class="left hide-on-med-and-down">
                    <li><a href="#">Mentions légales</a></li>
                    <li><a href="#">Horaires</a></li>
                    <li><a href="#">Plan du site</a></li>
                </ul>
            </div>
        </nav>
        <ul class="sidenav" id="mobile-demo_2">
            <li><a href="#">Mentions légales</a></li>
            <li><a href="#">Horaires</a></li>
            <li><a href="#">Plan du site</a></li>
        </ul>
        <div class="footer-copyright">© 2020 Copyright Jarditou</div>
    </footer>
    <!--Import jQuery before materialize.js-->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- personal jQuery script -->
    <script src="js/jquery.js"></script>
    <!-- import materialize.js -->
    <script type="text/javascript" src="js/materialize/js/materialize.min.js"></script>
    <!-- personal Javascript -->
    <script src="js/javascript.js"></script>

</body>

</html>