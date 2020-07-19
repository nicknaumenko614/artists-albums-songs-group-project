import {clearElementChildren} from "./utils.js";
import {fetchArtists} from "./apiHelper.js";
import {renderAllArtists} from "./allArtistsView.js";
import {renderAlbum} from "./app.js";
import {library} from "./app.js";

const renderArtist = (element, artist) => {
    clearElementChildren(element);
    element.innerHTML = `

      <section class="artist">
        <h2 class="artist__name">${artist.artistName}</h2>
        <img src="${artist.imageUrl}" alt="Artist Image" width="300">  
        <br>
        <h2>Please select from ${artist.artistName}'s Albums below:</h2>
                  
      </section>
  `
    const albums = document.createElement('ul');

    if (artist.albums != null) {
        artist.albums.forEach((album) => {
            const li = document.createElement('li');
            li.innerHTML = `<a class = "album__name">${album.albumName}</a>`

            albums.append(li);
            li.addEventListener('click', () => {
                renderAlbum(element, album);
            })
        })
    }

    const backHomeLink = document.createElement('a');
    backHomeLink.innerText = "View All Artists in Playlist"
    backHomeLink.addEventListener('click', () => {
        fetchArtists()
            .then(artists => {
                renderAllArtists(library, artists)
            });
    })
    element.append(albums);
    element.append(backHomeLink);
}

export {renderArtist}