const q6Form = document.querySelector("#q6Form");

q6Form.addEventListener("submit", (event) => {
  event.preventDefault();

  const checkboxes = document.querySelectorAll(".inputQ6");
  const numAccepted = Array.from(checkboxes).filter((cb) => cb.checked).length;

  const resultDiv = document.getElementById("resultQ6");
  if (numAccepted > 0) {
    resultDiv.classList.remove("error");
    resultDiv.classList.add("success");
    resultDiv.innerText = `Você marcou ${numAccepted} checkbox(es).`;
  } else {
    resultDiv.classList.remove("success");
    resultDiv.classList.add("error");
    resultDiv.innerText = `Você não marcou nenhum checkbox.`;
  }
});
