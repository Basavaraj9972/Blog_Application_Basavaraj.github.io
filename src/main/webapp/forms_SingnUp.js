function validate() {
    var unp = /^[A-Za-z]+$/;
    var un = document.getElementById("name").value.trim();
    var php = /^[6-9]{1}[0-9]{9}$/;
    var ph = document.getElementById("phone").value.trim();
    var emailp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    var email = document.getElementById("email").value.trim();
    var usernamep = /^[A-Za-z]+$/;
    var username = document.getElementById("userName").value.trim();
    var pswdp = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,}$/;
    var pswd = document.getElementById("password").value.trim();

    // Clear all error messages
    document.getElementById("msg").innerHTML = "";
    document.getElementById("msg1").innerHTML = "";
    document.getElementById("msg2").innerHTML = "";
    document.getElementById("msg3").innerHTML = "";
    document.getElementById("msg4").innerHTML = "";

    var isValid = true;

    if (un === "") {
        document.getElementById("msg").innerHTML = "Username can't be empty";
        isValid = false;
    } else if (!un.match(unp)) {
        document.getElementById("msg").innerHTML = "Username should contain alphabets only";
        isValid = false;
    } else if (un.length < 3 || un.length > 15) {
        document.getElementById("msg").innerHTML = "Username should be between 3 and 15 characters";
        isValid = false;
    }

    if (email === "") {
        document.getElementById("msg1").innerHTML = "Email can't be empty";
        isValid = false;
    } else if (!email.match(emailp)) {
        document.getElementById("msg1").innerHTML = "Email address containing only letters, numbers, dots, underscores, hyphens, and @ .then character";
        isValid = false;
    }

    if (ph === "") {
        document.getElementById("msg2").innerHTML = "Phone number can't be empty";
        isValid = false;
    } else if (!ph.match(php)) {
        document.getElementById("msg2").innerHTML = "phone number must stararts with 6 and contains 10 digit";
        isValid = false;
    }

    if (username === "") {
        document.getElementById("msg3").innerHTML = "Username can't be empty";
        isValid = false;
    } else if (!username.match(usernamep)) {
        document.getElementById("msg3").innerHTML = "User Name should contain alphabets only";
        isValid = false;
    } else if (username.length < 3 || username.length > 15) {
        document.getElementById("msg3").innerHTML = "Username should be between 3 and 15 characters";
        isValid = false;
    }

    if (pswd === "") {
        document.getElementById("msg4").innerHTML = "Password can't be empty";
        isValid = false;
    } else if (!pswd.match(pswdp)) {
        document.getElementById("msg4").innerHTML = "Password should contain 8 character including minimum one Uppercase,one Lowercase,one number any one special character";
        isValid = false;
    }

    // Clear all error messages if the form is valid
    if (isValid) {
        document.getElementById("msg").innerHTML = "";
        document.getElementById("msg1").innerHTML = "";
        document.getElementById("msg2").innerHTML = "";
        document.getElementById("msg3").innerHTML = "";
        document.getElementById("msg4").innerHTML = "";
    }

    return isValid;
}
