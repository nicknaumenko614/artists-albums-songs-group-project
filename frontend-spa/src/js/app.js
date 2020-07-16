const renderAllArtists = (element, artists) => {
  clearElementChildren(element);

  for (let i = 0; i < artists.length; i++) {
    const article = document.createElement("article");
    article.classList.add("artist");
    article.innerHTML = `
    <h2>Please click an artist below to see their music repertoire</h2>
        <ul>
        <li><a href="/frontend-spa/src/static/artist.html">Bjork</a></li>
        </ul>
        <h3>Add a new artist below</h3>
    <form action="">
        <div class="input-align">
            <label for="artist__name">Artist Name: </label>
            <input type="text" />
            <br>
            <label for="artist__image">Artist Picture URL: </label>
            <input type="text" />
            <br>
            <button>Submit</button>
        </div>
    </form>
        `;
        article.addEventListener('click', () => {
            renderArtist(element, artists[i]);
          });
          element.append(article);
  };
}

const renderArtist = (element, artist) => {
    clearElementChildren(element);
    element.innerHTML = `
        <article class="artist">
        <ul>
        <li class="artist__name">${artist.artistName}</li>
        </ul>           
        </article>
    `
    const products = document.createElement('ul');


    // =============================
//for(product of vendor.products){...}
artist.albums.forEach((album) => {
    const li = document.createElement('li');
    li.innerHTML = `<a class = "album__name">${album.albumName}</a>`
    li.addEventListener('click', () => {
      alert(`You clicked on ${album.albumName}!`)
    })
    albums.append(li);
  })
  const backHomeLink = document.createElement('a');
  backHomeLink.innerText = "Go Back to All Artists"
  backHomeLink.addEventListener('click', () => {
    fetchArtists()
      .then(artists => {
        renderAllArtists(catalog, artists)
      });
  })
  element.append(albums);
  element.append(backHomeLink);
}

const fetchArtists = async () => {
  return fetch('http://localhost:8080/api/artists/')
    .then(response => response.json())
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
  const renderArtist = async () => {
    return fetch('http://localhost:8080/api/artists/')
        .then(response => response.json())
}