// Helper functions
const validateString = (str) => {
  return /^(?=.*\S).+$/.test(str);
};
const validateEmail = (email) => {
  return /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(
    email,
  );
};
const validatePassword = (password) => {
  return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{4,}$/.test(password);
};

const q8Form = document.querySelector("#q8Form");

q8Form.addEventListener("submit", (event) => {
  event.preventDefault();

  const inputs = {
    name: {
      element: document.getElementById("name"),
      value: document.getElementById("name").value.trim(),
      message: "",
    },
    email: {
      element: document.getElementById("email"),
      value: document.getElementById("email").value.trim(),
      message: "",
    },
    password: {
      element: document.getElementById("password"),
      value: document.getElementById("password").value.trim(),
      message: "",
    },
  };

  const keys = Object.keys(inputs);

  Array.from(keys).forEach((key) => {
    if (!inputs[key].value) {
      inputs[key].message = "Campo obrigatório";
    }
  });

  Array.from(keys).forEach((key) => {
    // Valida strings não vazias
    if (inputs[key].value && !validateString(inputs[key].value)) {
      inputs[key].message = "Campo inválido";
    }

    // Valida email
    if (
      key === "email" &&
      inputs[key].value &&
      !validateEmail(inputs[key].value)
    ) {
      inputs[key].message = "Email inválido";
    }

    // Valida senha
    if (
      key === "password" &&
      inputs[key].value &&
      !validatePassword(inputs[key].value)
    ) {
      inputs[key].message =
        "A senha deve conter pelo menos 4 caracteres, incluindo uma letra maiúscula, uma letra minúscula e um caractere especial.";
    }

    if (inputs[key].message) {
      inputs[key].element.nextElementSibling.innerText = inputs[key].message;
      inputs[key].element.nextElementSibling.classList.add("error");
    } else {
      inputs[key].element.nextElementSibling.innerText = "";
      inputs[key].element.nextElementSibling.classList.remove("error");
    }
  });
});
