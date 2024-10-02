//ABRIR Y CERRAR DEL NAV BAR
const nav = document.querySelector("#nav");
const abrir = document.querySelector("#abrir");
const cerrar = document.querySelector("#cerrar");

abrir.addEventListener("click", () => {
    nav.classList.add("visible");
})

cerrar.addEventListener("click", () => {
    nav.classList.remove("visible");
})


//SLIDER
const slides = document.querySelectorAll('.slide');
const btns = document.querySelectorAll('.navigation .slidebutton');
let currentSlide = 0;
const totalSlides = slides.length;

//NAVEGACIÓN MANUAL DEL SLIDER
function updateSlide(index) {
  slides.forEach((slide, i) => {
    slide.classList.remove('active');
    btns[i].classList.remove('active');
  });
  slides[index].classList.add('active');
  btns[index].classList.add('active');
}

//BOTONES SLIDE
function nextSlide() {
  currentSlide = (currentSlide + 1) % totalSlides;
  updateSlide(currentSlide);
}

btns.forEach((slidebutton, i) => {
  slidebutton.addEventListener('click', () => {
    currentSlide = i;
    updateSlide(i);
  });
});

//SLIDE AUTOMÁTICO
setInterval(() => {
  nextSlide();
}, 4000); // Change slide every 4 seconds


//IMÁGENES POPUP DE LA GALERÍA
document.querySelectorAll('.gallery img').forEach(image =>{
    image.onclick = () =>{
      document.querySelector('.popup-img').style.display = 'block';
      document.querySelector('.popup-img img').src = image.getAttribute('src');
    }
});

document.querySelector('.popup-img span').onclick = () =>{
    document.querySelector('.popup-img').style.display = 'none';
}