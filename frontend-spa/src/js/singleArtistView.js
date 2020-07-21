import {clearElementChildren} from "./utils.js";
import {fetchArtists} from "./apiHelper.js";
import {renderAllArtists} from "./allArtistsView.js";
import {renderAlbum} from "./app.js";
import {library} from "./app.js";
import {patchNewAlbumToArtist} from "./apiHelper.js";
import {deleteArtist} from "./apiHelper.js";

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
                renderAlbum(element, album, artist.id);
            })
        })
    }

    displayAddAlbumToArtistForm(element, artist.id);

    const backHomeButton = document.createElement('button');
    backHomeButton.innerText = "Back to HOME - All Artists"
    backHomeButton.classList.add('back__button')
    backHomeButton.addEventListener('click', () => {
        fetchArtists()
            .then(artists => {
                renderAllArtists(library, artists)
            });
    })

    const deleteArtistButton = document.createElement('button');
    deleteArtistButton.innerText = "Delete This Artist"
    deleteArtistButton.classList.add = "delete__button"
    console.log(artist.id)
    deleteArtistButton.addEventListener('click', () => {
        deleteArtist(artist.id)
            .then(artists => {
                renderAllArtists(library, artists)
            });
    })
    element.append(albums);
    element.append(backHomeButton);
    element.append(deleteArtistButton)


}




function displayAddAlbumToArtistForm(element, artistId) {
    const nameInput = document.createElement('input');
    nameInput.type = 'text';
    nameInput.placeholder = 'Enter new album name';
    nameInput.classList.add('album__form-name');
    element.append(nameInput);

    const urlInput = document.createElement('input');
    urlInput.type = 'text';
    urlInput.placeholder = 'Enter Album URL';
    urlInput.classList.add('album__form-url');
    element.append(urlInput);

    const recordLabel = document.createElement('input');
    recordLabel.type = 'text';
    recordLabel.placeholder = 'Enter Record Label';
    recordLabel.classList.add('album__form-recordlabel');
    element.append(recordLabel);

    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit New Album";
    submitButton.classList.add('album__form-submit');
    element.append(submitButton);

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

    
}

export {renderArtist}