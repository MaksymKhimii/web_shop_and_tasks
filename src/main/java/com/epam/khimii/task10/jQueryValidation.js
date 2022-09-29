const usernameReg = new RegExp("^[a-zA-Z0-9_]{2,15}$");
const passwordReg = new RegExp("((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_]).{6,15})");

function openForm() {
    document.getElementById('windowForm').style.display = 'block';
}

function closeForm() {
    document.getElementById('windowForm').style.display = 'none';
}

function checkParams() {
    if (checkUsername() && checkPassword()) {
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