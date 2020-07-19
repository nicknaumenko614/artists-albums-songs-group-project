import {
    fetchSongs, fetchArtists
} from "./apiHelper.js";

import {
    clearElementChildren
} from "./utils.js";

import {
    renderAllArtists
} from "./allArtistsView.js";

import {renderAlbum} from "./singleAlbumView.js";


//ALL SONGS
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

// ONE SONG
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


const library = document.querySelector(".library")
fetchArtists()
    .then(artists => {
        renderAllArtists(library, artists)
    })

export {renderAlbum, renderSong, library}
