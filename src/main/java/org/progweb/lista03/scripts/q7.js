const q7Form = document.querySelector("#q7Form");

q7Form.addEventListener("submit", (event) => {
  event.preventDefault();

  const radios = document.querySelectorAll(".inputQ7");
  const numAccepted = Array.from(radios).filter((rb) => rb.checked).length;

  const resultDiv = document.getElementById("resultQ7");
  if (numAccepted == 1) {
    resultDiv.classList.remove("error");
    resultDiv.classList.add("success");
    resultDiv.innerText = `Você marcou um rádio.`;
  } else {
    resultDiv.classList.remove("success");
    resultDiv.classList.add("error");
    resultDiv.innerText = `Você deve marcar um rádio.`;
  }
});
