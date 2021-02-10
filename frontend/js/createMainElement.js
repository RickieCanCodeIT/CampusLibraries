import { displaySingleCampus } from "./displaySingleCampus.js";

const createMainElement = function (campuses) {
  const mainElement = document.createElement("main");
  mainElement.classList.add("main-content");
  const sectionElement = document.createElement("section");
  sectionElement.classList.add("campus-list");
  mainElement.prepend(sectionElement);
  campuses.forEach((campus) => {
    const divElement = document.createElement("div");
    divElement.classList.add("campus");

    const h2Element = document.createElement("h2");
    h2Element.classList.add("campus-location");
    h2Element.innerText = campus.location;
    h2Element.addEventListener("click", () =>
      displaySingleCampus(campus, campuses)
    );
    divElement.appendChild(h2Element);

    const h3Element = document.createElement("h3");
    h3Element.classList.add("campus-tech-stack");
    h3Element.innerText = campus.techStack;
    divElement.appendChild(h3Element);

    /*divElement.innerHTML = `
        <h2 class="campus-location">${campus.location}</h2>
        <h3 class="campus-tech-stack">${campus.techStack}</h3>
        `;*/
    sectionElement.appendChild(divElement);
  });
  return mainElement;
};

export { createMainElement };

/*

<main class="main-content">
                <section class="campus-list">
                    <div class="campus">
                        <h2 class="campus-location">Columbus</h2>
                        <h3 class="campus-tech-stack">Java</h3>
                    </div>
                    <div class="campus">
                        <h2 class="campus-location">Cleveland</h2>
                        <h3 class="campus-tech-stack">C#</h3>
                    </div>
                    <div class="campus">
                        <h2 class="campus-location">The MOON</h2>
                        <h3 class="campus-tech-stack">JavaScript</h3>
                    </div>
                </section>
            </main>

            */
