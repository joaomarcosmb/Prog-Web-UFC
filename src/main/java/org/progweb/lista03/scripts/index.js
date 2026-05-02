let question = 1;
let results = document.querySelectorAll(".result");

function showQuestion(num) {
  question = num;
  const questions = document.querySelectorAll(".question");
  questions.forEach((q) => {
    q.style.display = "none";
  });
  const currentQuestion = document.getElementById(`q${num}`);
  if (currentQuestion) {
    currentQuestion.style.display = "block";
  }
}

function clearResults() {
  results.forEach((result) => {
    result.innerText = "";
    result.classList.remove("success", "error");
  });
}

document.addEventListener("DOMContentLoaded", () => {
  showQuestion(8);
});

document.getElementById("previous").addEventListener("click", () => {
  if (question > 1) {
    showQuestion(question - 1);
  }
  clearResults();
});

document.getElementById("next").addEventListener("click", () => {
  if (question < 8) {
    showQuestion(question + 1);
  }
  clearResults();
});
