const q2Form = document.querySelector("#q2Form");

q2Form.addEventListener("submit", (event) => {
  event.preventDefault();

  let success = false;
  let message = "";

  const value = document.getElementById("inputQ2").value;
  if (value === null || value.length === 0 || /^\s+$/.test(value)) {
    success = false;
  } else {
    if (value.length > 0 && value.length <= 10) {
      success = true;
    } else {
      success = false;
      message = "O valor deve conter entre 1 e 10 caracteres.";
    }
  }

  const resultDiv = document.getElementById("resultQ2");
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
