
let allFontData = [];
const fontsPerPage = 10;
let currentPage = 1;
let originalText = "Аа Бб Вв Гг Дд Ђђ Ее Жж Зз Ии Јј Кк Лл Љљ Мм Нн Њњ Оо Пп Рр Сс Тт Ћћ Уу Фф Хх Цц Чч Џџ Шш ";
let enteredText = originalText;

function loadFonts() {
    const styleElement = document.getElementById('font-styles');
    const fontContainer = document.getElementById('font-container');
    fontContainer.innerHTML = '';

    const startIdx = (currentPage - 1) * fontsPerPage;
    const endIdx = startIdx + fontsPerPage;
    const fontsToDisplay = allFontData.slice(startIdx, endIdx);

    fontsToDisplay.forEach(fontData => {
        const fontLink = document.createElement('link');
        fontLink.href = `https://fonts.googleapis.com/css2?family=${encodeURIComponent(fontData.family)}`;
        fontLink.rel = 'stylesheet';
        document.head.appendChild(fontLink);

        const fontStyle = document.createElement('style');
        fontStyle.textContent = `#font-container .${fontData.family.replace(/\s+/g, '-').toLowerCase()} { font-family: '${fontData.family}', sans-serif; }`;
        styleElement.appendChild(fontStyle);

        const fontDiv = document.createElement('div');
        fontDiv.className = 'container';
        fontDiv.innerHTML = `
            <div>
            <div class="title">${fontData.family}</div>
            <div class="line"></div>
            <div class="text-showcase ${fontData.family.replace(/\s+/g, '-').toLowerCase()}">${enteredText}</div>
            <div class="subtle-text">${fontData.family} можете преузети  <a href="${fontData.files.regular}" class="download-link" download>овде</a></div>
            </div>
        `;
        fontContainer.appendChild(fontDiv);
    });

    updatePageInfo();
}

function updateText() {
  const inputElement = document.getElementById('text-input');
  enteredText = inputElement.value.trim();
  enteredText = enteredText || originalText;
  loadFonts();
}

function updatePageInfo() {
    const pageInfo = document.getElementById('page-info');
    const totalPages = Math.ceil(allFontData.length / fontsPerPage);
    pageInfo.innerHTML = "";

    for (let i = 1; i <= totalPages; i++) {
        const pageButton = document.createElement('button');
        pageButton.textContent = i;
        pageButton.classList.add('custom-button');
        pageButton.setAttribute('onclick', `handleButtonClick(${i})`);
    
        pageInfo.appendChild(pageButton);
    }
    
}

function handleButtonClick(pageNumber) {
  console.log(`Handling button click for page ${pageNumber}`);
  
  // Remove the "active" class from all buttons
  const buttons = document.querySelectorAll('.custom-button');
  buttons.forEach(button => button.classList.remove('active'));

  // Add the "active" class to the clicked button
  const clickedButton = document.querySelector(`.custom-button:nth-child(${pageNumber})`);

  if (clickedButton) {
      clickedButton.classList.add('active');
      currentPage = pageNumber;
      loadFonts();
      console.log(`Button ${pageNumber} clicked. Active class added.`);

      // Update URL with the page number
      const newUrl = `/${pageNumber}`;
      history.pushState({ page: pageNumber }, null, newUrl);

      // Scroll to the top of the page
      window.scrollTo({
          top: 0,
          behavior: 'smooth' // You can use 'auto' instead of 'smooth' for instant scrolling
      });
  } else {
      console.warn(`Button ${pageNumber} not found.`);
  }
}



fetch('https://webfonts.googleapis.com/v1/webfonts?capability=CAPABILITY_UNSPECIFIED&sort=POPULARITY&subset=cyrillic&key=AIzaSyDX6UIfPhNCAUB_EWays_FZIWKc06By0ls')
    .then(response => response.json())
    .then(data => {
        allFontData = data.items.map(item => ({
            family: item.family,
            variants: item.variants,
            files: item.files
        }));
        loadFonts();
    })
    .catch(error => console.error('Error fetching JSON:', error));
