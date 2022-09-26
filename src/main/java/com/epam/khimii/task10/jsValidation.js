const usernameReg = new RegExp("^[a-zA-Z0-9_]{2,15}$");
const passwordReg = new RegExp("((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_]).{6,15})");

function checkParams() {
    if (checkUsername() && checkPassword()) {
        document.getElementById("submit").removeAttribute("disabled");
    } else {
        document.getElementById("submit").setAttribute("disabled", "true");
    }
}

function checkUsername() {
    const name = document.getElementById("username").value;
    let match = name.match(usernameReg);
    if (match) {
        document.getElementById("username").style.backgroundColor = "rgba(24,224,74,0.52)";
        return true;
    } else {
        document.getElementById("username").style.backgroundColor = "rgba(255,89,89,0.51)";
        return false;
    }
}

function checkPassword() {
    const password = document.getElementById("password").value;
    let match = password.match(passwordReg);
    if (match) {
        document.getElementById("password").style.backgroundColor = "rgba(24,224,74,0.52)";
        return true;
    } else {
        document.getElementById("password").style.backgroundColor = "rgba(255,89,89,0.51)";
        return false;
    }
}

function openForm() {
    document.getElementById('windowForm').style.display = 'block';
}

function closeForm() {
    document.getElementById('windowForm').style.display = 'none';
}

const modal = document.getElementById('windowForm');
window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
}