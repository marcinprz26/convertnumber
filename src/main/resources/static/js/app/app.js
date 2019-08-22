$(document).ready(function () {

    var selected = "";
    initNumberSystem();

    onSystemButtonClick();

    validation();
});

function onSystemButtonClick() {
    $('#system-group').children().bind('click', function () {
        $('#system-error').hide();
        swapBtn(this)
    });
}

function validation() {
    $("#convertion-form").submit( function() {
        var valid = true;
        if(selected == "") {
            $('#system-error').html( "*Select one of number systems");
            $('#system-error').show();
            return false;
        } else {
            switch(selected) {
                case "HEX":
                    valid = validateHex();
                    break;
                case "ROM":
                    valid = validateRom();
                    break;
            }
            if(!valid) {
                return false;
            }
        }
        $('#system').val(selected);
        return true;
    });
}
//Init number systems buttons values
function initNumberSystem() {
    switch ($('#system').val()) {
        case "HEX":
            swapBtn($('#hex-btn'));
            break;
        case "ROM":
            swapBtn($('#rom-btn'));
            resultDecoration();
            break;
        default:
            selected = "";
            $('#hex-btn').css("background-color", "#9595a8");
            $('#rom-btn').css("background-color", "#9595a8");
    }
    $('#system-error').hide();
    $('#digit-error').hide();
}

//Swap background color of selected button
function swapBtn(elem) {
    $(elem).css("background-color", "#007bff");
    selected = $(elem).val();
    $(elem).siblings().css("background-color", "#9595a8");
}

//Is valid hex number
function validateHex() {
    if($('#decimal').val() < 0) {
        $('#digit-error').html("*For convert to hexadecimal number, value must be greater or equal to 0");
        $('#digit-error').show();
        return false;
    }
    $('#digit-error').hide();
    return true;
}

//Is valid roman number
function validateRom() {
    if($('#decimal').val() <= 0) {
        $('#digit-error').html("*For convert to roman numeral, value must be greater than 0");
        $('#digit-error').show();
        return false;
    } else if($('#decimal').val() >= 4000000) {
        $('#digit-error').html("*For convert to roman numeral, value must be less than 4000000");
        $('#digit-error').show();
        return false;
    }
    $('#digit-error').hide();
    return true;
}

//Convert thousands signs to sign with overline for roman numerals
function resultDecoration() {
    var signs = ['V', 'X', 'L', 'C', 'D', 'M'];
    var result = $('#result').text();
    for(var i=0; i<signs.length; i++) {
        var sign = '_' + signs[i];
        result = result.split(sign).join('<span class="sign-decor">' + signs[i] + '</span>');
    }
    $('#result').html(result);
}