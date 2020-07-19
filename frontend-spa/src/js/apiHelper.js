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

export {
    fetchArtists, fetchSongs, fetchAlbums
}