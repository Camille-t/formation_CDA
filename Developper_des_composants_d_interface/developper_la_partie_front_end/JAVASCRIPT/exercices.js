// Afficher du texte

/*Créer une page HTML qui demande successivement à l'utilisateur son nom puis son prénom.
La page demande ensuite à l'utilisateur s'il est un homme ou une femme.
Enfin, la page affiche les informations sur l'utilisateur.*/

/*
var nom = prompt("Entrez votre nom");

var prenom = prompt("Entrez votre prénom");

var sexe = true;

if(confirm("Etes-vous un homme?") == true)
{
    sexe = "Monsieur";
}
else {
    sexe = "Madame";
}

alert("Bonjour " + sexe + " " + nom + " " + prenom + "\nBienvenue sur notre site web !"); // saut de ligne : '\n'
*/
// Conditions

/* 1 - Parité
Ecrivez un programme qui demande un nombre à l’utilisateur puis qui teste si ce nombre est pair. Le
programme doit afficher le résultat « nombre pair » ou « nombre impair ». Vous devez utiliser
l’opérateur modulo « % » qui donne le reste d’une division. a%2 donne le reste de la division de a par
2, si ce reste est égale à zéro, a est divisible par 2. */

/*
var nombre = parseInt(prompt("Veuillez entrer un nombre")); // on utilise parseInt pour récupérer un type number
console.log(typeof(nombre)); // on vérifie avec typeof
var resultat = nombre % 2; // modulo de 2 '% 2' est égal au reste de la division du nombre par 2.

if (resultat == 0) // "==" est un opérateur de comparaison ('=' est un opérateur de calcul)
{
    alert("nombre pair");
}
else
{
    alert("nombre impair");
}
*/

/* 2 - Age
Ecrivez un programme qui demande l’année de naissance à l’utilisateur.
En réponse votre programme doit afficher l’âge de l’utilisateur et indiquer si l’utilisateur est majeur
ou mineur. */

/*
var anneeDeNaissance = parseInt(prompt("Veuillez saisir votre année de naissance"));
var age = 2020 - anneeDeNaissance;

if (anneeDeNaissance <= 2002 ) // on aurait aussi pu écrire la condition : if (age >= 18)
{
    alert("Vous avez " + age + " ans." + "\nVous êtes majeur.");
}
else
{
    alert("Vous avez " + age + " ans." + "\nVous êtes mineur.");
}
*/

/* 3 - Calculette
Faire la saisie de 2 nombres entiers, puis la saisie d'un opérateur '+', '-', '*' ou '/'.
Si l'utilisateur entre un opérateur erroné, le programme affichera un message d'erreur.
Dans le cas contraire, le programme effectuera l'opération demandée (en prévoyant le cas d'erreur "division par 0"), puis affichera le résultat. */

/*
var nombre_1 = parseInt(prompt("Veuillez saisir un nombre entier"));
var operateur = prompt(" Veuillez saisir un opérateur parmi les suivants : +, -, * ou /.");
var nombre_2 = parseInt(prompt("Veuillez saisir un second nombre entier"));

while ((operateur != "+")&&(operateur != "-")&&(operateur != "*")&&(operateur != "/")) // on utilise une boucle while avec la condition
{
    alert("L'opérateur que vous avez saisi est erroné. Veuillez rééssayer");
    operateur = prompt(" Veuillez saisir un opérateur parmi les suivants : +, -, * ou /.");
}

switch (operateur) // on utilise l'instruction 'switch' qui reçoit en argument la variable à tester 'operateur'
{
    case "+": // les mots-clés 'case' reçoivent les différentes valeurs possibles pour la var 'operateur'
        alert(nombre_1 + " + " + nombre_2 + " = " + (nombre_1 + nombre_2));
        break; // l'instruction break permet de sortir du switch une fois la condition réalisée
    case "-":
        alert(nombre_1 + " - " + nombre_2 + " = " + (nombre_1 - nombre_2));
        break;
    case "*":
        alert(nombre_1 + " * " + nombre_2 + " = " + (nombre_1 * nombre_2));
        break;
    case "/":
        if (nombre_2 == 0)
        {
            alert("Un nombre n'est pas divisible par 0");
        }
        else
        {
        alert(nombre_1 + " / " + nombre_2 + " = " + (nombre_1 / nombre_2));
        break;
        }
}
*/

