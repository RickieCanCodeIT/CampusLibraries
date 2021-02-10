import { createMainElement } from "./createMainElement.js";

let currentJSON = "";

const displaySingleCampus = function (campus, wholeJSON) {
  currentJSON = wholeJSON;
  const mainContent = document.querySelector(".main-content");
  clearChildren(mainContent);
  const campusLibraryElement = document.createElement("section");
  campusLibraryElement.classList.add("campus-library");
  mainContent.appendChild(campusLibraryElement);

  const libraryHeader = document.createElement("header");
  const libraryLocationElement = document.createElement("h2");
  libraryLocationElement.innerText = campus.location;
  libraryLocationElement.classList.add("campus-library-header__location");
  const libraryTechStack = document.createElement("h3");
  libraryTechStack.classList.add("campus-library-header__tech-stack");
  libraryTechStack.innerText = campus.techStack;

  libraryHeader.appendChild(libraryLocationElement);
  libraryHeader.appendChild(libraryTechStack);
  campusLibraryElement.appendChild(libraryHeader);

  const booksElement = document.createElement("section");
  booksElement.classList.add("campus-books");
  campusLibraryElement.appendChild(booksElement);

  campus.books.forEach((book) => {
    const bookTitle = document.createElement("h3");
    bookTitle.classList.add("book-title");
    bookTitle.innerText = book.title;
    booksElement.appendChild(bookTitle);

    bookTitle.addEventListener("click", () =>
      alert(`This book's summary: ${book.summary}`)
    );
  });

  const backToAllCampuses = document.createElement("a");
  backToAllCampuses.classList.add("back-navigation");
  backToAllCampuses.innerText = "Back to Campus Listings!";
  campusLibraryElement.appendChild(backToAllCampuses);

  backToAllCampuses.addEventListener("click", () => {
    clearChildren(mainContent);
    mainContent.appendChild(createMainElement(currentJSON));
  });
  campusLibraryElement.appendChild(backToAllCampuses);
};

const clearChildren = function (element) {
  while (element.firstChild) {
    element.removeChild(element.lastChild);
  }
};

export { displaySingleCampus };

/*
<main class="main-content">
                <section class="campus-library">
                    <header class="campus-library-header">
                        <h2 class="campus-library-header__location">Columbus</h2>
                        <h3 class="campus-library-header__tech-stack">Java</h3>
                    </header>
                    <section class="campus-books">
                        <h3 class="book-title">Head First Java</h3>
                        <h3 class="book-title">Head First Design Patterns</h3>
                        <h3 class="book-title">Test Driven Development by Example</h3>
                    </section>
                    <a class="back-navigation">back to campus listings</a>
                </section>
            </main>
*/
