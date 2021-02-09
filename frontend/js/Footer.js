const createFooter = function () {
  const footer = document.createElement("footer");
  footer.classList.add("main-footer");
  footer.innerHTML = `
        <small class="main-footer__copyright">We Can Code IT &copy;2020</small>
      `;
  return footer;
};

export { createFooter };

/*

<footer class="main-footer">
                <small class="main-footer__copyright">We Can Code IT &copy;2020</small>
            </footer>

            */
