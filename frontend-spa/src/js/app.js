const fetchArtists = async () => {
  return fetch("http://localhost:8080/api/artists/").then((response) =>
    response.json()
  );
};

const createArtistsView = (artists) => {
  const artistsView = document.createElement("main");
  artistsView.classList.add("artists");
  artistsView.innerHTML = `
  <h2>Please select from Artists below:</h2>
    `;
  const ul = document.createElement("ul");
  artists.forEach((artist) => {
    const li = document.createElement("li");

    li.innerHTML += artist.artistName;
    ul.append(li);
  });
  artistsView.append(ul);

  return artistsView;
};

fetchArtists().then((artists) => renderArtists(artists));

const renderArtists = (artistsToDisplay) => {
  
  const artistsView = document.querySelector(".artists");
  console.log(artistsToDisplay);
  artistsView.appendChild(createArtistsView(artistsToDisplay));
};
