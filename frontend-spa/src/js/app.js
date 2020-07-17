const fetchArtists = async () => {
    return fetch("http://localhost:8080/api/artists/").then((response) =>
        response.json()
    );
};

const renderAllArtists = (element, artists) => {
    clearElementChildren(element);

    element.innerHTML = `
           <h2>Please select from Artists below:</h2>
        `;
    for (let i = 0; i < artists.length; i++) {
        const musiclib = document.createElement('musiclib');
        musiclib.classList.add('artist');
        musiclib.innerHTML = `
            <h4 class="artist__name">${artists[i].artistName}</h4>          
        `;

        musiclib.addEventListener('click', () => {
            renderArtist(element, artists[i]);
        });
        element.append(musiclib);
    }
    ;
}

const renderArtist = (element, artist) => {
    clearElementChildren(element);
    element.innerHTML = `
      <musiclib class="artist">
        <h2 class="artist__name">${artist.artistName}</h2>
        <h4 class="artist__imageurl">${artist.imageUrl}</h4>            
      </musiclib>
  `
    const albums = document.createElement('ul');

    artist.albums.forEach((album) => {
        const li = document.createElement('li');
        li.innerHTML = `<a class = "album__name">${album.albumName}</a>`
        li.addEventListener('click', () => {
            alert(`You clicked on ${album.albumName}!`)
        })
        albums.append(li);
    })
    const backHomeLink = document.createElement('a');
    backHomeLink.innerText = "Show All Artists"
    backHomeLink.addEventListener('click', () => {
        fetchArtists()
            .then(artists => {
                renderAllArtists(library, artists)
            });
    })
    element.append(albums);
    element.append(backHomeLink);
}

const clearElementChildren = element => {
    while (element.firstChild) {
        element.firstChild.remove();
    }
}

const library = document.querySelector(".library")
fetchArtists()
    .then(artists => {
        console.log(artists);
        renderAllArtists(library, artists)
    })

// const createArtistsView = (artists) => {
//     const artistsView = document.createElement("main");
//     artistsView.classList.add("artists");
//     artistsView.innerHTML = `
//   <h2>Please select from Artists below:</h2>
//     `;
//     const ul = document.createElement("ul");
//     artists.forEach((artist) => {
//         const li = document.createElement("li");
//
//         li.innerHTML += artist.artistName;
//         li.addEventListener('click', () => {
//             renderArtist(element, artist);
//         });
//         ul.append(li);
//     });
//     artistsView.append(ul);
//
//     return artistsView;
// };
//
// fetchArtists().then((artists) => renderArtists(artists));
//
// const renderArtists = (artistsToDisplay) => {
//
//     const artistsView = document.querySelector(".artists");
//     console.log(artistsToDisplay);
//     artistsView.appendChild(createArtistsView(artistsToDisplay));
// };
