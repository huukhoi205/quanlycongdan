// Validate email format
function validateEmail(email) {
    var re = /^[^\s@]+@[^\s@]+\.[a-zA-Z]{2,}$/;
    return re.test(email);
}

// Validate age (0-120)
function validateAge(age) {
    var n = parseInt(age, 10);
    return !isNaN(n) && n >= 0 && n <= 120;
}

// Example usage for form submission
function validateCitizenForm() {
    var email = document.getElementById("email").value;
    var age = document.getElementById("tuoi").value;

    if (!validateEmail(email)) {
        alert("Email không hợp lệ!");
        return false;
    }
    if (!validateAge(age)) {
        alert("Tuổi phải từ 0 đến 120!");
        return false;
    }
    return true;
}
