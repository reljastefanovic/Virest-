$(document).ready(function(){
    fetch('https://virest.ambitiouspond-6e059caa.westeurope.azurecontainerapps.io/fetch-komentar')
        .then(response => response.json())
        .then((json) => {
            const filteredThemes = json.komentari.filter(theme => theme.sekcija_id === 4);

            const cardMarkup = filteredThemes.map(theme => `
                <div class="row pb-1 pt-4 forum-item">
                    <div class="col-1 pt-1 text-center">
                    <svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
                      </svg>
                    </div>
                    <div class="col-9">

                            <h5>${theme.korisnik_username}</h5>

                         <p>
                                                    ${theme.komentar.substring(0, 100)}
                                                </p>
                                                <p>
                                                    ${theme.komentar.substring(100, 200)}
                                                </p>
                    </div>
                </div>
                <hr>
            `).join('');

            $("#sadzaj").html(cardMarkup);
        });
});
