const usernameReg = new RegExp("^[a-zA-Z0-9_]{2,15}$");
const passwordReg = new RegExp("((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_]).{6,15})");
const nameReg = new RegExp("^[A-Z]{1}[a-z]{1,23}$");
const emailReg = new RegExp("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([c-o\\.]{3})$");

function openForm() {
    document.getElementById('windowForm').style.display = 'block';
}

function closeForm() {
    document.getElementById('windowForm').style.display = 'none';
}

function checkParams() {
    if (checkUsername() && checkFirstName() && checkLastName() && checkEmail() && checkPassword()) {
        $('#submit').removeAttr('disabled');
    } else {
        $('#submit').attr('disabled', 'disabled');
    }
}

function checkUsername() {
    const name = $('#username').val();
    if (usernameReg.test(name)) {
        $('#username').css('background-color', 'green');
        return true;
    } else {
        $('#username').css('background-color', 'red');
        return false;
    }
}

function checkFirstName() {
    const firstName = $('#firstName').val();
    if (nameReg.test(firstName)) {
        $('#firstName').css('background-color', 'green');
        return true;
    } else {
        $('#firstName').css('background-color', 'red');
        return false;
    }
}

function checkLastName() {
    const lastName = $('#lastName').val();
    if (nameReg.test(lastName)) {
        $('#lastName').css('background-color', 'green');
        return true;
    } else {
        $('#lastName').css('background-color', 'red');
        return false;
    }
}

function checkEmail() {
    const email = $('#email').val();
    if (emailReg.test(email)) {
        $('#email').css('background-color', 'green');
        return true;
    } else {
        $('#email').css('background-color', 'red');
        return false;
    }
}

function checkPassword() {
    const password = $('#password').val();
    if (passwordReg.test(password)) {
        $('#password').css('background-color', 'green');
        return true;
    } else {
        $('#password').css('background-color', 'red');
        return false;
    }
}

/*id01 - rename*/
const modal = document.getElementById('windowForm');
window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
}