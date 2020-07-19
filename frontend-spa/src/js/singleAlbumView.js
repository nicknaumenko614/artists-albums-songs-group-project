
import {clearElementChildren} from "./utils.js";
import {fetchAlbums} from "./apiHelper.js";
import {renderAllAlbums} from "./allAlbumsView.js";
import {library, renderSong} from "./app.js";



const renderAlbum = (element, album) => {
    clearElementChildren(element);
    element.innerHTML = `
    <section class="album">
      <h2 class="album__name">${album.albumName}</h2>
      <h4 class="album__imageurl">${album.imageUrl}</h4>  
      <h4 class="album__record-label">${album.recordLabel}</h4> 
                
    </section>
`
    const songs = document.createElement('ul');

    album.songs.forEach((song) => {
        const li = document.createElement('li');
        li.innerHTML = `<a class = "song__name">${song.songName}</a>`

        songs.append(li);
        li.addEventListener('click', () => {
            renderSong(element, song)
        })
    })
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

export {renderAlbum}
