document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems);
});

document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.materialboxed');
    var instances = M.Materialbox.init(elems);
});


//DATE Il faut changer les tableau des dates de la fonction materialize
Francais = {
    cancel: 'Annuler',
    clear: 'Effacer',
    done: 'Valider',
    previousMonth: '‹',
    nextMonth: '›',
    months: [
        'Janvier',
        'Février',
        'Mars',
        'Avril',
        'Mai',
        'Juin',
        'Juillet',
        'Août',
        'Septembre',
        'Octobre',
        'Novembre',
        'Décembre'
    ],
    monthsShort: [
        'Jan',
        'Fev',
        'Mar',
        'Avr',
        'Mai',
        'Jun',
        'Jul',
        'Aut',
        'Sep',
        'Oct',
        'Nov',
        'Dec'
    ],

    weekdays: [
        'Dimanche',
        'Lundi',
        'Mardi',
        'Mercredi',
        'Jeudi',
        'Vendredi',
        'Samedi'
    ],

    weekdaysShort: [
        'Dim',
        'Lun',
        'Mar',
        'Mer',
        'Jeu',
        'Ven',
        'Sam'
    ],

    weekdaysAbbrev: ['D', 'L', 'M', 'M', 'J', 'V', 'S']
};
// Options i18n pour changer les dates et format pour value input
var options = {
    i18n: Francais,
    format: 'dd/mm/yyyy',
    firstDay: 1,
    yearRange: [1900, 2002],
    defaultDate: new Date('01-01-1980'),


};

document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
});

$(document).ready(function () {
    $('input#input_text, textarea#textarea1').characterCounter();
});

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.datepicker');
    var instances = M.Datepicker.init(elems, options);
  });