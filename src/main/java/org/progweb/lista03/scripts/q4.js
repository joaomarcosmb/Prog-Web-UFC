const q4Form = document.querySelector("#q4Form");

q4Form.addEventListener("submit", (event) => {
  event.preventDefault();

  let success = false;
  let message = "";

  const value = document.getElementById("inputQ4").value;
  if (value === null || value.trim() === "" || value === "default") {
    success = false;
    message = "Selecione uma opção válida.";
  } else {
    success = true;
  }

  const resultDiv = document.getElementById("resultQ4");
  if (success) {
    resultDiv.classList.remove("error");
    resultDiv.classList.add("success");
    resultDiv.innerText = `O valor selecionado é válido.`;
  } else {
    resultDiv.classList.remove("success");
    resultDiv.classList.add("error");
    resultDiv.innerText = `O valor selecionado é inválido. ${message}`;
  }
});
