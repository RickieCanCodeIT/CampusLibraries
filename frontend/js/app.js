import { createHeader } from "./Header.js";
//import { sampleJSON } from "./sampleJSON.js";
import { createMainElement } from "./createMainElement.js";
import { createFooter } from "./Footer.js";

const clearChildren = function (element) {
  while (element.firstChild) {
    element.removeChild(element.lastChild);
  }
};

let header = createHeader();
const container = document.querySelector(".container");
container.prepend(header);
//let main = createMainElement(sampleJSON);
//container.appendChild(main);
let footer = createFooter();
container.appendChild(footer);

const displayHomeView = function (campuses) {
  clearChildren(container);
  header = createHeader();
  container.prepend(header);
  let main = createMainElement(campuses);
  container.appendChild(main);
  footer = createFooter();
  container.appendChild(footer);
};

fetch("http://localhost:8080/api/campuses")
  .then((response) => response.json())
  .then((campuses) => displayHomeView(campuses))
  .catch((error) => console.log(error));
