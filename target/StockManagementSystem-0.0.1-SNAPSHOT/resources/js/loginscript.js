document.addEventListener("DOMContentLoaded", function () {
    const loginButton = document.getElementById("login");
    const registerButton = document.getElementById("register");
    const signUpForm = document.querySelector(".form-container.sign-up");
    const signInForm = document.querySelector(".form-container.sign-in");

    loginButton.addEventListener("click", function () {
        signInForm.classList.add("active");
        signUpForm.classList.remove("active");
    });

    registerButton.addEventListener("click", function () {
        signUpForm.classList.add("active");
        signInForm.classList.remove("active");
    });

    
    signInForm.classList.add("active");
});
 container = document.getElementById("container");
const registerBtn = document.getElementById("register");
const loginBtn = document.getElementById("login");

registerBtn.addEventListener("click", () => {
  container.classList.add("active");
});

loginBtn.addEventListener("click", () => {
  container.classList.remove("active");
});