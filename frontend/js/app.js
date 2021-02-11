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

const getHomeViewFromJSON = function () {
  fetch("http://localhost:8080/api/campuses")
    .then((response) => response.json())
    .then((campuses) => displayHomeView(campuses))
    .catch((error) => console.log(error));
};

//-----------------DELETE-------------------
fetch("http://localhost:8080/api/campuses/1", {
  method: "DELETE", // GET, POST, PUT, DELETE, PATCH, etc
  mode: "cors", // cors, no-cors, same-origin
})
  .then((response) => response.json())
  .catch((error) => console.log(error));

//-----------------PATCH--------------------

const bookJSON = {
  title: "New Book",
  summary: "This is a sample book.",
  available: true,
  authors: [{ name: "Sample Author" }, { name: "Another Sample Author" }],
};

fetch("http://localhost:8080/api/campuses/2/books", {
  method: "PATCH", // GET, POST, PUT, DELETE, PATCH, etc
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify(bookJSON),
})
  .then((response) => response.json())
  .then(() => getHomeViewFromJSON())
  .catch((error) => console.log(error));

//-------------------POST-------------------

const campusJSON = {
  location: "New Jersey",
  techStack: "It's a Jersey thing.",
};
fetch("http://localhost:8080/api/campuses", {
  method: "POST", // GET, POST, PUT, DELETE, PATCH, etc
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify(campusJSON),
})
  .then((response) => response.json())
  .then(() => getHomeViewFromJSON())
  .catch((error) => console.log(error));
