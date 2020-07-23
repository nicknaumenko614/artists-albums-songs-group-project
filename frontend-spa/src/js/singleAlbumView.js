import {clearElementChildren} from "./utils.js";
import {fetchArtistById} from "./apiHelper.js";
import {renderSong} from "./singleSongView.js";
import {library} from "./app.js"
import {patchNewSongToAlbum} from "./apiHelper.js";
import {renderArtist} from "./singleArtistView.js";
import {deleteAlbum} from "./apiHelper.js"
import {addNewCommentToAlbum} from "./apiHelper.js";


const renderAlbum = (element, album, artistId) => {
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
                renderSong(element, song, album.id, artistId)
            })
        })
    }

    displayAddSongToAlbumForm(element, album.id, artistId);

    const backToArtistButton = document.createElement('button');
    backToArtistButton.innerText = "Back to Artist"
    backToArtistButton.classList.add = "back__button"
    backToArtistButton.addEventListener('click', () => {
        fetchArtistById(artistId)
            .then(artist => {
                renderArtist(library, artist)
            });
    })

    const deleteAlbumButton = document.createElement('button');
    deleteAlbumButton.innerText = "Delete This Album"
    deleteAlbumButton.classList.add = "delete__button"
    deleteAlbumButton.addEventListener('click', () => {
        deleteAlbum(album.id, artistId)
            .then(artist => {
                renderArtist(library, artist, artistId)
            });
    })

    // const backHomeLink = document.createElement('a');
    // backHomeLink.innerText = "View All Albums in Playlist"
    // backHomeLink.addEventListener('click', () => {
    //     fetchAlbums()
    //         .then(albums => {
    //             renderAllAlbums(library, albums)
    //         });
    // })
    const comments = document.createElement('section');
    if (album.comments != null) {
        album.comments.forEach((comment) => {
            const li = document.createElement('li');
            li.innerText = JSON.parse(comment);
            comments.append(li);
        })
    }

    const commentDisplay = document.createElement('section');
    commentDisplay.innerHTML = '<h2>Comments for the album:</h2>'




    addCommentToAlbum(element, album.id)



    element.append(songs);
    element.append(backToArtistButton);
    element.append(deleteAlbumButton);
    element.append(commentDisplay);
    element.append(comments);
    //element.append(backHomeLink)
}

function displayAddSongToAlbumForm(element, albumId, artistId) {
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
                renderAlbum(element, album, artistId)
            })
    })
}

function addCommentToAlbum(element, albumId) {

    const textInput = document.createElement('input');
    textInput.type = 'textarea';
    textInput.placeholder = 'Enter Your Comment';
    textInput.classList.add('album__comment');
    element.append(textInput);



    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit Comment";
    submitButton.classList.add('album__comment-form-submit');
    element.append(submitButton);

    submitButton.addEventListener('click', () => {

        addNewCommentToAlbum(textInput.value, albumId)
            .then(album => {
                renderAlbum(element, album)
            })
    })
}


export {renderAlbum}
