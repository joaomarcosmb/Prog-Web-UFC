const q3Form = document.querySelector("#q3Form");

q3Form.addEventListener("submit", (event) => {
  event.preventDefault();

  let success = false;
  let message = "";

  const value = document.getElementById("inputQ3").value;
  if (value === null || /^\s+$/.test(value)) {
    success = false;
  } else {
    if (!isNaN(value) && /^\d+$/.test(value) && Number(value) > 0) {
      success = true;
    } else {
      success = false;
      message = "O valor deve ser um número inteiro positivo.";
    }
  }

  const resultDiv = document.getElementById("resultQ3");
  if (success) {
    resultDiv.classList.remove("error");
    resultDiv.classList.add("success");
    resultDiv.innerText = `O valor digitado é válido.`;
  } else {
    resultDiv.classList.remove("success");
    resultDiv.classList.add("error");
    resultDiv.innerText = `O valor digitado é inválido. ${message}`;
  }
});
