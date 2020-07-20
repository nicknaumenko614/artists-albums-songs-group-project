import {clearElementChildren} from "./utils.js";
import {renderArtist} from "./singleArtistView.js";
import {postNewArtist} from "./apiHelper.js";

const renderAllArtists = (element, artists) => {
    clearElementChildren(element);

    element.innerHTML = `
         <section class = "artists">
           <h2>Please select from Artists below:</h2>
           </section>   
        `;
    const artistsList = document.createElement('ul')

    for (let i = 0; i < artists.length; i++) {
        const li = document.createElement('li');
        li.classList.add('artist');
        li.innerHTML = `
            <a class="artist__name">${artists[i].artistName}</a>  
             
        `;
        artistsList.append(li);
        li.addEventListener('click', () => {
            renderArtist(element, artists[i]);
        });
        element.append(artistsList);
    }
    ;

    displayNewArtistForm(element);
}


export {
    renderAllArtists
}

function displayNewArtistForm(element) {
    const nameInput = document.createElement('input');
    nameInput.type = 'text';
    nameInput.placeholder = 'Enter new artist name';
    nameInput.classList.add('artist__form-name');
    element.append(nameInput);

    const urlInput = document.createElement('input');
    urlInput.type = 'text';
    urlInput.placeholder = 'Enter Image URL';
    urlInput.classList.add('artist__form-url');
    element.append(urlInput);

    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit New Artist";
    submitButton.classList.add('artist__form-submit');
    element.append(submitButton);

    submitButton.addEventListener('click', () => {
        const newArtist = {
            "artistName": nameInput.value,
            "imageUrl": urlInput.value
        }
        postNewArtist(newArtist)
            .then(artists => {
                renderAllArtists(element, artists)
            })
    })
}