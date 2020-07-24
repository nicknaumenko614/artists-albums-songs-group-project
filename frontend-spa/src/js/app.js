import {
    fetchArtists
} from "./apiHelper.js";

import {
    renderAllArtists
} from "./allArtistsView.js";

import {renderAlbum} from "./singleAlbumView.js";

const library = document.querySelector(".library")
fetchArtists()
    .then(artists => {
        renderAllArtists(library, artists)
    })


export {renderAlbum, library}
