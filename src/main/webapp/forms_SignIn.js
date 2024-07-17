
function validate() {
    var usernamep = /^[A-Za-z]+$/;
    var username = document.getElementById("userName").value.trim();
    var pswdp = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,}$/;
    var pswd = document.getElementById("password").value.trim();

    // Clear all error messages
    document.getElementById("msg3").innerHTML = "";
    document.getElementById("msg4").innerHTML = "";

    var isValid = true;


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
        
        document.getElementById("msg3").innerHTML = "";
        document.getElementById("msg4").innerHTML = "";
    }

    return isValid;
}
