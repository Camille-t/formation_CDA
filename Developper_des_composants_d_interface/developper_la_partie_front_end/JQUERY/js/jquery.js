$(document).ready(function () { // all jQuery methods are inside a document ready event in order to prevent any jQuery code from running before the document is finished loading (is ready)
    // put all jQuery objects in variables

    var lastName = $('#lastName'),
        firstName = $('#firstName'),
        adress = $('#adress'),
        postalCode = $('#postalCode'),
        city = $('#city'),
        email = $('#icon_prefix'),
        telephone = $('#icon_telephone'),
        subject = $('#subject'),
        question = $('#textarea1'),
        accept = $('#accept'),
        submit = $('#submit'),

        // all <span> that are used to warn when there are errors in inputs
        errorLastName = $('#errorLastName'),
        errorFirstName = $('#errorFirstName'),
        errorAdress = $('#errorAdress'),
        errorPostalCode = $('#errorPostalCode'),
        errorCity = $('#errorCity'),
        errorEmail = $('#errorEmail'),
        errorTelephone = $('#errorTelephone'),
        errorSubject = $('#errorSubject'),
        errorQuestion = $('#errorQuestion'),
        errorAccept = $('#errorAccept'),

        // RegeX and messages to display when they do not match
        patternName = /^[a-zA-Z]{2,}$/,
        errorPatternLastName = 'Le nom ne doit comporter que des lettres (minimum 2).',
        errorPatternFirstName = 'Le prénom ne doit comporter que des lettres (minimum 2).',
        patternAdress = /^[0-9]*[a-zA-Z,\.\s]+[0-9]*$/,
        errorPatternAdress = 'L\'adresse est invalide.',
        errorPatternCity = 'Le nom de la ville est invalide.',
        patternPostalCode = /^[0-9]{2}\s?[0-9]{3}$/,
        errorPatternPostalCode = 'Le code postal est invalide.',
        patternEmail = /^[_a-z0-9-]+(.[_a-z0-9-]+)*@+[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/,
        errorPatternEmail = 'L\'email est invalide.',
        patternTelephone = /^(0)([1-9])(\s)?([0-9]){2}(\s)?([0-9]){2}(\s)?([0-9]){2}(\s)?([0-9]){2}$/,
        errorPatternTelephone = 'Le numéro de téléphone saisi n\'est pas valide',
        patternQuestion = /(.){50,120}/,
        errorPatternQuestion = 'Vous devez saisir entre 50 et 120 caractères.';

        // implementation of an input control for each form's field that will display error messages when needed :
/*
    The change event occurs when the value of an element has been changed. 
    The change() method attaches a function to run when a change event occurs. 
    For text-fields, the change event occurs when the field loses focus, after the content has been changed. 
    the val() method returns the value attribute of the selected element. 
    Whe then use the match() method to search the selected element (that contains the string entered by user) for a match against a RegExp
    If the variable tested does not match the RegExp we display the error message using text() method that sets the text content of the selected element
    We also use the css() method to set style properties for the selected element.
    If the tested element matches the RegExp, we use the text(method) to display an empty string instead of our error message.
*/

    lastName.change(function () {
        if (!$(this).val().match(patternName)) { 
            errorLastName.text(errorPatternLastName);
            errorLastName.css('color', 'red');
        } else {
            errorLastName.text('');
        }
    });

    firstName.change(function () {
        if (!$(this).val().match(patternName)) {
            errorFirstName.text(errorPatternFirstName);
            errorFirstName.css('color', 'red');
        } else {
            errorFirstName.text('');
        }
    });

    adress.change(function () {
        if (!$(this).val().match(patternAdress)) {
            errorAdress.text(errorPatternAdress);
            errorAdress.css('color', 'red');
        } else {
            errorAdress.text('');
        }
    });

    postalCode.change(function () {
        if (!$(this).val().match(patternPostalCode)) {
            errorPostalCode.text(errorPatternPostalCode);
            errorPostalCode.css('color', 'red');
        } else {
            errorPostalCode.text('');
        }
    });

    city.change(function () {
        if (!$(this).val().match(patternAdress)) {
            errorCity.text(errorPatternCity);
            errorCity.css('color', 'red');
        } else {
            errorCity.text('');
        }
    });

    email.change(function () {
        if (!$(this).val().match(patternEmail)) {
            errorEmail.text(errorPatternEmail);
            errorEmail.css('color', 'red');
        } else {
            errorEmail.text('');
        }
    });

    telephone.change(function () {
        if (!$(this).val().match(patternTelephone)) {
            errorTelephone.text(errorPatternTelephone);
            errorTelephone.css('color', 'red');
        } else {
            errorTelephone.text('');
        }
    });

    subject.change(function () { // change () event handler on our <select id="subject"> .
        $('#textareaLabel').hide(); // hides textarea's label
        question.text('Sujet : ' + $(this).val()); // text corresponding to our <select> goes in <textarea1>
    });

    question.change(function () {
        if (!$(this).val().match(patternQuestion)) {
            errorQuestion.text(errorPatternQuestion);
            errorQuestion.css('color', 'red');
        } else {
            errorQuestion.text('');
        }
    });

        // We then use a function that will check every fields.
        // This function will return a value : true or false, that we store in a submit variable.
        // If tested elements return a value that doesn't match RegExp or if the user leaves any empty field,
        // we store the value : false in submit var and, 
        // we use css() and text() methods to display error messages   

    function check() {
        var submit = true;

        if (lastName.val() == '') {
            submit = false;
            errorLastName.text('obligatoire');
            errorLastName.css('color', 'red');
            lastName.css('border-bottom', '1px solid red');
        } else if (!lastName.val().match(patternName)) {
            submit = false;
            errorLastName.text(errorPatternLastName);
            errorLastName.css('color', 'red');
            lastName.css('border-bottom', '1px solid red');
        }

        if (firstName.val() == '') {
            submit = false;
            errorFirstName.text('obligatoire');
            errorFirstName.css('color', 'red');
            firstName.css('border-bottom', '1px solid red');
        } else if (!firstName.val().match(patternName)) {
            submit = false;
            errorFirstName.text(errorPatternFirstName);
            errorFirstName.css('color', 'red');
            firstName.css('border-bottom', '1px solid red');
        }

        if (adress.val() == '') {
            submit = false;
            errorAdress.text('obligatoire');
            errorAdress.css('color', 'red');
            adress.css('border-bottom', '1px solid red');
        } else if (!adress.val().match(patternAdress)) {
            submit = false;
            errorAdress.text(errorPatternAdress);
            errorAdress.css('color', 'red');
            adress.css('border-bottom', '1px solid red');
        }

        if (postalCode.val() == '') {
            submit = false;
            errorPostalCode.text('obligatoire');
            errorPostalCode.css('color', 'red');
            postalCode.css('border-bottom', '1px solid red');
        } else if (!postalCode.val().match(patternPostalCode)) {
            submit = false;
            errorPostalCode.text(errorPatternPostalCode);
            errorPostalCode.css('color', 'red');
            postalCode.css('border-bottom', '1px solid red');
        }

        if (city.val() == '') {
            submit = false;
            errorCity.text('obligatoire');
            errorCity.css('color', 'red');
            city.css('border-bottom', '1px solid red');
        } else if (!city.val().match(patternAdress)) {
            submit = false;
            errorCity.text(errorPatternCity);
            errorCity.css('color', 'red');
            city.css('border-bottom', '1px solid red');
        }

        if (email.val() == '') {
            submit = false;
            errorEmail.text('obligatoire');
            errorEmail.css('color', 'red');
            email.css('border-bottom', '1px solid red');
        } else if (!email.val().match(patternEmail)) {
            submit = false;
            errorEmail.text(errorPatternEmail);
            errorEmail.css('color', 'red');
            email.css('border-bottom', '1px solid red');
        }

        if (telephone.val() == '') {
            submit = false;
            errorTelephone.text('obligatoire');
            errorTelephone.css('color', 'red');
            telephone.css('border-bottom', '1px solid red');
        } else if (!telephone.val().match(patternTelephone)) {
            submit = false;
            errorTelephone.text(errorPatternTelephone);
            errorTelephone.css('color', 'red');
            telephone.css('border-bottom', '1px solid red');
        }

        if (subject.val() == null) {
            submit = false;
            errorSubject.text('obligatoire');
            errorSubject.css('color', 'red');
        }

        if (question.val() == null) {
            submit = false;
            errorQuestion.text('obligatoire');
            errorQuestion.css('color', 'red');
        }

        if (!question.val().match(patternQuestion)) {
            errorQuestion.text(errorPatternQuestion);
            errorQuestion.css('color', 'red');
        }

        if (accept.prop('checked') == false) {
            submit = false;
            errorAccept.text('Vous devez accepter le traitement informatique de ce formulaire.');
            errorAccept.css('color', 'red');
        }

        // If submit == true for every fields we can finally submit the form.

        if (submit == true) {
            alert('Le formulaire a bien été envoyé');
            document.forms[0].submit();
        }
        else {
            return false;
        }
    }

        // When user clicks on submit button we trigger a function that will prevent the form (e) from being submitted.
        // We then call our check() function (if it returns true our form will be submitted). 
    submit.click(function (e) {

        e.preventDefault();
        check();
    });
});
