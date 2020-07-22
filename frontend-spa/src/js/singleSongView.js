import {clearElementChildren} from "./utils.js";
import {fetchAlbumById} from "./apiHelper.js";
import {library} from "./app.js";
import {renderAlbum} from "./app.js";
import {deleteSong} from "./apiHelper.js";
import {addNewCommentToSong} from "./apiHelper.js";

const renderSong = (element, song, albumId, artistId) => {
    clearElementChildren(element);
    element.innerHTML = `
        
      <section class="song">
        <br>
        <h2 class="song__name">${song.songName}</h2>
        <iframe width="560" height="315" src="${song.imageUrl}"?controls=0" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        <h4 class="song__duration">${song.duration}</h4>    
        <br>      
      </section>
  `
    const backToAlbumButton = document.createElement('button');
    backToAlbumButton.innerText = "Back to Album"
    backToAlbumButton.classList.add = "back__button"
    backToAlbumButton.addEventListener('click', () => {
        fetchAlbumById(albumId)
            .then(album => {
                renderAlbum(library, album, artistId)
            });
    })

    const deleteSongButton = document.createElement('button');
    deleteSongButton.innerText = "Delete This Song"
    deleteSongButton.classList.add = "delete__button"
    deleteSongButton.addEventListener('click', () => {
        deleteSong(song.id, albumId)
            .then(album => {
                renderAlbum(library, album, artistId)
            });
    })

    const comments = document.createElement('section');
    if (song.comments != null) {
        song.comments.forEach((comment) => {
            const li = document.createElement('li');
            li.innerHTML = `<a class = "comment__name">${comment}</a>`
            comments.append(li);
        })
    }


    addCommentToSong(element, song.id)


    // const backHomeLink = document.createElement('a');
    // backHomeLink.innerText = "View All Songs in playlist"
    // backHomeLink.addEventListener('click', () => {
    //     fetchSongs()
    //         .then(songs => {
    //             renderAllSongs(library, songs)
    //         });
    // })

    element.append(comments);
    element.append(backToAlbumButton);
    element.append(deleteSongButton);
    // element.append(backHomeLink)
}

function addCommentToSong(element, songId) {
console.log(songId)

    const textInput = document.createElement('input');
    textInput.type = 'textarea';
    textInput.placeholder = 'Enter Your Comment';
    textInput.classList.add('song__comment');
    element.append(textInput);



    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit Comment";
    submitButton.classList.add('song__comment-form-submit');
    element.append(submitButton);

    submitButton.addEventListener('click', () => {
    console.log(textInput.value)
        addNewCommentToSong(textInput.value, songId)
            .then(song => {
                renderSong(element, song)
            })
    })
}

export {renderSong}