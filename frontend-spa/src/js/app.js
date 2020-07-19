const fetchArtists = async () => {
    return fetch("http://localhost:8080/api/artists/").then((response) =>
        response.json()
    );
};

const fetchAlbums = async () => {
    return fetch("http://localhost:8080/api/albums/").then((response) =>
        response.json()
    );
};

const fetchSongs = async () => {
    return fetch("http://localhost:8080/api/songs/").then((response) =>
        response.json()
    );
};

//ALL ARTISTS
const renderAllArtists = (element, artists) => {
    clearElementChildren(element);

    element.innerHTML = `
           <h2>Please select from Artists below:</h2>
        `;
    for (let i = 0; i < artists.length; i++) {
        const section = document.createElement('section');
        section.classList.add('artist');
        section.innerHTML = `
            <h4 class="artist__name">${artists[i].artistName}</h4>          
        `;

        section.addEventListener('click', () => {
            renderArtist(element, artists[i]);
        });
        element.append(section);
    }
    ;
}

// ONE ARTIST
const renderArtist = (element, artist) => {
    clearElementChildren(element);
    element.innerHTML = `

      <section class="artist">
        <h2 class="artist__name">${artist.artistName}</h2>
        <h4 class="artist__imageurl">${artist.imageUrl}</h4>  
        <h2>Please select from Albums below:</h2>
        
                  
      </section>
  `
    const albums = document.createElement('ul');

    artist.albums.forEach((album) => {
        const li = document.createElement('li');
        li.innerHTML = `<a class = "album__name">${album.albumName}</a>`

        albums.append(li);
        li.addEventListener('click', () => {
            //   alert(album.albumName);
            renderAlbum(element, album);
        })
    })
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

// ALL ALBUMS
const renderAllAlbums = (element, albums) => {
    clearElementChildren(element);

    element.innerHTML = `
         <h2>Please select from Albums below:</h2>
      `;
    for (let i = 0; i < albums.length; i++) {
        const section = document.createElement('section');
        section.classList.add('album');
        section.innerHTML = `
          <h4 class="album__name">${albums[i].albumName}</h4> 
          <h4 class="album__imageurl">${albums[i].imageUrl}</h4>  
          <h4 class="album__record-label">${albums[i].recordLabel}</h4>    
          <br>     
      `;
        console.log(albums)

        section.addEventListener('click', () => {
            renderAlbum(element, albums[i]);
        });
        element.append(section);

    }
    ;
}


// ONE ALBUM
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

// UTILS
const clearElementChildren = element => {
    while (element.firstChild) {
        element.firstChild.remove();
    }
}

const library = document.querySelector(".library")
fetchArtists()
    .then(artists => {
        renderAllArtists(library, artists)
    })

