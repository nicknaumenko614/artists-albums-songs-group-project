import {clearElementChildren} from "./utils.js";
import {renderArtist} from "./singleArtistView.js";

const renderAllArtists = (element, artists) => {
    clearElementChildren(element);

    element.innerHTML = `
           <h2>Please select from Artists below:</h2>
           <br>
        `;
    for (let i = 0; i < artists.length; i++) {
        const section = document.createElement('section');
        section.classList.add('artist');
        section.innerHTML = `
            <h4 class="artist__name">${artists[i].artistName}</h4>  
                
        `;

        section.addEventListener('click', () => {
            renderArtist(element, artists[i]);
        });
        element.append(section);
    }
    ;
}

export {
    renderAllArtists
}