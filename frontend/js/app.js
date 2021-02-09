import { createHeader } from "./Header.js";
import { sampleJSON } from "./sampleJSON.js";
import { createMainElement } from "./createMainElement.js";
import { createFooter } from "./Footer.js";

const header = createHeader();
const container = document.querySelector(".container");
container.prepend(header);
const main = createMainElement(sampleJSON);
container.appendChild(main);
const footer = createFooter();
container.appendChild(footer);
