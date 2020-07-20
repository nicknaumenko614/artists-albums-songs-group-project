import {clearElementChildren} from "./utils.js";
import {fetchAlbums} from "./apiHelper.js";
import {renderAllAlbums} from "./allAlbumsView.js";
import {renderSong} from "./singleSongView.js";
import {library} from "./app.js"
import {patchNewSongToAlbum} from "./apiHelper.js";

const renderAlbum = (element, album) => {
    clearElementChildren(element);
    element.innerHTML = `
    <section class="album">
      <h2 class="album__name">${album.albumName}</h2>
      <h4 class="album__record-label">Record Label: ${album.recordLabel}</h4> 
      <img src="${album.imageUrl}" alt="Artist Image" width="300">
      <br>
      <h2>Please select a song from the ${album.albumName} album:</h2>
                
    </section>
`
    const songs = document.createElement('ul');

    if (album.songs != null) {
        album.songs.forEach((song) => {
            const li = document.createElement('li');
            li.innerHTML = `<a class = "song__name">${song.songName}</a>`

            songs.append(li);
            li.addEventListener('click', () => {
                renderSong(element, song)
            })
        })
    }

    displayAddSongToAlbumForm(element, album.id);

    const backHomeLink = document.createElement('a');
    backHomeLink.innerText = "View All Albums in Playlist"
    backHomeLink.addEventListener('click', () => {
        fetchAlbums()
            .then(albums => {
                renderAllAlbums(library, albums)
            });
    })
    element.append(songs);
    element.append(backHomeLink);
}

function displayAddSongToAlbumForm(element, albumId) {
    const nameInput = document.createElement('input');
    nameInput.type = 'text';
    nameInput.placeholder = 'Enter new song name';
    nameInput.classList.add('song__form-name');
    element.append(nameInput);

    const urlInput = document.createElement('input');
    urlInput.type = 'text';
    urlInput.placeholder = 'Enter song URL';
    urlInput.classList.add('song__form-url');
    element.append(urlInput);

    const duration = document.createElement('input');
    duration.type = 'text';
    duration.placeholder = 'Enter song duration';
    duration.classList.add('song__form-duration');
    element.append(duration);

    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit New Song";
    submitButton.classList.add('song__form-submit');
    element.append(submitButton);

    submitButton.addEventListener('click', () => {
        const newSong = {
            "songName": nameInput.value,
            "imageUrl": urlInput.value,
            "duration": duration.value
        }
        patchNewSongToAlbum(newSong, albumId)
            .then(album => {
                renderAlbum(element, album)
            })
    })
}

export {renderAlbum}
