<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tag/tags.tld" prefix="captcha"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <style>
        <%@include file="../common/style.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="/WEB-INF/common/SignUpValidation.js"%>
    </script>
</head>
<body>
<div class="topnav">
    <a class="active" href="#">Log out</a>
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
    <h2>Please fill in the
        registration form</h2>
    <button onclick="openForm()" style="width:auto;">Sign Up</button>
</div>
<div id="windowForm" class="modal">
    <form class="modal-content animate" name="SignUpForm" method="POST"
          action="/SignUp">
        <div class="imgcontainer">
            <span onclick="closeForm()" class="close" title="Close Modal">&times;</span>
        </div>
        <div class="container">
            <label><b>Username </b></label>
            <input id="username" onkeyup="checkParams()" oninput="checkUsername()" type="text"
                   placeholder="username" name="username">
            <label><b>First Name</b></label>
            <input id="firstName" onkeyup="checkParams()" oninput="checkFirstName()" type="text"
                   placeholder="firstName" name="firstName">
            <label><b>Last Name </b></label>
            <input id="lastName" onkeyup="checkParams()" oninput="checkLastName()" type="text"
                   placeholder="lastName" name="lastName">
            <label><b>Email</b></label>
            <input id="email" onkeyup="checkParams()" oninput="checkEmail()" type="text"
                   placeholder="email" name="email">
            <label><b>Password</b></label>
            <input id="password" onkeyup="checkParams()" oninput="checkPassword()" type="password"
                   placeholder="password" name="password">
            <captcha:captchaHiddenId/>
            <input id="captcha" name="captcha" type="text" placeholder="Enter Captcha" required/>
            <button id="submit" type="submit" disabled>Sign Up</button>
        </div>
        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="closeForm()" class="cancelbtn">
                Cancel
            </button>
        </div>
    </form>
</div>
</body>
</html>