/* 4 - Remise
A partir de la saisie du prix unitaire PU d'un produit et de la quantité commandée QTECOM, afficher
le prix à payer PAP, en détaillant le port PORT et la remise REM, sachant que :
- le port est gratuit si le prix des produits TOT est supérieur à 500 €. Dans le cas contraire, le
port est de 2% de TOT,
- la valeur minimale du port à payer est de 6 €,
- la remise est de 5% si TOT est compris entre 100 et 200 € et de 10% au-delà. */

/*
var PU = parseInt(prompt("Veuillez saisir le prix unitaire du produit"));
var QTECOM = parseInt(prompt("Veuillez saisir la quantité commandée"));
var TOT = PU * QTECOM;
var REM;
var PORT;

if ((TOT >= 100)&&(TOT <= 200))
{
    REM = (TOT/100)*5;
}
else if (TOT >= 200)
{
    REM = (TOT/100)*10;
}
else
{
    REM = 0;
}


if (TOT > 500)
{
    PORT = 0;
}
else 
{
    PORT = (TOT/100)*2;
        if (PORT <= 6) // on ajoute une condition dans la condition pour le cas où TOT <= 500 ET PORT < 6.
        {
            PORT = 6;
        }
}

var PAP = (TOT - REM) + PORT;
alert("Le prix à payer est de " + PAP + " €.");
*/

/* 5 - Participation
Un patron décide de calculer le montant de sa participation au prix du repas de ses employés de la
façon suivante :
- si il est célibataire : participation de 20%,
- si il est marié : participation de 25%,
- si il a des enfants : participation de 10% supplémentaire par enfant.
La participation est plafonnée à 50%.
Si le salaire mensuel est inférieur à 1200€ la participation est majorée de 10%.
Ecrire le programme qui lit les informations au clavier et affiche pour chaque salarié, la participation à laquelle il a droit.*/

/*
var marie;
var celibataire;
var enfant;

if (confirm("Etes-vous marié?") == true)
{
    celibataire = false;
    marie = true;
}
else
{
    celibataire = true;
    marie = false;
}
console.log(marie);
console.log(celibataire);

if(confirm("Avez-vous des enfants?") == true)
{
    enfant = parseInt(prompt("Combien?"));
}
else
{
    enfant = 0;
}

var participation;

participation = enfant * 10;
console.log(participation);

if (marie == true) 
{
    participation += 25;
}
else 
{
    participation += 20;
}

if (participation > 50)
{
    participation = 50;
}

var salaire = parseInt(prompt("Indiquez votre salaire"));

if (salaire < 1200)
{
    participation += 10;
}

alert("La participation de votre employeur au prix de vos repas s'élève à " + participation + " %.");
*/

// BOUCLES

/* 1 - Saisie
Créer une page HTML qui demande à l'utilisateur un prénom.
La page doit continuer à demander des prénoms à l'utilisateur jusqu'à ce qu'il laisse le champ vide.
Enfin, la page affiche sur la console le nombre de prénoms et les prénoms saisis.*/

/*
var prenom = "chaine à écraser"; 
var compteur = 1;
var liste = "";

while ((prenom != "") && (prenom != null)) // tant que l'utilisateur ne clique pas sur OK en laissant le champ vide ET qu'il ne clique pas sur Annuler
{
    prenom = prompt("Saisissez le prenom N°" + compteur + "\nou Clic sur Annuler pour arrêter la saisie."); // on lui demande de saisir des prénoms

    if(!(prenom != "") || (prenom != null)) // si l'utilisateur clique sur annuler (prenom prend alors la valeur null) OU s'il clique sur OK en laissant le champ vide (prenom prend la valeur "")
    {
        liste += ("\n" + prenom + "\n"); // liste prend comme valeur le(s) prenom(s) saisi(s) 
    }

    compteur++; // on incrémente notre compteur à chaque passage dans la boucle
}

console.log("Nombre de prénom(s) saisi(s) : " + (compteur - 2)); // lorsque l'utilisateur clic sur Ok en laissant le champ vide, compteur est incrémenté "inutilement" donc on le décrémente ici
console.log("Liste de(s) prénom(s) saisi(s) : " + liste);
*/

