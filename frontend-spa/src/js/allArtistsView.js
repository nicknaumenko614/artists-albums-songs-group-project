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
    artistsList.classList.add("allArtistsList")

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
    const div = document.createElement("div")
    div.classList.add("inputForm")
    const nameInput = document.createElement('input');
    nameInput.type = 'text';
    nameInput.placeholder = 'Enter new artist name';
    nameInput.classList.add('artist__form-name');
    div.append(nameInput);

    const urlInput = document.createElement('input');
    urlInput.type = 'text';
    urlInput.placeholder = 'Enter Image URL';
    urlInput.classList.add('artist__form-url');
    div.append(urlInput);

    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit New Artist";
    submitButton.classList.add('artist__form-submit');
    div.append(submitButton);

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
    element.append(div)
}