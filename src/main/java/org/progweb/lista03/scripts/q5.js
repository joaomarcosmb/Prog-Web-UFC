const q5Form = document.querySelector("#q5Form");

q5Form.addEventListener("submit", (event) => {
  event.preventDefault();

  let success = false;
  let message = "";

  const checkbox = document.getElementById("inputQ5");
  if (!checkbox.checked) {
    success = false;
    message = "Você deve aceitar os termos e condições.";
  } else {
    success = true;
  }

  const resultDiv = document.getElementById("resultQ5");
  if (success) {
    resultDiv.classList.remove("error");
    resultDiv.classList.add("success");
    resultDiv.innerText = `Você aceitou os termos e condições.`;
  } else {
    resultDiv.classList.remove("success");
    resultDiv.classList.add("error");
    resultDiv.innerText = `${message}`;
  }
});
