import {clearElementChildren} from "./utils.js";
import {renderSong} from "./singleSongView.js";

const renderAllSongs = (element, songs) => {
    clearElementChildren(element);


    element.innerHTML = `
         <h2>Please select from Albums below:</h2>
      `;
    for (let i = 0; i < songs.length; i++) {
        const section = document.createElement('section');
        section.classList.add('song');
        section.innerHTML = `
          <br>
          <h4 class="song__name">${songs[i].songName}</h4> 
          <h4 class="song__imageurl">${songs[i].imageUrl}</h4>  
          <h4 class="song__duration">${songs[i].duration}</h4>    
          <br>     
      `;

        section.addEventListener('click', () => {
            renderSong(element, songs[i]);
        });
        element.append(section);

    }
    ;
}

export {renderAllSongs}