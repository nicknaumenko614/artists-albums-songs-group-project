import {clearElementChildren} from "./utils.js";
import {fetchSongs} from "./apiHelper.js";
import {library} from "./app.js";
import {renderAllSongs} from "./allSongsView.js";

const renderSong = (element, song) => {
    clearElementChildren(element);
    element.innerHTML = `
        
      <section class="song">
        <br>
        <h2 class="song__name">${song.songName}</h2>
        <h4 class="song__imageurl">${song.imageUrl}</h4>  
        <h4 class="song__duration">${song.duration}</h4>    
        <br>      
      </section>
  `
    const backHomeLink = document.createElement('a');
    backHomeLink.innerText = "View All Songs in playlist"
    backHomeLink.addEventListener('click', () => {
        fetchSongs()
            .then(songs => {
                renderAllSongs(library, songs)
            });
    })

    element.append(backHomeLink);
}

export {renderSong}