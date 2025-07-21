document.querySelectorAll(".text-input").forEach((element) => {
    element.addEventListener("blur", (event) => {
        if (event.target.value != "") {
            event.target.nextElementSibling.classList.add("filled");
        } else {
            event.target.nextElementSibling.classList.remove("filled");
        }
    });
});

let yearCopyright = document.querySelector('#year-copyright');
let date = new Date;
let year = date.getFullYear();
yearCopyright.textContent = year;