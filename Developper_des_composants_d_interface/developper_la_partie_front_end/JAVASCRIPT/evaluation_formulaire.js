
// REGEXP PATTERN
var atLeastOneCharacterPattern = new RegExp(/[\w\s]+/);
var fiveDigitPattern = new RegExp(/^\d{2}\s?\d{3}$/);
var onlyOneAtPattern = new RegExp(/\w@\w/);

// TESTED ELEMENTS 
var societyField = document.getElementById('society');
var contactPersonField = document.getElementById('contactPerson');
var zipCodeField = document.getElementById('zipCode');
var cityField = document.getElementById('city');
var emailField = document.getElementById('email');
var form = document.getElementById('contactForm');

// FIELDS CONTAINING ERROR MESSAGES
var societyFieldError = document.getElementById('societyError');
var contactPersonFieldError = document.getElementById('contactPersonError');
var zipCodeFieldError = document.getElementById('zipCodeError');
var cityFieldError = document.getElementById('cityError');
var emailFieldError = document.getElementById('emailError');

// CHECK

societyField.addEventListener('blur', function (e) {
    if (societyField.value === '') {
        societyField.className = 'invalid';
        societyFieldError.textContent = 'Ce champs est obligatoire.';
        societyFieldError.className = 'error active';
    }
    else if (atLeastOneCharacterPattern.test(societyField.value) === false) {
        societyField.className = 'invalid';
        societyFieldError.textContent = 'Le nom de la société doit comporter au moins un caractère alphanumérique.';
        societyFieldError.className = 'error active';
    }
    else {
        societyField.className = 'valid';
        societyFieldError.textContent = '';
        societyFieldError.className = 'error';

    }
});

contactPersonField.addEventListener('blur', function (e) {
    if (contactPersonField.value === '') {
        contactPersonField.className = 'invalid';
        contactPersonFieldError.textContent = 'Ce champs est obligatoire.';
        contactPersonFieldError.className = 'error active';
    }
    else if (atLeastOneCharacterPattern.test(contactPersonField.value) === false) {
        contactPersonField.className = 'invalid';
        contactPersonFieldError.textContent = 'Le nom de la personne à contacter doit comporter au moins un caractère alphanumérique.';
        contactPersonFieldError.className = 'error active';
    }
    else {
        contactPersonField.className = 'valid';
        contactPersonFieldError.textContent = '';
        contactPersonFieldError.className = 'error';
    }
});

zipCodeField.addEventListener('blur', function (e) {
    if (zipCodeField.value === '') {
        zipCodeField.className = 'invalid';
        zipCodeFieldError.textContent = 'Ce champs est obligatoire.';
        zipCodeFieldError.className = 'error active';
    }
    else if (fiveDigitPattern.test(zipCodeField.value) === false) {
        zipCodeField.className = 'invalid';
        zipCodeFieldError.textContent = 'Le code postal doit comporter 5 caractères numériques.';
        zipCodeFieldError.className = 'error active';
    }
    else {
        zipCodeField.className = 'valid';
        zipCodeFieldError.textContent = '';
        zipCodeFieldError.className = 'error';
    }
});

cityField.addEventListener('blur', function (e) {
    if (cityField.value === '') {
        cityField.className = 'invalid';
        cityFieldError.textContent = 'Ce champs est obligatoire.';
        cityFieldError.className = 'error active';
    }
    else if (atLeastOneCharacterPattern.test(cityField.value) === false) {
        cityField.className = 'invalid';
        cityFieldError.textContent = 'Le nom de la ville doit comporter au moins un caractère alphanumérique.';
        cityFieldError.className = 'error active';
    }
    else {
        cityField.className = 'valid';
        cityFieldError.textContent = '';
        cityFieldError.className = 'error';
    }
});

emailField.addEventListener('blur', function (e) {
    if (emailField.value === '') {
        emailField.className = 'invalid';
        emailFieldError.textContent = 'Ce champs est obligatoire.';
        emailFieldError.className = 'error active';
    }
    else if (onlyOneAtPattern.test(emailField.value) === false) {
        emailField.className = 'invalid';
        emailFieldError.textContent = 'L\'email doit comporter au moins un caractère @.';
        emailFieldError.className = 'error active';
    }
    else {
        emailField.className = 'valid';
        emailFieldError.textContent = '';
        emailFieldError.className = 'error';
    }
});

function submitForm(event) // fonction qui va vérifier que tous les champs obligatoires ne sont pas vides et qui le cas échéant va bloquer l'envoi du formulaire et afficher une alerte 
{
    if ((this.elements.society.value === '') || (atLeastOneCharacterPattern.test(societyField.value) === false) || (this.elements.contactPerson.value === '') ||
        (atLeastOneCharacterPattern.test(contactPersonField.value) === false) ||
        (this.elements.zipCode.value === '') ||
        (fiveDigitPattern.test(zipCodeField.value) === false) ||
        (this.elements.city.value === '') ||
        (atLeastOneCharacterPattern.test(cityField.value) === false) ||
        (this.elements.email.value === '') ||
        (onlyOneAtPattern.test(email.value) === false)) {
        event.preventDefault();
        alert("Veuillez remplir correctement tous les champs obligatoires");
    }
};

form.addEventListener('submit', submitForm, false); // la fonction submitForm se déclenchera quand l'utilisateur soumettra l'envoi du formulaire.
