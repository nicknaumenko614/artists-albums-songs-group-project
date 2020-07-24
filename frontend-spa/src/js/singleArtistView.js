import {clearElementChildren} from "./utils.js";
import {fetchArtists} from "./apiHelper.js";
import {renderAllArtists} from "./allArtistsView.js";
import {renderAlbum} from "./app.js";
import {library} from "./app.js";
import {patchNewAlbumToArtist} from "./apiHelper.js";
import {deleteArtist} from "./apiHelper.js";
import {addNewCommentToArtist} from "./apiHelper.js";

const renderArtist = (element, artist) => {
    clearElementChildren(element);
    element.innerHTML = `

      <section class="artist">
        <h2 class="artist__name">Artist: ${artist.artistName}</h2>
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
                renderAlbum(element, album, artist.id);
            })
        })
    }



    const backHomeButton = document.createElement('button');
    backHomeButton.innerText = "Back to HOME - All Artists"
    backHomeButton.classList.add ('backButton');
    backHomeButton.addEventListener('click', () => {
        fetchArtists()
            .then(artists => {
                renderAllArtists(library, artists)
            });
    })

    const deleteArtistButton = document.createElement('button');
    deleteArtistButton.innerText = "Delete This Artist"
    deleteArtistButton.classList.add ('deleteButton');
    console.log(artist.id)
    deleteArtistButton.addEventListener('click', () => {
        deleteArtist(artist.id)
            .then(artists => {
                renderAllArtists(library, artists)
            });
    })

    const comments = document.createElement('section');
    comments.classList.add ('commentsDisplay')
    if (artist.comments != null) {
        artist.comments.forEach((comment) => {
            const li = document.createElement('li');
            li.classList.add('singleCommentItem')
            li.innerText = JSON.parse(comment);
            comments.append(li);
        })
    }

    const commentDisplay = document.createElement('section');
    commentDisplay.innerHTML = '<h2>Comments for the artist:</h2>'




    element.append(albums);
    displayAddAlbumToArtistForm(element, artist.id);
    element.append(backHomeButton);
    element.append(deleteArtistButton);

    element.append(commentDisplay);
    element.append(comments);

    addCommentToArtist(element, artist.id)
}

// function displayNavBar(element) {
//     const headerNav = document.createElement("header")
//     headerNav.classList.add("topnav")
//
//     const homeLink = document.createElement("a");
//     homeLink.innerText = "Back to HOME - All Artists";
//     homeLink.classList.add("homeLink");
//     headerNav.append(homeLink)
//
//     homeLink.addEventListener('click', () => {
//         fetchArtists()
//             .then(artists => {
//                 renderAllArtists(library, artists)
//             })
//     })
//     element.append(headerNav)
// }

function displayAddAlbumToArtistForm(element, artistId) {
    const div = document.createElement("div")
    div.classList.add("inputForm")
    const nameInput = document.createElement('input');
    nameInput.type = 'text';
    nameInput.placeholder = 'Enter new album name';
    nameInput.classList.add('album__form-name');
    div.append(nameInput);

    const urlInput = document.createElement('input');
    urlInput.type = 'text';
    urlInput.placeholder = 'Enter Album URL';
    urlInput.classList.add('album__form-url');
    div.append(urlInput);

    const recordLabel = document.createElement('input');
    recordLabel.type = 'text';
    recordLabel.placeholder = 'Enter Record Label';
    recordLabel.classList.add('album__form-recordlabel');
    div.append(recordLabel);

    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit New Album";
    submitButton.classList.add('submitButton');
    div.append(submitButton);

   submitButton.addEventListener('click', () => {
        const newAlbum = {
            "albumName": nameInput.value,
            "imageUrl": urlInput.value,
            "recordLabel": recordLabel.value
        }
        patchNewAlbumToArtist(newAlbum, artistId)
            .then(artist => {
                renderArtist(element, artist)
            })
    })
    element.append(div)

    
}

function addCommentToArtist(element, artistId) {
    const div = document.createElement("div")
    div.classList.add("inputForm")

    const textInput = document.createElement('input');
    textInput.type = 'textarea';
    textInput.placeholder = 'Enter Your Comment';
    textInput.classList.add('album__comment');
    div.append(textInput);



    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit Comment";
    submitButton.classList.add('album__comment-form-submit');
    div.append(submitButton);

    submitButton.addEventListener('click', () => {
        console.log(textInput.value)
        addNewCommentToArtist(textInput.value, artistId)
            .then(artist => {
                renderArtist(element, artist)
            })
    })
    element.append(div)
}

export {renderArtist}