/* 2 - Entiers inférieurs à N
Ecrivez un programme qui affiche les nombres inférieurs à N.*/

/*
var N = parseInt(prompt("Veuillez saisir un nombre"));
var i;

for (i = N ; i != 0 ; i--) // On démarre notre boucle avec i qui a la valeur du nombre saisi par l'utilisateur. Tant que i est différent de 0, i est décrémenté
{
       console.log(i); // on affiche dans la console toutes les valeurs de i
}
*/

/* 4 - Somme d'un intervalle
Ecrivez un programme qui saisit deux nombres n1 et n2 et qui calcul ensuite la somme des entiers de
n1 à n2.*/

/*
var nombre_1 = parseInt(prompt("Veuillez saisir un premier nombre"));
var nombre_2 = parseInt(prompt("Veuillez saisir un second nombre"));
var somme = 0;

if (nombre_1 < nombre_2)
{
    for (i = nombre_1 ; i < nombre_2 ; i++)
    {
        somme += i;
    }
}
else
{
    for (i = nombre_2 ; i < nombre_1 ; i++)
    {
        somme += i;
    }
}
console.log(" la somme des entiers de " + nombre_1 + " à " + nombre_2 + " est égale à " +somme);
*/

/* 5 - Moyenne
Ecrire un programme qui saisit des entiers et en affiche la somme et la moyenne (on arrête la saisie
avec la valeur 0).*/

/*
var somme = 0;
var i;
var moyenne = null;
var entier = null;

for(i = 0 ; entier !=0 ; i++)
{
    entier = parseInt(prompt("Veuillez saisir un nombre entier ou saisir 0 puis cliquer sur Ok pour arrêter la saisie"));
    somme += entier;
}
moyenne = somme / (compteur - 1); // Une fois sorti de la boucle, on peut calculer la moyenne car on a le total 
et le nombre de tours définitifs (que l'on décrémente afin de ne pas prendre en compte la saisie de 0)
console.log("La somme des valeurs saisies est égale à : " + somme);
console.log("La moyenne des valeurs saisies est égale à : " + moyenne);
*/

/* 6 - Mini et maxi
Modifiez le programme de la moyenne pour afficher le minimum et le maximum.*/

/*
var max = 0; 
var min = 0;
var i = 0; 
var entier = null; // la valeur saisie par l'utilisateur
var monTableau = []; // on créé un tableau dans lequel on va pouvoir récupérer les entiers saisis par l'utilisateur

while(entier != 0) // on arrête la saisie lorsque l'utilisateur entre 0
{
    entier = parseInt(prompt("Veuillez saisir un nombre")); 
    monTableau[i] = entier; // la valeur saisie par l'utilisateur est enregistrée en position 0 de notre tableau
    i++; // la boucle continue, on passe à la deuxième valeur du tableau (i=1)
}
monTableau.pop(); // on utilise la méthode pop afin de supprimer le dernier élément de notre tableau c'est-à-dire 
la dernière valeur saisie par l'utilisateur soit 0 (car on ne veut pas que ce soit la valeur min)
// la fonction Math.max retourne le plus grand des nombres passés en arguments (sous forme d'un tableau)
max = Math.max(...monTableau); // ...monTableau est un opérateur de décomposition de monTableau 
min = Math.min(...monTableau);
console.log("La valeur max saisie est : "+ max + " et la valeur min est : " + min);
*/

/* 7 - Multiples
Ecrire un programme qui calcule les N premiers multiples d'un nombre entier X, N et X étant entrés
au clavier.
Exemple pour N=5 et X=7 :
1 x 7 = 7
2 x 7 = 14
3 x 7 = 21
4 x 7 = 28
5 x 7 = 35
Il est demandé de choisir la structure répétitive (for, while, do...while) la mieux appropriée au problème.
On ne demande pas pour le moment de gérer les débordements (overflows) dus à des demandes de
calcul dépassant la capacité de la machine.*/

