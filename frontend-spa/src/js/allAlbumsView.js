import {clearElementChildren} from "./utils.js";
import {renderAlbum} from "./app.js";

const renderAllAlbums = (element, albums, artistId) => {
    clearElementChildren(element);

    element.innerHTML = `
         <h2>Please select from Albums below:</h2>
      `;
    for (let i = 0; i < albums.length; i++) {
        const section = document.createElement('section');
        section.classList.add('album');
        section.innerHTML = `
          <img src="${albums[i].imageUrl}" alt="Album Image" width="80"> 
          <h4 class="album__name">Album Name: ${albums[i].albumName}</h4> 
          <h4 class="album__record-label">Record Label: ${albums[i].recordLabel}</h4>  
          <br>     
      `;

        section.addEventListener('click', () => {
            renderAlbum(element, albums[i], artistId);
        });
        element.append(section);

    }
    ;
}

export {renderAllAlbums}

