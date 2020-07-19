import {clearElementChildren} from "./utils.js";
import {renderAlbum} from "./app.js";

const renderAllAlbums = (element, albums) => {
    clearElementChildren(element);

    element.innerHTML = `
         <h2>Please select from Albums below:</h2>
      `;
    for (let i = 0; i < albums.length; i++) {
        const section = document.createElement('section');
        section.classList.add('album');
        section.innerHTML = `
          <h4 class="album__name">${albums[i].albumName}</h4> 
          <h4 class="album__imageurl">${albums[i].imageUrl}</h4>  
          <h4 class="album__record-label">${albums[i].recordLabel}</h4>    
          <br>     
      `;
        console.log(albums)

        section.addEventListener('click', () => {
            renderAlbum(element, albums[i]);
        });
        element.append(section);

    }
    ;
}

export {renderAllAlbums}

