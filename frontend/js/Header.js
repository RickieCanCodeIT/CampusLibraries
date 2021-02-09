const createHeader = function () {
  const header = document.createElement("header");
  header.classList.add("main-header");
  header.innerHTML = `
    <h1 class="main-header__title">We Can Code IT Campus Libraries</h1>
    `;
  return header;
};

export { createHeader };

/*

<header class="main-header">
                THis is the header text
                <h1 class="main-header__title">We Can Code IT Campus Libraries</h1>
            </header>

            */
