const q1Form = document.querySelector("#q1Form");

q1Form.addEventListener("submit", (event) => {
  event.preventDefault();

  let success = false;

  const value = document.getElementById("inputQ1").value;
  if (value === null || value.length === 0 || /^\s+$/.test(value)) {
    success = false;
  } else {
    success = true;
  }

  const resultDiv = document.getElementById("resultQ1");
  if (success) {
    resultDiv.classList.remove("error");
    resultDiv.classList.add("success");
    resultDiv.innerText = `O valor digitado é válido.`;
  } else {
    resultDiv.classList.remove("success");
    resultDiv.classList.add("error");
    resultDiv.innerText = `O valor digitado é inválido.`;
  }
});