/*
x = parseInt(prompt("Table de mulitplication du nombre :")); 
n = parseInt(prompt("Multiplier jusqu'à :"));

var resultat= 0;

for(i = 1 ; i <= n ; i++)
{
        resultat = i * x;
        console.log(x + "x" + i + "=" + resultat);
}
*/

/* 8 - Nombre de voyelles.
Ecrire le programme qui compte le nombre de voyelles d’un mot saisi au clavier, en utilisant :
- myVar.length : retourne le nombre de lettres de la chaîne myVar.
- myVar.substr(p,n): extrait d’une chaîne donnée une sous-chaîne de n caractères à partir
de la position p (attention, en Javascript, le 1er caractère se trouve à la position 0)
- myVar.indexOf(chaine) : retourne le rang de la première occurrence de chaine dans la
variable myVar donnée (si non trouvé : -1).*/

/*
var mot = prompt("Veuilez saisir un mot");
var j = 0;
var i;

for (i = 0; i < mot.length; i++) 
{
    switch (mot[i]) 
    {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'y':
            j++; // incrémentation de notre compteur dans tous les cas présents
            break; // fin de la boucle
        default:" ";
    }
}
console.log("Il y a " + j + " voyelles dans le mot " + mot);
*/

/* 9 - Calcul du nombre de jeunes, de moyens et de vieux.
Il s’agit de dénombrer les personnes d'âge strictement inférieur à 20 ans, les personnes d'âge strictement supérieur à 40 ans 
et celles dont l'âge est compris entre 20 ans et 40 ans (20 ans et 40 ans y compris).
Le programme doit demander les âges successifs.
Le comptage est arrêté dès la saisie d’un centenaire. Le centenaire est compté.
Donnez le programme Javascript correspondant qui affiche les résultats.*/

/*
var jeunes = 0;
var moyens = 0;
var vieux = 0;

do
{
    var age = parseInt(prompt("Veuillez saisir l'âge d'une personne"));

    if(age < 20)
    {
        jeunes++;
    }
    else if(age > 40)
    {
        vieux ++;
    }
    else
    {
        moyens++;
    }

} while(age < 100);

console.log("Il y a " + vieux + " personnes âgées de plus de 40 ans.");
console.log("Il y a " + jeunes + " personnes âgées de moins de 20 ans.");
console.log("Il y a " + moyens + " personnes âgées de 20 à 40 ans.");
*/

/* 10 - 10 - Un nombre est-il premier
Ecrivez un programme qui permet de tester si un nombre est premier.*/

/*
var n = parseInt(window.prompt("Veuillez saisir un nombre"));
var racineCarree = Math.sqrt(n); //La variable racineCarree a pour valeur la racine carree du nombre n saisi par l'utilisateur.
var estPremier = true;

if (n<2)
	estPremier = false;

for(i=2 ; i<=racineCarree ; i++){ //Boucle : la boucle commence, on cherche à diviser n par i, on commence la boucle avec la valeur i=2 puis on continue tant que i est inférieur à la racine carrée du nombre saisi. a chaque fois que l'on repart sur la boucle on incrémente i de 1.

    if(n%i === 0) //Condition : égalité stricte (pas de conversion de type) Le reste de la division de n par i est égal à 0. Le nombre saisi est donc divisible par un nombre entre n et racineCarree(n) et ce n'est donc pas un nombre premier.
		estPremier = false;    

}
*/

/* 11 - 11 - Nombre magique
Ecrire un programme qui met en œuvre le jeu du nombre magique :
L’ordinateur choisit un nombre aléatoire et l’utilisateur doit trouver ce nombre. A chaque fois que
l’utilisateur saisit une valeur, il reçoit une indication lui indiquant « plus petit » ou « plus grand ».
Vous aurez besoin de générer un nombre aléatoire avec la fonction random de l’objet Math :
var magic = parseInt(Math.random()*100);
Utilisez alert pour afficher les messages « Trop grand » ou « Trop petit », prompt pour demander
une valeur à l’utilisateur et confirm pour lui demander de rejouer.*/

