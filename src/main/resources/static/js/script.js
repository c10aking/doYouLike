function validateForm() {
    const memberId = document.getElementById('memberId').value;
    const password = document.getElementById('password').value;

    if (memberId.trim() === '' || password.trim() === '') {
        alert('Please fill in all the required fields.');
        return false;
    }

    // more logic needed, "This ID doesn't exist", "Password is incorrect"

    return true;
}

function validateSignUpForm() {
    const memberId = document.getElementById('memberId').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const name = document.getElementById('name').value;
    const gender = document.getElementById('gender').value;
    const email = document.getElementById('email').value;
    const birthYear = document.getElementById('birthYear').value;
    const major = document.getElementById('major').value;

    if (memberId.trim() === '' || password.trim() === '' || confirmPassword.trim() === '' || name.trim() === '' ||
        gender.trim() === '' || email.trim() === '' || birthYear.trim() === '' || major.trim() === '') {
        alert('Please fill in all the required fields.');
        return false;
    }

    if (!isPasswordValid(password)) {
        alert(
            'Password must be at least 12 characters long and contain a combination of letters, numbers, and symbols (@ $ ! % * # ? &).'
        );
        return false;
    }

    if (password !== confirmPassword) {
        alert('Passwords do not match.');
        return false;
    }

    return true;
}


function isPasswordValid(password) {
    if (password.length < 12) {
        return false;
    }

    const letterRegex = /[a-zA-Z]/;
    const numberRegex = /[0-9]/;
    const symbolRegex = /[@$!%*#?&]/;

    if (!letterRegex.test(password) || !numberRegex.test(password) || !symbolRegex.test(password)) {
        return false;
    }

    return true;
}


function togglePasswordVisibility(event) {
    const target = event.target;
    const passwordInput = document.getElementById("password");
    const eyeIcon = document.getElementById("eye-icon");
    const confirmPasswordInput = document.getElementById("confirmPassword");
    const cEyeIcon = document.getElementById("cEye-icon");

    if (target === eyeIcon) {
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            eyeIcon.classList.add("show-password");
        } else {
            passwordInput.type = "password";
            eyeIcon.classList.remove("show-password");
        }
    } else if (target === cEyeIcon) {
        if (confirmPasswordInput.type === "password") {
            confirmPasswordInput.type = "text";
            cEyeIcon.classList.add("show-password");
        } else {
            confirmPasswordInput.type = "password";
            cEyeIcon.classList.remove("show-password");
        }
    }
}



const idCheck = () => {
    const id = document.getElementById("memberId").value;
    const checkResult = document.getElementById("check-result");
    console.log("value: ", id);
    $.ajax({
        type: "post",
        url: "/member/id-check",
        data: {
            "memberId": id
        },
        success: function(res) {
            console.log("success", res);
            if (res == "ok") {
                console.log("this ID is usable");
                checkResult.style.color = "green";
                checkResult.innerHTML = "This ID is usable";
            } else {
                console.log("this id is already being used");
                checkResult.style.color = "red";
                checkResult.innerHTML = "This ID is already being used";
            }
        },
        error: function(err) {
            console.log("error occurred", err);
        }
    });
};
