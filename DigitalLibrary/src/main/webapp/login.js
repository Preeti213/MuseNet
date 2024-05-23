 document.addEventListener("DOMContentLoaded", function() {
    let signup = document.querySelector(".signup");
    let login = document.querySelector(".login");
    let slider = document.querySelector(".slider");
    let loginBox = document.querySelector(".login-box");
    let signupBox = document.querySelector(".signup-box");

    // Initially display the login form
    loginBox.style.display = "block";
    signupBox.style.display = "none";

    signup.addEventListener("click", () => {
        slider.classList.add("moveslider");
        loginBox.style.display = "none";
        signupBox.style.display = "block";
    });
     
    login.addEventListener("click", () => {
        slider.classList.remove("moveslider");
        signupBox.style.display = "none";
        loginBox.style.display = "block";
    });
});
function openFileFolder() {
    // Simulate a click on the file input element
    document.querySelector('.profile-icon input[type="file"]').click();
}
function previewPhoto(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imageUrl = e.target.result;
            const profileIcon = document.querySelector('.profile-icon');
            profileIcon.style.backgroundImage = `url('${imageUrl}')`; // Update background image
        };
        reader.readAsDataURL(file);
    }
}

//Function to check if the passwords match and meet criteria
function checkPassword() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var passwordMatchMessage = document.getElementById("passwordMatchMessage");
    var passwordCriteriaMessage = document.getElementById("passwordCriteriaMessage");

    // Check if passwords match
    if (password !== confirmPassword) {
        passwordMatchMessage.textContent = "Passwords do not match";
        passwordMatchMessage.style.color = "red";
    } else {
        passwordMatchMessage.textContent = "";
        passwordMatchMessage.style.color = "green";
    }

    // Check password criteria (at least 8 characters long and containing letters, numbers, and special characters)
    var criteriaRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (password.length < 8 || !criteriaRegex.test(password)) {
        passwordCriteriaMessage.textContent = "Password must be at least 8 characters long and contain letters, numbers, and special characters";
        passwordCriteriaMessage.style.color = "red";
    } else {
        passwordCriteriaMessage.textContent = "";
        passwordCriteriaMessage.style.color = "green";
    }
}

// Add event listeners to both password fields to check for password match and criteria on input change
document.getElementById("password").addEventListener("input", checkPassword);
document.getElementById("confirmPassword").addEventListener("input", checkPassword);


document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("email").addEventListener("input", checkEmailAvailability);
});

function checkEmailAvailability() {
    var email = document.getElementById("email").value;

    // Make AJAX request to server to check email availability
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var response = xhr.responseText;
                // Handle the response from the server
                var emailMessage = document.getElementById("emailMessage");
                if (response === "available") {
                    emailMessage.textContent = "";
                    emailMessage.style.color = "green";
                } else {
                    emailMessage.textContent = "Email is not available";
                    emailMessage.style.color = "red";
                }
            } else {
                // Handle error
                console.error("Error:", xhr.status);
            }
        }
    };
    xhr.open("GET", "CheckEmailAvailabilityServlet?email=" + encodeURIComponent(email), true);
    xhr.send();
}
$(document).ready(function() {
    $('#submitBtn').click(function() {
        var formData = new FormData($('#signupForm')[0]);
        
        // If image is not selected, append default image
        if ($('#image').get(0).files.length === 0) {
            var defaultImagePromise = loadDefaultImage();
            defaultImagePromise.then(function(blob) {
                formData.append('image', blob, 'img/avatar.png');
                sendSignupRequest(formData);
            });
        } else {
            sendSignupRequest(formData);
        }
    });
});

function loadDefaultImage() {
    return new Promise(function(resolve, reject) {
        var defaultImage = 'img/avatar.png';
        var xhr = new XMLHttpRequest();
        xhr.open('GET', defaultImage, true);
        xhr.responseType = 'blob';
        xhr.onload = function() {
            if (xhr.status === 200) {
                resolve(xhr.response);
            } else {
                reject(new Error('Failed to load default image'));
            }
        };
        xhr.onerror = function() {
            reject(new Error('Failed to load default image'));
        };
        xhr.send();
    });
}

function sendSignupRequest(formData) {
    $.ajax({
        url: 'signupUser',
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
            // Handle success
            console.log(response);
        },
        error: function(xhr, status, error) {
            // Handle error
            console.error(error);
        }
    });
}