/*
var magicNumber = parseInt(Math.random() * 100);
console.log(magicNumber);
var userNumber = 0;
var play = true;
do {
    userNumber = parseInt(window.prompt("Saisissez un nombre\n(ou cliquez sur Annuler pour arrêter)"));
    if (userNumber == magicNumber) {
        alert("Bravo!\nVous avez trouvé le nombre magique : " + magicNumber + " !");
        break;
    } else if (userNumber > magicNumber) {
        play = confirm("Trop grand ! Rejouer ?")
    } else {
        play = confirm("Trop petit ! Rejouer ?");
    }
} while (userNumber != magicNumber && userNumber != null && play == true);

if (userNumber == null || play == false) // si l'utilisateur ne souhaite plus jouer 
{
    alert("Le nombre à trouver était " + magicNumber);
}
*/

// FONCTIONS

/* Créer les 2 fonctions suivantes :
- produit(x, y) qui retourne le produit des 2 variables x, y passées en paramètre.
- afficheImg(image) qui affiche l'image passée en paramètre.*/

/*
var nombre;
var multiple;
var image = "";

function cube(nombre) 
{
	cube = nombre * nombre * nombre;
	document.write("Le cube de " + nombre + " est égal à " + cube);
	return cube;
}

function produit(nombre, multiple) 
{
	produit = nombre * multiple;
	document.write("Le produit de " + nombre + " x " + multiple + " est égal à " + produit);
	return produit;
}

function afficheImg(image) 
{
	document.write("<img src=\""+image+"\">");
}

var resultat = cube(3);
var result = produit(3, 5);
afficheImg("papillon.jpg");
*/

/* Exercice 2 - Table de multiplication
Ecrivez une fonction qui affiche une table de multiplication.
Votre fonction doit prendre un paramètre qui permet d’indiquer quelle table afficher.*/

/*
function tableMultiplication(nombre)
{
    var nombre = parseInt(prompt("Veuillez saisir un nombre dont vous souhaitez connaître les multiples"));
    for(i=1 ; i < 10 ; i++)
    {
        console.log(nombre + " x " + i + " = " + nombre*i);
    }    
}

tableMultiplication();
*/

/* Exercice 3 - Compter le nombre de lettres
Ecrivez une fonction qui prend deux paramètres :
- phrase de type string
- lettre de type string
La fonction compte le nombre de fois ou lettre apparaît dans phrase.*/

/*
function compter(phrase, lettre)
{    
    var phrase = prompt("Veuillez saisir une phrase");
    console.log(phrase);
    var lettre = prompt("Veuillez choisir une lettre");
    console.log(lettre);
    var occurence = 0;
    for(i = 0 ; i < phrase.length ; i++)
    {
        if(phrase[i] == lettre)
        {
            occurence++;
        }
        console.log(occurence);
    }
    alert("La lettre '"+ lettre +"' est présente "+ occurence +" fois dans '"+ phrase +"'");
}
compter();
*/

/* 4 - Menu
Vous exécuterez, par les 3 premières options, les exercices déjà réalisés, appelés sous forme de fonction.
L’option 4 est une généralisation de la recherche du nombre de voyelles dans un mot : elle permet de
rechercher la présence de n’importe quel caractère dans une chaîne.
La recherche de voyelles dans une chaîne constitue une surcharge de cette fonction, dans la mesure
où les caractères à rechercher seront fournis sous forme de chaîne.*/

