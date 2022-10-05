<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>
    <%@include file="WEB-INF/common/style.css"%>
</style>
<body>

<div class="topnav">
    <a class="active" href="#">Log out</a>
    <a href="/SignUp"> Sign Up</a>
    <div class="topnav-right">
        <a href="#">Info </a>
        <a href="#">Eng</a>
        <a href="#">Ru</a>
    </div>
</div>
<div style="text-align: center; ">
    <h2>Cash register at your service</h2>
</div>
<div style="text-align: center;">
    <button onclick="openForm()" style="width:auto;">Login</button>
</div>
<div id="loginForm" class="modal">

    <form class="modal-content animate" name="loginForm" method="post" action="login">
        <div class="imgcontainer">
            <span onclick="closeForm()" class="close" title="Close Modal">&times;</span>
        </div>

        <div class="container">
          <b>Username</b>
            <input type="text" placeholder="username" name="username" required>

           <b>Password </b>
            <input type="password" placeholder="Password" name="password" required>
            <button type="submit">Login</button>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="closeForm()" class="cancelbtn">
                Cancel</button>
            <span class="psw"> <a href="/signUpPage">Sign Up</a></span>
        </div>
    </form>
</div>
<script>
    function openForm() {
        document.getElementById('loginForm').style.display = 'block';
    }
    function closeForm() {
        document.getElementById('loginForm').style.display = 'none';
    }
    // Get the modal
    var modal = document.getElementById('loginForm');
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
</body>
</html>

