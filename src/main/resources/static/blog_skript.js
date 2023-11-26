fetch('https://virest.ambitiouspond-6e059caa.westeurope.azurecontainerapps.io/vesti.json')
    .then(response => response.json())
    .then(data => {
        const container = document.getElementById('myData');
        data.vest.forEach(veste => {
            const card = document.createElement('div');
            card.classList.add('card', 'col-md-6', 'mb-6', 'test');
            card.style.maxWidth = '370px';

            const cardBody = document.createElement('div');
            cardBody.classList.add('card-body');
            
            const cardLink = document.createElement('a');
            cardLink.href = veste['card-link'];
            cardLink.classList.add('card-link');

            const titleHeading = document.createElement('h5');
            titleHeading.classList.add('card-title');
            titleHeading.textContent = veste.text;

            const maxDescriptionLength = 76;
            const truncatedDescription = veste.opisni.length > maxDescriptionLength
                ? veste.opisni.slice(0, maxDescriptionLength) + '...'
                : veste.opisni;

            const descriptionParagraph = document.createElement('p');
            descriptionParagraph.classList.add('card-text');
            descriptionParagraph.textContent = truncatedDescription;

            // Create a badge for the date
            const dateBadge = document.createElement('span');
           dateBadge.classList.add('mjau'); // Adjust badge styles as needed
            dateBadge.textContent = veste.datum;

            const image = document.createElement('img');
            image.src = veste.slika;
            image.alt = 'Person Image';
            image.classList.add('card-img-top', 'rounded');
            image.style.height = '204px';
            image.style.width = '368px';

            cardBody.appendChild(image);
            cardBody.appendChild(titleHeading);
            cardBody.appendChild(descriptionParagraph);

            // Append the date badge to the card body
            cardBody.appendChild(dateBadge);

            cardLink.appendChild(cardBody);
            card.appendChild(cardLink);
            container.appendChild(card);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });

var i = 0,
    a = 0,
    isBackspacing = false,
    isParagraph = false;


var textArray = [
  "Zašto ćirilica?", "Зато што је наша!"
  ];


var speedForward = 100,
    speedWait = 1000,
    speedBetweenLines = 1000,
    speedBackspace = 25;



typeWriter("output", textArray);

function typeWriter(id, ar) {
  var element = $("#" + id),
      aString = ar[a],
      eHeader = element.children("h1"),
      eParagraph = element.children("p");


  if (!isBackspacing) {


    if (i < aString.length) {


      if (aString.charAt(i) == "|") {
        isParagraph = true;
        eHeader.removeClass("cursor");
        eParagraph.addClass("cursor");
        i++;
        setTimeout(function(){ typeWriter(id, ar); }, speedBetweenLines);


      } else {

        if (!isParagraph) {
          eHeader.text(eHeader.text() + aString.charAt(i));
          eHeader.css("color", "#3663a0");
        } else {
          eParagraph.text(eParagraph.text() + aString.charAt(i));
          eParagraph.css("color", "#3663a0");
        }

        eHeader.css("font-size", "20px");
        eParagraph.css("font-size", "20px");
        i++;
        setTimeout(function(){ typeWriter(id, ar); }, speedForward);
      }


    } else if (i == aString.length) {

      isBackspacing = true;
      setTimeout(function(){ typeWriter(id, ar); }, speedWait);

    }


  } else {


    if (eHeader.text().length > 0 || eParagraph.text().length > 0) {

      if (eParagraph.text().length > 0) {
        eParagraph.text(eParagraph.text().substring(0, eParagraph.text().length - 1));
      } else if (eHeader.text().length > 0) {
        eParagraph.removeClass("cursor");
        eHeader.addClass("cursor");
        eHeader.text(eHeader.text().substring(0, eHeader.text().length - 1));
      }
      eHeader.css("font-size", "20px");
      eParagraph.css("font-size", "20px");
      setTimeout(function(){ typeWriter(id, ar); }, speedBackspace);

    } else {

      isBackspacing = false;
      i = 0;
      isParagraph = false;
      a = (a + 1) % ar.length;
      setTimeout(function(){ typeWriter(id, ar); }, 50);

    }
  }
}