/*
function multiple(x, n)
{
    x = parseInt(prompt("Table de mulitplication du nombre :")); 
    n = parseInt(prompt("Multiplier jusqu'à :"));
    var resultat= 0;

    for(i = 1 ; i <= n ; i++)
    {
        resultat = i * x;
        console.log(x + "x" + i + "=" + resultat);
    }
}

function sommeEtMoyenne(entier)
{
    var somme = 0;
    var i;
    var moyenne = null;
    var entier = null;
    

    for(i = 0 ; entier !=0 ; i++)
    {
        entier = parseInt(prompt("Veuillez saisir un nombre entier ou saisir 0 puis cliquer sur Ok pour arrêter la saisie"));
        somme += entier;
    }
    console.log("La somme des nombres entiers saisis est égale à : " + somme);
    moyenne = somme / (i - 1);
    console.log("La moyenne des nombres entiers saisis est égale à : " + moyenne);
}

function voyelles(mot)
{
    var mot = prompt("Veuilez saisir un mot");
    var j = 0;
    var i;

    for (i = 0; i < mot.length; i++) 
    {
        switch (mot[i]) 
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            j++; // incrémentation de notre compteur dans tous les cas présents
            break; // fin de la boucle
            default:" ";
        }
    }
console.log("Il y a " + j + " voyelles dans le mot " + mot);
}

function comptelettre()
{ 
    var texte = prompt("entrez un mot ou une phrase");
    var lettre = prompt("entrez une lettre");

    var compteur = 0;
    var longueur = texte.length;
    
    for(i = 0 ;i <= longueur; i++)
    {
       var lettreDuTexte = texte.substr(i,1); // la fonction substring retourne une sous-chaîne de la chaîne courante, entre un indice de début(i) et un indice de fin(1). Cela nous permet de retourner dans une variable (ici lettreDuTexte) les lettres de notre texte une par une
           
       if (lettreDuTexte == lettre) 
       {
          compteur++;
       }
    }

    alert("La lettre " + lettre + " est présente " + compteur + " fois dans le texte : " + texte);
}

multiple();
sommeEtMoyenne();
voyelles();
comptelettre();
*/

/* 5 - String token
Concevez la fonction strtok qui prend 3 paramètres str1, str2 et n en entrée et renvoie une chaîne de caractères. 
str1 est composée d'une liste de mots séparés par le caractère str2.
strtok sert à extraire le nième mot de str1.
exemple :
pour str1 = "robert;dupont;amiens;80000", strtok (str1,";",3) doit retourner "amiens."*/

/*
function strtok(str1, str2, n)
{
    mot = str1.split(str2); // La méthode split() permet de diviser une chaîne de caractères à partir d'un séparateur donné en paramètre (ici ";") pour four nir un tableau de sous-chaînes.
    console.log(mot[n]); // on va ici récupérer le nième(3ème) mot de str1
}
strtok("robert;dupont;amiens;80000", ";", 3);
*/

// LES TABLEAUX

/* Exercice 1
Ecrivez un programme permettant de créer un tableau, dont la taille est saisie au clavier.
Ensuite l'utilisateur doit rentrer les différentes valeurs du tableau.
Puis votre programme doit afficher le contenu du tableau.*/

/*
var tableau = Array(); // ici on déclare et initialise un tableau avec ? éléments 
var i;
var contenu; // variable contenu qui nous permettra d'afficher le contenu du tableau
tableau.length = parseInt(prompt("Veuillez saisir le nombre d'éléments que vous souhaitez intégrer au tableau")); // on demande à l'utilisateur d'entrer un Entier afin de choisir la longueur du tableau c'est-à-dire le nombre d'éléments qu'il contiendra

for ( i = 0 ; i < tableau.length ; i++ ){ // on utilise une boucle afin que l'utilisateur puisse rentrer les différentes valeurs du tableau. Cette boucle commence avec le premier élément du tableau en position 0 et continue jusqu'à atteindre le dernier élément du tableau correspondant à la longueur du tableau. A chaque passage dans la boucle on ajoute passe à l'élément suivant du tableau c-àd celui qui a la position+1
    tableau[i]=(prompt("Veuillez saisir une entrée")); // pour chaque élément du tableau on invite l'utilisateur à saisir une donnée
}
contenu = tableau.join("\n"); // ici on transforme les données du tableau en une chaine de caractère (grâce à la méthode join()) en séparant les éléments du tableau avec le caractère \n qui effectue un renvoi à la ligne.
alert("Voici le contenu du tableau : \n" +contenu); // on affiche le contenu du tableau transformé en chaine
*/

/* Exercice 2
Créer le programme qui fournira un menu permettant d’obtenir les fonctionnalités suivantes à partir
d’un tableau à une dimension :
 Affichage du contenu de tous les postes du tableau,
 Affichage du contenu d’un poste dont l’index est saisi au clavier,
 Affichage du maximum et de la moyenne des postes du tableau
Ce programme sera structuré de la manière suivante :
 une fonction GetInteger pour lire un entier au clavier,
 une fonction InitTab pour créer et initialiser l’instance de tableau : le nombre de postes souhaité sera entré au clavier,
 une fonction SaisieTab pour permettre la saisie des différents postes du tableau,
 une fonction AfficheTab pour afficher tous les postes du tableau,
 une fonction RechercheTab pour afficher le contenu d’un poste de tableau dont le rang est
saisi au clavier
 une fonction InfoTab qui affichera le maximum et la moyenne des postes.
Les fonctions seront appelées successivement.*/

/*
function GetInteger() { // fonction qui lit un entier au clavier
    var nbDEntier = parseInt(window.prompt("Veuillez saisir un Entier que vous souhaitez intégrer comme élément du tableau"));
    return nbDEntier;
}

function InitTab(nbDEntier) { // fonction qui créé et initialise l'instance du tableau avec le nombre de postes entré au clavier
    var tableau = [];
    tableau.length = prompt("Veuillez saisir le nombre de postes que vous souhaitez intégrer au tableau");
    return tableau;
}

function SaisieTab(tableau) { // fonction qui permet la saisie des différents postes du tableau
    for (var i = 0; i < tableau.length; i++) {
        tableau[i] = GetInteger();
    }
    return tableau;
}

function AfficheTab(tableau) { // fonction qui permet d'afficher tous les postes du tableau
    var contenu = tableau.join("\n");
    alert(contenu);
}

function RechercheTab(tableau) { // fonction pour afficher le contenu d'un poste de tableau dont le rang est saisi au clavier
    var index = parseInt(window.prompt("Indiquer le rang d'un poste du tableau dont vous souhaitez consulter le contenu"));
    alert(tableau[index - 1]);
}

function InfoTab(tableau) { // fonction qui affichera le maximum et la moyenne des postes
    var somme = 0;
    for (i = 0; i < tableau.length; i++) {
        somme += tableau[i];
    } 
        var moyenne = somme / (tableau.length);
        var max = Math.max(...tableau);
        alert("La moyenne des postes est égale à : " + moyenne);
        alert("La valeur maximum des postes est : " +max);
}

var tableau = SaisieTab(InitTab(tableau));
AfficheTab(tableau);
RechercheTab(tableau);
InfoTab(tableau);
*/

/*Exercice 3
On recherche dans un tableau contenant 20 prénoms, un prénom saisi au clavier.
Lorsque cet élément est trouvé, on l’élimine du tableau en décalant les cases qui le suivent, et en
mettant à blanc la dernière case.*/

/*
function recherchePrenom()
{
    var tab = ["Audrey","Aurélien","Flavien","Jérémy","Laurent","Melik","Nouara","Salem","Samuel","Stéphane"];
    var prenom = prompt("Veuillez saisir un prénom");
    if (tab.includes(prenom)) // méthode includes permet de déterminer si un tableau contient une valeur : si le prenom saisi par l'utilisateur est présent dans le tableau (= true) :
    {
        tab.splice(tab.indexOf(prenom), 1); // méthode splice modifie le contenu d'un tableau en retirant un élément avec tab.indexOf(prenom) qui indique l'indice du tableau à partir duquel commencer le changement (ici le prenom qui a été saisi par l'utilisateur et trouvé dans le tableau) et 1 qui indique le nombre d'éléments à supprimer.
        tab[tab.length] = ""; // on met à blanc la dernière case du tableau en donnant à l'élément dont l'indice correspond à la longueur du tableau (ici tab.length=9) la valeur "" => tab[9]=""
    }
    console.log(tab);
}
recherchePrenom();
*/

/*Exercice 4 : Tri d’un tableau
Ecrire le programme qui réalise le tri à bulles.*/

/*
function triABulles(tableau)
{
    var echange;

    do
    {
        echange = false;
        for(var i = 0 ; i < tableau.length-1; i++)
        {
            if(tableau[i] > tableau[i+1]) // on analyse si le premier élément est supérieur au second (18 et 5), si c'est vrai on permute les deux éléments (echange = true), le 5 prend la place du 18
            {
                var temporaire = tableau[i];
                tableau[i] = tableau[i+1];
                tableau[i+1] = temporaire;
                echange = true;
            }
        }
    } while(echange); // tant que echange = true , le tri n'est pas terminé
}

var tableau = [18, 5, 14, 4, 26];
triABulles(tableau);
console.log(tableau);
*/

// le programme va commencer par comparer tableau[0] et tableau[1], si tableau[0] > tableau[1] on va créer une variable temporaire qui prendra la valeur de tableau[0]
// ==> 18 > 5 donc var temporaire = 18
// ensuite on va passer (echanger) la valeur de tableau[1] dans tableau[0]
// ==> tableau[0] = tableau[1] donc tableau[0] = 5
// et on va se servir de la variable temporaire pour remplacer la valeur de tableau[1] par cette valeur
// ==> tableau[1] = temporaire donc tableau[1]= 18
// Il y a eu un échange donc on indique que la variable booleenne echange est true car la boucle doit continuer jusqu'à ce qu'il n'y ai plus d'échange ce qui signifiera que le tri du tableau est terminé

// OBJETS NATIFS

/* Exercice 
Ecrivez un programme permettant de saisir différentes valeurs numériques (avec l'instruction prompt), 
ces valeurs seront rangées dans un tableau. La saisie s'arrête quand l'utilisateur entre la valeur 0.
A la fin de la saisie, votre programme doit afficher le nombre de valeurs saisies, la somme et la moyenne.*/

/*
var tableau = new Array();
var i = 0;
var j = 0;
var resultat = 0;
var somme = 0;
do
{
    j = parseInt(prompt("Veuillez saisir une valeur numérique ou saisissez '0' et validez pour mettre fin à la saisie"));
    tableau[i] = j;
    i++;
} while(j != 0);
tableau.pop(); // on supprime le 0 saisi en dernier pour mettre fin à la saisie

function nbValeursSaisies(tableau)
{
    var nbValeursSaisies = tableau.length;
    console.log("Vous avez saisi : " + nbValeursSaisies + " valeurs numériques.")
    return tableau;  // l'instruction return met fin à l'exécution de la fonction et définit une valeur à renvoyer à la fonction appelante
}

function sum(tableau) // on appelle notre tableau en paramètre de notre fonction
{   
    var tableau = nbValeursSaisies(tableau);
    for(var i = 0 ; i < tableau.length ; i++)
    {
        resultat = tableau[i];
        somme += resultat;
    }
    tableau[i++] = somme;
    console.log("La somme des entiers saisis est égale à : " + somme);
    return tableau;

}

function moyenne(tableau)
{   
    var tableau = sum(tableau);
    console.log(tableau.length);
    var somme = tableau[tableau.length - 1];
    var moyenne = somme / (tableau.length - 1);
    console.log("La moyenne des entiers saisis est égale à " + moyenne);
}

moyenne(tableau);
*/

// LES EVENEMENTS

/*
var element = document.getElementById('controler');

element.addEventListener('click', function()
{   
    var prenom = document.getElementById('name').value;
    alert('Vous avez saisi : ' + prenom);
});
*/

/*
var magicNumber = parseInt(Math.random() * 100);
console.log(magicNumber);
var element = document.getElementById('button1');
var userNumber = 0;

element.addEventListener('click', function verif() 
{
    userNumber = document.getElementById('textBox1').value;

    if (userNumber == magicNumber) 
    {
        document.getElementById('label1').textContent = "Bravo!\nVous avez trouvé le nombre magique : !";
    } 
    else if (userNumber > magicNumber) 
    {
        document.getElementById('label1').textContent = "Trop grand ! Rejouer?";
    } 
    else 
    {
        document.getElementById('label1').textContent = "Trop petit ! Rejouer?";
    }
});
*/
